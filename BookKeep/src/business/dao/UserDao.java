package business.dao;

import Model.TUser;

public interface UserDao {
	/**
	 * �ж��û��Ƿ��Ѵ���
	 * 
	 * @param userID
	 * 
	 *            true �Ѵ��� false ������
	 */
	public boolean isExist(String userid);

	/**
	 * ����û�
	 * 
	 * @param user
	 *            �û�ʵ��
	 * 
	 */
	public String insert(TUser user);

}
