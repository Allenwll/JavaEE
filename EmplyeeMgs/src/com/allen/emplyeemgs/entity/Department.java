package com.allen.emplyeemgs.entity;

/***
 * Title: Department
 * 
 * Description: MVC之部门实体类
 * 
 * Company: 个人
 * 
 * @author Allen Wang
 * 
 * @email:1303542271@qq.com
 * 
 * @date 2016年9月27日 下午2:16:22
 * 
 */
public class Department {

	// 部门编号
	private int d_no;

	// 部门名称
	private String d_name;

	public int getD_no() {
		return d_no;
	}

	public void setD_no(int d_no) {
		this.d_no = d_no;
	}

	public String getD_name() {
		return d_name;
	}

	public void setD_name(String d_name) {
		this.d_name = d_name;
	}

	@Override
	public String toString() {
		return "Department [d_no=" + d_no + ", d_name=" + d_name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((d_name == null) ? 0 : d_name.hashCode());
		result = prime * result + d_no;
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
		Department other = (Department) obj;
		if (d_name == null) {
			if (other.d_name != null)
				return false;
		} else if (!d_name.equals(other.d_name))
			return false;
		if (d_no != other.d_no)
			return false;
		return true;
	}

	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(int d_no, String d_name) {
		super();
		this.d_no = d_no;
		this.d_name = d_name;
	}

}
