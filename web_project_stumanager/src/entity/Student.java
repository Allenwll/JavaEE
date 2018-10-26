/**
 * 
 */
package entity;

import java.util.Date;

/**
 * @author Allen
 * 
 *         Title: Student
 * 
 *         Description: 学生实体类
 * 
 *         Company:
 * 
 * @date 2016年9月12日 上午9:55:28
 * 
 *       Email:1303542271 @qq.com
 */
public class Student {

	// 学号
	private int id;

	// 姓名
	private String name;

	// 年龄
	private int age;

	// 成绩
	private double score;

	// 日期
	private Date enterDate;

	// 班级编号
	private int classId;

	private Clazz clazz;

	public int getId() {
		return id;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Date getEnterDate() {
		return enterDate;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}

	/**
	 * 无参构造
	 */
	public Student() {
	}

	/**
	 * 重载有参构造
	 * 
	 * @param id
	 * @param name
	 * @param age
	 * @param score
	 * @param enterDate
	 */
	public Student(int id, String name, int age, double score, Date enterDate,
			Clazz clazz) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.score = score;
		this.enterDate = enterDate;

		this.setClazz(clazz);
	}

	/*
	 * (non-Javadoc) 重写系统toString方法
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age
				+ ", score=" + score + ", enterDate=" + enterDate + "]";
	}

	/**
	 * @return the clazz
	 */
	public Clazz getClazz() {
		return clazz;
	}

	/**
	 * @param clazz
	 *            the clazz to set
	 */
	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

}
