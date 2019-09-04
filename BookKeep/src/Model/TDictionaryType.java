package Model;

/**
 * TDictionaryType entity. @author MyEclipse Persistence Tools
 */

public class TDictionaryType implements java.io.Serializable {

	// Fields

	private String dictionaryType;
	private String typeName;
	private String remarks;
	private Integer sortNum;

	// Constructors

	/** default constructor */
	public TDictionaryType() {
	}

	/** minimal constructor */
	public TDictionaryType(String dictionaryType, String typeName,
			Integer sortNum) {
		this.dictionaryType = dictionaryType;
		this.typeName = typeName;
		this.sortNum = sortNum;
	}

	/** full constructor */
	public TDictionaryType(String dictionaryType, String typeName,
			String remarks, Integer sortNum) {
		this.dictionaryType = dictionaryType;
		this.typeName = typeName;
		this.remarks = remarks;
		this.sortNum = sortNum;
	}

	// Property accessors

	public String getDictionaryType() {
		return this.dictionaryType;
	}

	public void setDictionaryType(String dictionaryType) {
		this.dictionaryType = dictionaryType;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getSortNum() {
		return this.sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}

}