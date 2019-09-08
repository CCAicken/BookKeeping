package business.impl;

import java.util.List;

import Basic.iHibBaseDAO;
import Basic.iHibBaseDAOImpl;
import Model.TDictionaryInfo;
import business.dao.DictionaryDao;

public class DictionaryDaoImpl implements DictionaryDao {

	private iHibBaseDAO bdao;

	public DictionaryDaoImpl() {
		bdao = new iHibBaseDAOImpl();
	}

	@Override
	public List<TDictionaryInfo> GetAllDicInfo() {
		String hql = "from TDictionaryInfo";
		List<TDictionaryInfo> list = bdao.select(hql);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	@Override
	public List<TDictionaryInfo> GetInCome() {
		// TODO Auto-generated method stub
		String hql = "from TDictionaryInfo where dictionaryType=0";
		List<TDictionaryInfo> list = bdao.select(hql);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	@Override
	public List<TDictionaryInfo> GetPay() {
		// TODO Auto-generated method stub
		String hql = "from TDictionaryInfo where dictionaryType=1";
		List<TDictionaryInfo> list = bdao.select(hql);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
}
