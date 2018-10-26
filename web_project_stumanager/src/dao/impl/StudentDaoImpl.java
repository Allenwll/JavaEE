/**
 * 
 */
package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import service.ClazzService;
import service.impl.ClazzServiceImpl;
import util.BaseDao;
import dao.StudentDao;
import entity.Clazz;
import entity.Student;

/**
 * @author Allen
 * 
 *         Title: StudentDaoImpl
 * 
 *         Description: 数据持久实现层
 * 
 *         Company:
 * 
 * @date 2016年9月12日 上午10:05:32
 * 
 *       Email:1303542271 @qq.com
 */
public class StudentDaoImpl implements StudentDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.StudentDao#queryAll()
	 */
	@Override
	public List<Student> queryAll() {

		// 声明连接
		Connection conn = null;

		// 声明预处理器
		PreparedStatement pstmt = null;

		// 声明结果集
		ResultSet rs = null;

		// 面向接口
		List<Student> list = new ArrayList<Student>();

		// 得到连接
		conn = BaseDao.getConn();

		// sql语句
		String sql = "select * from t_student";

		// ִ实例化预处理器
		pstmt = BaseDao.getPreparedStatement(conn, sql);

		try {
			// ִ执行sql
			rs = pstmt.executeQuery();

			ClazzService clazzService = new ClazzServiceImpl();

			// 判断是否查到到数据
			while (rs.next()) {

				int id = rs.getInt(1);

				String name = rs.getString(2);

				int age = rs.getInt(3);

				double score = rs.getDouble(4);

				Date enterDate = rs.getDate(5);

				int classId = rs.getInt(6);

				String className = clazzService.queryClassName(classId);

				// 添加进入list容器
				list.add(new Student(id, name, age, score, enterDate,
						new Clazz(classId, className)));

			}
		} catch (SQLException e) {
			System.out.println("执行sql出错!!");
		} finally {
			// ִ关闭连接
			BaseDao.closeAll(conn, pstmt, rs);
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.StudentDao#addStudent(entity.Student)
	 */
	@Override
	public int addStudent(Student student) {

		// 定义Sql
		String sql = "insert into t_student (name,score,age,classId) values(?,?,?,?)";

		// 传入参数
		Object[] obj = { student.getName(), student.getScore(),
				student.getAge(), student.getClassId() };

		// 结果
		int result = 0;
		// 执行
		try {
			result = BaseDao.updateStudent(sql, obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int updateStudent(Student student) {

		// 执行Sql
		String sql = "update t_student set name=?,score=?,age=?,classId=? where stuId=?";

		// 传入参数
		Object[] obj = { student.getName(), student.getScore(),
				student.getAge(), student.getClassId(), student.getId() };

		// 结果
		int result = 0;
		// 执行
		try {
			result = BaseDao.updateStudent(sql, obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteStudent(int id) {

		// sql语句
		String sql = "delete from t_student where stuId=?";

		// 传入id
		Object[] obj = { id };

		int result = 0;
		try {
			// 执行SQL
			result = BaseDao.updateStudent(sql, obj);

			if (result > 0) {
				System.out.println("删除成功!");
			} else {
				System.out.println("删除失败！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public List<Student> queryByChoice(String sql) {

		// 声明连接
		Connection conn = null;

		// 声明预处理器
		PreparedStatement pstmt = null;

		// 声明结果集
		ResultSet rs = null;

		// 面向接口
		List<Student> list = new ArrayList<Student>();

		// 得到连接
		conn = BaseDao.getConn();

		// ִ实例化预处理器
		pstmt = BaseDao.getPreparedStatement(conn, sql);

		try {
			// ִ执行sql
			rs = pstmt.executeQuery();

			ClazzService clazzService = new ClazzServiceImpl();

			// 判断是否查到到数据
			while (rs.next()) {

				int id = rs.getInt(1);

				String name = rs.getString(2);

				int age = rs.getInt(3);

				double score = rs.getDouble(4);

				Date enterDate = rs.getDate(5);

				int classId = rs.getInt(6);

				String className = clazzService.queryClassName(classId);

				// 添加进入list容器
				list.add(new Student(id, name, age, score, enterDate,
						new Clazz(classId, className)));

			}
		} catch (SQLException e) {
			System.out.println("执行sql出错!!");
		} finally {
			// ִ关闭连接
			BaseDao.closeAll(conn, pstmt, rs);
		}
		return list;
	}
}
