package business.dao;

import java.util.List;

import Model.TBill;
import Model.VBill;

public interface BillDao {
	/**
	 * 实现单据的添加
	 * 
	 * @param bill
	 *            单据实体
	 * @return 主键id
	 */
	public int insertBill(TBill bill);

	/**
	 * 实现账单的修改
	 * 
	 * @param bill
	 *            账单实体
	 * @return 成功 true ，失败 false
	 */
	public boolean updateBill(TBill bill);

	/**
	 * 根据账单id删除账单
	 * 
	 * @param billId
	 *            账单id
	 * @return 成功 true ，失败 false
	 */
	public boolean delBill(int billId);

	/**
	 * 根据用户id获取该账户账单
	 * 
	 * @param userid
	 *            账户id
	 * @return 账单数据
	 */
	public List<VBill> getBillByUser(String userid);

	/**
	 * 根据条件查询账单分页数据
	 * 
	 * @param wherecondition
	 *            查询条件
	 * @param startPage
	 *            起始页
	 * @param pageSize
	 *            每页数量
	 * @return 账单分页数据
	 */

	public List<VBill> selectByPage(String wherecondition, int startPage,
			int pageSize);

	/**
	 * 获取所有账单
	 * 
	 * @return 所有账单数据
	 */
	public List<VBill> getAllBill();

	/**
	 * 根据用户id 获取用户所有账单数
	 * 
	 * @param userid
	 * @return int 账单数
	 */
	public int getBillCountByUser(String userid);

	/**
	 * 根据用户id 获取用户账单天数
	 * 
	 * @param userid
	 *            用户id
	 * @return int 账单天数
	 */
	public int getBillDaysByUser(String userid);

	/**
	 * 根据用户id 获取用户当前连续记账天数
	 * 
	 * @param userid
	 *            用户id
	 * @return int 连续记账天数
	 */
	public int getBillContinueDaysByUser(String userid);

	/**
	 * 根据时间和用户获取用户当月收入总和
	 * 
	 * @param userid
	 * @param time
	 * @return
	 */
	public double getBillInByTime(String userid, String time);

	/**
	 * 根据时间和用户获取用户当月支出总和
	 * 
	 * @param userid
	 * @param time
	 * @return
	 */
	public double getBillOutByTime(String userid, String time);

	/**
	 * 年账单收入
	 * 
	 * @param years
	 * @return
	 */
	public List yearsBillInt(String years, String userid);

	/**
	 * 年账单支出
	 * 
	 * @param years
	 * @return
	 */
	public List yearsBillOut(String years, String userid);

}
