/**
 * 
 */
package service;

import java.util.List;

import entity.Student;

/**
 * @author Allen
 * 
 *         Title: StudentService
 * 
 *         Description: 服务层接口
 * 
 *         Company:
 * 
 * @date 2016年9月12日 上午10:15:26
 * 
 *       Email:1303542271 @qq.com
 */
public interface StudentService {

	// 查询所有学生
	List<Student> queryAll();

	// 添加学生
	int addStudent(Student student);

	// 更新学生
	int updateStudent(Student student);

	// 删除学生
	int deleteStudent(int id);

	// 条件查询
	List<Student> queryByChoice(String sql);

}
