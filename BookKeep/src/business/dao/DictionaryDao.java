package business.dao;

import java.util.List;

import Model.TDictionaryInfo;

public interface DictionaryDao {
	/**
	 * 获取所有字典信息
	 * 
	 * @return
	 */
	public List<TDictionaryInfo> GetAllDicInfo();

	/**
	 * 获取收入类型字典信息
	 * 
	 * @return
	 */
	public List<TDictionaryInfo> GetInCome();

	/**
	 * 获取支出类型字典信息
	 * 
	 * @return
	 */
	public List<TDictionaryInfo> GetPay();
}
