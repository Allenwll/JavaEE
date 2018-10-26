/**
 * 
 */
package allen.bean;

/**
 * @author Allen
 * 
 *         Title: User
 * 
 *         Description: 用户类
 * 
 *         Company:
 * 
 * @date 2016年9月11日 上午9:34:19
 * 
 *       Email:1303542271 @qq.com
 */
public class User {

	private String uname;

	private String realname;
	
	private int pwd;

	public int getPwd() {
		return pwd;
	}

	public void setPwd(int pwd) {
		this.pwd = pwd;
	}

	private Address addr;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}
	
	/**
	 * 
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String uname, String realname,int pwd, Address addr) {
		super();
		this.uname = uname;
		this.realname = realname;
		this.pwd=pwd;
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "User [uname=" + uname + ", realname=" + realname + ", addr="
				+ addr + "]";
	}
	
	
}
