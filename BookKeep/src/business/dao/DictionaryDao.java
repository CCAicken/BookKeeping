package business.dao;

import java.util.List;

import Model.TDictionaryInfo;

public interface DictionaryDao {
	/**
	 * ��ȡ�����ֵ���Ϣ
	 * 
	 * @return
	 */
	public List<TDictionaryInfo> GetAllDicInfo();

	/**
	 * ��ȡ���������ֵ���Ϣ
	 * 
	 * @return
	 */
	public List<TDictionaryInfo> GetInCome();

	/**
	 * ��ȡ֧�������ֵ���Ϣ
	 * 
	 * @return
	 */
	public List<TDictionaryInfo> GetPay();
}
