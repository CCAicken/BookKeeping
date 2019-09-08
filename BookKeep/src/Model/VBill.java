package Model;


/**
 * VBill entity. @author MyEclipse Persistence Tools
 */

public class VBill implements java.io.Serializable {

	// Fields

	private String userId;
	private String username;
	private String password;
	private String tel;
	private Integer billId;
	private String createTime;
	private Double money;
	private String billType;
	private String consumptionType;
	private String remarks;
	private String typeName;
	private String dicMarks;
	private String dictionaryName;
	private String dictionaryType;
	private String content;
	private String sortNum;

	// Constructors

	/** default constructor */
	public VBill() {
	}

	/** minimal constructor */
	public VBill(String userId, String username, String password, String tel,
			Integer billId, String createTime, Double money, String billType,
			String consumptionType, String typeName, String dictionaryName,
			String dictionaryType) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.tel = tel;
		this.billId = billId;
		this.createTime = createTime;
		this.money = money;
		this.billType = billType;
		this.consumptionType = consumptionType;
		this.typeName = typeName;
		this.dictionaryName = dictionaryName;
		this.dictionaryType = dictionaryType;
	}

	/** full constructor */
	public VBill(String userId, String username, String password, String tel,
			Integer billId, String createTime, Double money, String billType,
			String consumptionType, String remarks, String typeName,
			String dicMarks, String dictionaryName, String dictionaryType,
			String content, String sortNum) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.tel = tel;
		this.billId = billId;
		this.createTime = createTime;
		this.money = money;
		this.billType = billType;
		this.consumptionType = consumptionType;
		this.remarks = remarks;
		this.typeName = typeName;
		this.dicMarks = dicMarks;
		this.dictionaryName = dictionaryName;
		this.dictionaryType = dictionaryType;
		this.content = content;
		this.sortNum = sortNum;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getBillId() {
		return this.billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Double getMoney() {
		return this.money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getBillType() {
		return this.billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public String getConsumptionType() {
		return this.consumptionType;
	}

	public void setConsumptionType(String consumptionType) {
		this.consumptionType = consumptionType;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getDicMarks() {
		return this.dicMarks;
	}

	public void setDicMarks(String dicMarks) {
		this.dicMarks = dicMarks;
	}

	public String getDictionaryName() {
		return this.dictionaryName;
	}

	public void setDictionaryName(String dictionaryName) {
		this.dictionaryName = dictionaryName;
	}

	public String getDictionaryType() {
		return this.dictionaryType;
	}

	public void setDictionaryType(String dictionaryType) {
		this.dictionaryType = dictionaryType;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSortNum() {
		return this.sortNum;
	}

	public void setSortNum(String sortNum) {
		this.sortNum = sortNum;
	}

}