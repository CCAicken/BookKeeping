package business.dao;

import Model.TUser;

public interface UserDao {
	/**
	 * 判断用户是否已存在
	 * 
	 * @param userID
	 * 
	 *            true 已存在 false 不存在
	 */
	public boolean isExist(String userid);

	/**
	 * 添加用户
	 * 
	 * @param user
	 *            用户实体
	 * 
	 */
	public String insert(TUser user);

}
