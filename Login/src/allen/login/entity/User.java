package allen.login.entity;

import java.util.Date;

/**
 * @author acer 实体类
 */
public class User {

	// 用户名
	private String name;
	
	// 密码
	private String pwd;

	// 昵称
	private String nickname;

	// 创建日期
	private Date date;

	// 性别
	private String sex;

	// 年龄
	private int age;

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

	//无参构造
	public User() {
	}
	
	
	//有参构造
	public User(String name, String pwd) {
		this.name = name;
		this.pwd = pwd;
	}

	//有参构造重载
	public User(String name, String pwd, String nickname, Date date,
			String sex, int age) {
		this.name = name;
		this.pwd = pwd;
		this.nickname = nickname;
		this.date = date;
		this.sex = sex;
		this.age = age;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
