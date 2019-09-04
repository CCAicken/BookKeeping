package business.impl;

import java.util.List;

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

	// public static void main(String[] args) {
	// BillDaoImpl dooo = new BillDaoImpl();
	// List<VBill> list = dooo.getAllBill();
	// for (VBill vBill : list) {
	// System.out.println(vBill.getBillId());
	// }
	//
	// }

}
