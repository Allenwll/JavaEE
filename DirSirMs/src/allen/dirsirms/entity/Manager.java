package allen.dirsirms.entity;

/***
 * Title: Manager
 * 
 * Description:
 * 
 * 用户
 * 
 * Company: 个人
 * 
 * @author Allen Wang
 * 
 * @email:1303542271@qq.com
 * 
 * @date 2016年10月8日 下午5:36:47
 * 
 */
public class Manager {

	// 用户编号
	private int id;

	// 用户名
	private String manager;

	// 密码
	private String passWord;

	public Manager() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", manager=" + manager + ", passWord="
				+ passWord + "]";
	}

	public Manager(int id, String manager, String passWord) {
		super();
		this.id = id;
		this.manager = manager;
		this.passWord = passWord;
	}

	public Manager(String manager, String passWord) {
		super();
		this.manager = manager;
		this.passWord = passWord;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

}
