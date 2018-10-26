package allen.login.entity;

/**
 * @author acer 实体类
 */
public class User {

	// 用户名
	private String name;
	// 密码
	private String pwd;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public User() {
	}

	public User(String name, String pwd) {
		this.name = name;
		this.pwd = pwd;
	}

}
