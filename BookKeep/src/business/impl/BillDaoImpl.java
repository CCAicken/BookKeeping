package business.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import util.TimeUtil;
import util.yearbilltool;
import Basic.iHibBaseDAO;
import Basic.iHibBaseDAOImpl;
import Model.TBill;
import Model.VBill;
import business.dao.BillDao;

public class BillDaoImpl implements BillDao {
	private iHibBaseDAO bdao;

	public BillDaoImpl() {
		bdao = new iHibBaseDAOImpl();
	}

	@Override
	public int insertBill(TBill bill) {
		Integer id = (Integer) bdao.insert(bill);
		if (id != null) {
			return id;
		}
		return 0;
	}

	@Override
	public boolean updateBill(TBill bill) {

		return bdao.update(bill);
	}

	@Override
	public boolean delBill(int billId) {
		String sql = "delete from T_Bill where billID=?";
		Object[] para = { billId };
		return bdao.delete(sql, para);

	}

	@Override
	public List<VBill> getBillByUser(String userid) {
		String hql = "from TBill where userid=?";
		Object[] para = { userid };
		return bdao.select(hql, para);
	}

	@Override
	public List<VBill> selectByPage(String wherecondition, int startPage,
			int pageSize) {
		String hql = "from VBill ";
		if (wherecondition != null) {
			hql += wherecondition;
		}
		List<VBill> list = bdao.selectByPage(hql, startPage, pageSize);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	@Override
	public List<VBill> getAllBill() {
		String hql = "from VBill ";
		List<VBill> list = bdao.select(hql);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	@Override
	public int getBillCountByUser(String userid) {
		return bdao.selectValue("select count(*) from TBill where userid='"
				+ userid + "'");

	}

	@Override
	public int getBillDaysByUser(String userid) {
		List list = bdao
				.selectBySql("select count(*) from (select DATE_FORMAT(createTime,'%Y-%m-%d') as time From T_Bill where userid='"
						+ userid + "' GROUP BY time) as timetab");
		System.out.println(list.get(0));
		return Integer.parseInt(list.get(0).toString());
	}

	@Override
	public int getBillContinueDaysByUser(String userid) {
		List list = bdao
				.selectBySql("select DATE_FORMAT(createTime,'%Y-%m-%d') as time From T_Bill where userid='"
						+ userid + "' GROUP BY time order by time desc");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		TimeUtil tiemutil = new TimeUtil();
		int days = 0;
		String datetime = df.format(new Date());
		for (int i = 0; i < list.size(); i++) {
			// System.out.println(list.get(i).toString());
			// System.out.println(datetime);
			int day;
			try {
				day = tiemutil.getdays(datetime, list.get(i).toString());
				if (day <= 1) {
					days += 1;
					datetime = list.get(i).toString();
				} else {
					days = 0;
					break;
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}
		}
		return days;
	}

	@Override
	public double getBillInByTime(String userid, String time) {
		// TODO Auto-generated method stub
		String hql = "select sum(money) as money from T_Bill where billtype=0  and createTime like '"
				+ time + "%' and  userid=" + userid;
		List<Double> list = bdao.selectBySql(hql);
		double sumIn = list.get(0).doubleValue();
		return sumIn;
//		if(list!=null&&list.size()!=0){
//			return list.toString();
//		}
//		return sumIn;
	}

	@Override
	public String getBillOutByTime(String userid, String time) {
		String hql = "select sum(money) as money from T_Bill where billtype=1  and createTime like '"
				+ time + "%' and  userid=" + userid;
		List list = bdao.selectBySql(hql);
		String sumIn = "0.00";
		if(list!=null&&list.size()!=0){
			return list.toString();
		}
		return sumIn;
	}

	@Override
	public List<yearbilltool> yearsBillInt(String years, String userid) {
		yearbilltool billtool = new yearbilltool();
		String sql = "select  DATE_FORMAT(createTime,'%Y-%m') as time,sum(money) as money, billtype from T_Bill where billtype=0  and createTime like '"
				+ years + "%' and  userid=" + userid + " GROUP BY time";
		return billtool.toList(bdao.selectBySqlrs(sql));
	}

	@Override
	public List<yearbilltool> yearsBillOut(String years, String userid) {
		yearbilltool billtool = new yearbilltool();

		List<yearbilltool> list = null;
		String sql = "select  DATE_FORMAT(createTime,'%Y-%m') as time,sum(money) as money, billtype from T_Bill where billtype=1  and createTime like '"
				+ years + "%' and  userid=" + userid + " GROUP BY time";

		list = billtool.toList(bdao.selectBySqlrs(sql));
		return list;
	}

	@Override
	public List getBillByBillId(int billid) {
		// TODO Auto-generated method stub
		String hql = "from VBill where billId=?";
		Object[] para = { billid };
		List<VBill> list = bdao.select(hql, para);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	@Override
	public String getDayIn(String strwhere) {
		// TODO Auto-generated method stub
		String hql = "select SUM(money) as dayin from VBill where "+strwhere+" and billType=0";
		List list = bdao.select(hql);
		String dayout="0.00";
		if(list!=null&&list.get(0)!=null){
			dayout = list.get(0).toString();
		}
		return dayout;
	}

	@Override
	public String getDayOut(String strwhere) {
		// TODO Auto-generated method stub
		String hql = "select SUM(money) as dayin from VBill where "+strwhere+" and billType=1";
		List list = bdao.select(hql);
		String dayout="0.00";
		if(list!=null&&list.size()!=0){
			dayout = list.get(0).toString();
		}
		return dayout;
	}

	// public static void main(String[] args) {
	// BillDaoImpl dooo = new BillDaoImpl();
	// List outlist = dooo.yearsBillOut("2019", "1004");
	// List intlist = dooo.yearsBillInt("2019", "1004");
	//
	// for (int i = 0; i < outlist.size(); i++) {
	// System.out.println(outlist.get(i).toString());
	// }
	// }

}
