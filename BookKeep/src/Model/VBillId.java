package Model;

import java.sql.Timestamp;

/**
 * VBillId entity. @author MyEclipse Persistence Tools
 */

public class VBillId implements java.io.Serializable {

	// Fields

	private String userId;
	private String username;
	private String password;
	private Integer tel;
	private Integer billId;
	private Timestamp createTime;
	private Double money;
	private String billType;
	private String consumptionType;
	private String remarks;
	private String typeName;
	private String dicMarks;
	private String dictionaryName;
	private String dictionaryType;
	private String content;

	// Constructors

	/** default constructor */
	public VBillId() {
	}

	/** minimal constructor */
	public VBillId(String userId, String username, String password,
			Integer tel, Integer billId, Timestamp createTime, Double money,
			String billType, String consumptionType, String typeName,
			String dictionaryName, String dictionaryType) {
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
	public VBillId(String userId, String username, String password,
			Integer tel, Integer billId, Timestamp createTime, Double money,
			String billType, String consumptionType, String remarks,
			String typeName, String dicMarks, String dictionaryName,
			String dictionaryType, String content) {
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

	public Integer getTel() {
		return this.tel;
	}

	public void setTel(Integer tel) {
		this.tel = tel;
	}

	public Integer getBillId() {
		return this.billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VBillId))
			return false;
		VBillId castOther = (VBillId) other;

		return ((this.getUserId() == castOther.getUserId()) || (this
				.getUserId() != null && castOther.getUserId() != null && this
				.getUserId().equals(castOther.getUserId())))
				&& ((this.getUsername() == castOther.getUsername()) || (this
						.getUsername() != null
						&& castOther.getUsername() != null && this
						.getUsername().equals(castOther.getUsername())))
				&& ((this.getPassword() == castOther.getPassword()) || (this
						.getPassword() != null
						&& castOther.getPassword() != null && this
						.getPassword().equals(castOther.getPassword())))
				&& ((this.getTel() == castOther.getTel()) || (this.getTel() != null
						&& castOther.getTel() != null && this.getTel().equals(
						castOther.getTel())))
				&& ((this.getBillId() == castOther.getBillId()) || (this
						.getBillId() != null && castOther.getBillId() != null && this
						.getBillId().equals(castOther.getBillId())))
				&& ((this.getCreateTime() == castOther.getCreateTime()) || (this
						.getCreateTime() != null
						&& castOther.getCreateTime() != null && this
						.getCreateTime().equals(castOther.getCreateTime())))
				&& ((this.getMoney() == castOther.getMoney()) || (this
						.getMoney() != null && castOther.getMoney() != null && this
						.getMoney().equals(castOther.getMoney())))
				&& ((this.getBillType() == castOther.getBillType()) || (this
						.getBillType() != null
						&& castOther.getBillType() != null && this
						.getBillType().equals(castOther.getBillType())))
				&& ((this.getConsumptionType() == castOther
						.getConsumptionType()) || (this.getConsumptionType() != null
						&& castOther.getConsumptionType() != null && this
						.getConsumptionType().equals(
								castOther.getConsumptionType())))
				&& ((this.getRemarks() == castOther.getRemarks()) || (this
						.getRemarks() != null && castOther.getRemarks() != null && this
						.getRemarks().equals(castOther.getRemarks())))
				&& ((this.getTypeName() == castOther.getTypeName()) || (this
						.getTypeName() != null
						&& castOther.getTypeName() != null && this
						.getTypeName().equals(castOther.getTypeName())))
				&& ((this.getDicMarks() == castOther.getDicMarks()) || (this
						.getDicMarks() != null
						&& castOther.getDicMarks() != null && this
						.getDicMarks().equals(castOther.getDicMarks())))
				&& ((this.getDictionaryName() == castOther.getDictionaryName()) || (this
						.getDictionaryName() != null
						&& castOther.getDictionaryName() != null && this
						.getDictionaryName().equals(
								castOther.getDictionaryName())))
				&& ((this.getDictionaryType() == castOther.getDictionaryType()) || (this
						.getDictionaryType() != null
						&& castOther.getDictionaryType() != null && this
						.getDictionaryType().equals(
								castOther.getDictionaryType())))
				&& ((this.getContent() == castOther.getContent()) || (this
						.getContent() != null && castOther.getContent() != null && this
						.getContent().equals(castOther.getContent())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getUsername() == null ? 0 : this.getUsername().hashCode());
		result = 37 * result
				+ (getPassword() == null ? 0 : this.getPassword().hashCode());
		result = 37 * result
				+ (getTel() == null ? 0 : this.getTel().hashCode());
		result = 37 * result
				+ (getBillId() == null ? 0 : this.getBillId().hashCode());
		result = 37
				* result
				+ (getCreateTime() == null ? 0 : this.getCreateTime()
						.hashCode());
		result = 37 * result
				+ (getMoney() == null ? 0 : this.getMoney().hashCode());
		result = 37 * result
				+ (getBillType() == null ? 0 : this.getBillType().hashCode());
		result = 37
				* result
				+ (getConsumptionType() == null ? 0 : this.getConsumptionType()
						.hashCode());
		result = 37 * result
				+ (getRemarks() == null ? 0 : this.getRemarks().hashCode());
		result = 37 * result
				+ (getTypeName() == null ? 0 : this.getTypeName().hashCode());
		result = 37 * result
				+ (getDicMarks() == null ? 0 : this.getDicMarks().hashCode());
		result = 37
				* result
				+ (getDictionaryName() == null ? 0 : this.getDictionaryName()
						.hashCode());
		result = 37
				* result
				+ (getDictionaryType() == null ? 0 : this.getDictionaryType()
						.hashCode());
		result = 37 * result
				+ (getContent() == null ? 0 : this.getContent().hashCode());
		return result;
	}

}