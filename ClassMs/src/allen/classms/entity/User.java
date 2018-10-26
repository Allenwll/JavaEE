/**
 * 
 */
package allen.classms.entity;

/**
 * @author  Allen
 *
 * Title: User
 *
 * Description: 
 * 			
 * 		用户实体类		
 * 
 *	Company: 
 *  
 *  @date 2016年9月21日 上午9:53:01    
 *  
 *  Email:1303542271 @qq.com
 */
public class User {
	
	//编号
	private int id;
	
	//姓名
	private String name;
	
	//密码
	private String pwd;
	
	//昵称
	private String nickName;
	
	//性别
	private String sex;
	
	//年龄
	private String age;
	
	//爱好
	private String fav;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getFav() {
		return fav;
	}

	public void setFav(String fav) {
		this.fav = fav;
	}
	
	/**
	 * 无参构造
	 */
	public User() {
	}

	public User(int id, String name, String pwd, String nickName, String sex,
			String age, String fav) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.nickName = nickName;
		this.sex = sex;
		this.age = age;
		this.fav = fav;
	}
	public User(String name, String pwd, String nickName, String sex,
			String age, String fav) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.nickName = nickName;
		this.sex = sex;
		this.age = age;
		this.fav = fav;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd
				+ ", nickName=" + nickName + ", sex=" + sex + ", age=" + age
				+ ", fav=" + fav + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((fav == null) ? 0 : fav.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (fav == null) {
			if (other.fav != null)
				return false;
		} else if (!fav.equals(other.fav))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		return true;
	}
	
	
}
