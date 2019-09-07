package business.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import util.TimeUtil;
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
		String id = (String) bdao.insert(bill);
		if (id != null) {

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
		return (int) list.get(0);
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

	// public static void main(String[] args) {
	// BillDaoImpl dooo = new BillDaoImpl();
	// // List<VBill> list = dooo.getAllBill();
	// // for (VBill vBill : list) {
	// // System.out.println(vBill.getBillId());
	// // }
	// System.out.println(dooo.getBillContinueDaysByUser("1001"));
	// }

}
