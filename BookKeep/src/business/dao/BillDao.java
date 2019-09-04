package business.dao;

import java.util.List;

import Model.TBill;
import Model.VBill;

public interface BillDao {
	/**
	 * ʵ�ֵ��ݵ����
	 * 
	 * @param bill
	 *            ����ʵ��
	 * @return ����id
	 */
	public int insertBill(TBill bill);

	/**
	 * ʵ���˵����޸�
	 * 
	 * @param bill
	 *            �˵�ʵ��
	 * @return �ɹ� true ��ʧ�� false
	 */
	public boolean updateBill(TBill bill);

	/**
	 * �����˵�idɾ���˵�
	 * 
	 * @param billId
	 *            �˵�id
	 * @return �ɹ� true ��ʧ�� false
	 */
	public boolean delBill(int billId);

	/**
	 * �����û�id��ȡ���˻��˵�
	 * 
	 * @param userid
	 *            �˻�id
	 * @return �˵�����
	 */
	public List<VBill> getBillByUser(String userid);

	/**
	 * ����������ѯ�˵���ҳ����
	 * 
	 * @param wherecondition
	 *            ��ѯ����
	 * @param startPage
	 *            ��ʼҳ
	 * @param pageSize
	 *            ÿҳ����
	 * @return �˵���ҳ����
	 */

	public List<VBill> selectByPage(String wherecondition, int startPage,
			int pageSize);

	/**
	 * ��ȡ�����˵�
	 * 
	 * @return �����˵�����
	 */
	public List<VBill> getAllBill();

}
