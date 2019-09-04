package Model;

/**
 * TDictionaryInfo entity. @author MyEclipse Persistence Tools
 */

public class TDictionaryInfo implements java.io.Serializable {

	// Fields

	private String dictionaryInfoId;
	private String dictionaryName;
	private String dictionaryType;
	private String content;
	private Integer sortNum;

	// Constructors

	/** default constructor */
	public TDictionaryInfo() {
	}

	/** minimal constructor */
	public TDictionaryInfo(String dictionaryInfoId, String dictionaryName,
			String dictionaryType, Integer sortNum) {
		this.dictionaryInfoId = dictionaryInfoId;
		this.dictionaryName = dictionaryName;
		this.dictionaryType = dictionaryType;
		this.sortNum = sortNum;
	}

	/** full constructor */
	public TDictionaryInfo(String dictionaryInfoId, String dictionaryName,
			String dictionaryType, String content, Integer sortNum) {
		this.dictionaryInfoId = dictionaryInfoId;
		this.dictionaryName = dictionaryName;
		this.dictionaryType = dictionaryType;
		this.content = content;
		this.sortNum = sortNum;
	}

	// Property accessors

	public String getDictionaryInfoId() {
		return this.dictionaryInfoId;
	}

	public void setDictionaryInfoId(String dictionaryInfoId) {
		this.dictionaryInfoId = dictionaryInfoId;
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

	public Integer getSortNum() {
		return this.sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}

}