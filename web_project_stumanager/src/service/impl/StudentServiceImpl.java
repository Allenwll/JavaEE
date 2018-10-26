/**
 * 
 */
package service.impl;

import java.util.List;

import service.StudentService;
import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import entity.Student;

/**
 * @author Allen
 * 
 *         Title: StudentServiceImpl
 * 
 *         Description: 服务层实现
 * 
 *         Company:
 * 
 * @date 2016年9月12日 上午10:06:16
 * 
 *       Email:1303542271 @qq.com
 */
public class StudentServiceImpl implements StudentService {

	// 实例化Dao类
	StudentDao dao = new StudentDaoImpl();

	@Override
	public List<Student> queryAll() {

		return dao.queryAll();
	}

	@Override
	public int addStudent(Student student) {

		return dao.addStudent(student);
	}

	@Override
	public int updateStudent(Student student) {

		return dao.updateStudent(student);
	}

	@Override
	public int deleteStudent(int id) {

		return dao.deleteStudent(id);
	}

	@Override
	public List<Student> queryByChoice(String sql) {
		return dao.queryByChoice(sql);
	}

}
