/**
 * 
 */
package entity;

/**
 * @author Allen
 * 
 *         Title: User
 * 
 *         Description: 用户实体类
 * 
 *         Company:
 * 
 * @date 2016年9月12日 下午4:02:34
 * 
 *       Email:1303542271 @qq.com
 */
public class User {

	// 用户id
	private int userid;

	// 用户名
	private String username;

	// 密码
	private String password;

	// 登录次数
	private int count=0;

	
	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 无参构造
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int userid, String username, String password) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
	}

}
