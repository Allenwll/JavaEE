package com.allen.emplyeemgs.entity;

/***
 * Title: Emplyee
 * 
 * Description:
 * 
 * MVC之员工体类
 * 
 * Company: 个人
 * 
 * @author Allen Wang
 * 
 * @email:1303542271@qq.com
 * 
 * @date 2016年9月27日 下午2:14:49
 * 
 */
public class Employee {

	// 员工编号
	private int e_no;

	// 员工姓名
	private String e_name;

	// 员工年龄
	private int e_age;

	// 薪资
	private double e_laborage;

	// 地址
	private String e_address;

	// 部门编号
	private int e_deptno;

	public int getE_no() {
		return e_no;
	}

	public void setE_no(int e_no) {
		this.e_no = e_no;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public int getE_age() {
		return e_age;
	}

	public void setE_age(int e_age) {
		this.e_age = e_age;
	}

	public double getE_laborage() {
		return e_laborage;
	}

	public void setE_laborage(double e_laborage) {
		this.e_laborage = e_laborage;
	}

	public String getE_address() {
		return e_address;
	}

	public void setE_address(String e_address) {
		this.e_address = e_address;
	}

	public int getE_deptno() {
		return e_deptno;
	}

	public void setE_deptno(int e_deptno) {
		this.e_deptno = e_deptno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((e_address == null) ? 0 : e_address.hashCode());
		result = prime * result + e_age;
		result = prime * result + e_deptno;
		long temp;
		temp = Double.doubleToLongBits(e_laborage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((e_name == null) ? 0 : e_name.hashCode());
		result = prime * result + e_no;
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
		Employee other = (Employee) obj;
		if (e_address == null) {
			if (other.e_address != null)
				return false;
		} else if (!e_address.equals(other.e_address))
			return false;
		if (e_age != other.e_age)
			return false;
		if (e_deptno != other.e_deptno)
			return false;
		if (Double.doubleToLongBits(e_laborage) != Double
				.doubleToLongBits(other.e_laborage))
			return false;
		if (e_name == null) {
			if (other.e_name != null)
				return false;
		} else if (!e_name.equals(other.e_name))
			return false;
		if (e_no != other.e_no)
			return false;
		return true;
	}
	

	public Employee(String e_name, int e_age, double e_laborage,
			String e_address, int e_deptno) {
		super();
		this.e_name = e_name;
		this.e_age = e_age;
		this.e_laborage = e_laborage;
		this.e_address = e_address;
		this.e_deptno = e_deptno;
	}

	@Override
	public String toString() {
		return "Employee [e_no=" + e_no + ", e_name=" + e_name + ", e_age="
				+ e_age + ", e_laborage=" + e_laborage + ", e_address="
				+ e_address + ", e_deptno=" + e_deptno + "]";
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int e_no, String e_name, int e_age, double e_laborage,
			String e_address, int e_deptno) {
		super();
		this.e_no = e_no;
		this.e_name = e_name;
		this.e_age = e_age;
		this.e_laborage = e_laborage;
		this.e_address = e_address;
		this.e_deptno = e_deptno;
	}

	public Employee(int e_no, String e_name, int e_age, double e_laborage) {
		super();
		this.e_no = e_no;
		this.e_name = e_name;
		this.e_age = e_age;
		this.e_laborage = e_laborage;
	}

}
