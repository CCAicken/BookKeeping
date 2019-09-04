package Model;

/**
 * TBill entity. @author MyEclipse Persistence Tools
 */

public class TBill implements java.io.Serializable {

	// Fields

	private Integer billId;
	private String userId;
	private String createTime;
	private Double money;
	private String billType;
	private String consumptionType;
	private String remarks;

	// Constructors

	/** default constructor */
	public TBill() {
	}

	/** minimal constructor */
	public TBill(String userId, String createTime, Double money,
			String billType, String consumptionType) {
		this.userId = userId;
		this.createTime = createTime;
		this.money = money;
		this.billType = billType;
		this.consumptionType = consumptionType;
	}

	/** full constructor */
	public TBill(String userId, String createTime, Double money,
			String billType, String consumptionType, String remarks) {
		this.userId = userId;
		this.createTime = createTime;
		this.money = money;
		this.billType = billType;
		this.consumptionType = consumptionType;
		this.remarks = remarks;
	}

	// Property accessors

	public Integer getBillId() {
		return this.billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

}