/**
 * 
 */
package entity;

/**
 * @author  Allen
 *
 * Title: Clazz
 *
 * Description:  
 * 		
 * 		班级类
 * 
 *	Company: 
 *  
 *  @date 2016年9月18日 下午4:33:18    
 *  
 *  Email:1303542271 @qq.com
 */
public class Clazz {
		
	//班级编号
	private int classId;
	
	//班级名称
	private String className;
	
	
	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}
	
	public String getClassName() {
		return className;
	}
	
	
	public Clazz(int classId, String className) {
		super();
		this.classId = classId;
		this.className = className;
	}

	public void setClassName(String className) {
		this.className = className;
	}



	/**
	 *无参构造 
	 */
	public Clazz() {
	}
}
