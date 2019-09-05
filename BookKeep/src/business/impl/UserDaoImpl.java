package business.impl;

import Basic.iHibBaseDAO;
import Basic.iHibBaseDAOImpl;
import Model.TUser;
import business.dao.UserDao;

public class UserDaoImpl implements UserDao {
	private iHibBaseDAO bdao;

	public UserDaoImpl() {
		bdao = new iHibBaseDAOImpl();
	}

	@Override
	public boolean isExist(String userid) {
		TUser user = (TUser) bdao.findById(TUser.class, userid);
		if (user != null && user.getUserId() != null)
			return true;
		else
			return false;
	}

	@Override
	public String insert(TUser user) {
		return (String) bdao.insert(user);
	}

}
