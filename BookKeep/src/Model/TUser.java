package Model;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */

public class TUser implements java.io.Serializable {

	// Fields

	private String userId;
	private String username;
	private String password;
	private String tel;

	// Constructors

	/** default constructor */
	public TUser() {
	}

	/** full constructor */
	public TUser(String userId, String username, String password, String tel) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.tel = tel;
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

}