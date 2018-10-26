package com.allen.emplyeemgs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.allen.emplyeemgs.dao.EmployeeDAO;
import com.allen.emplyeemgs.entity.Department;
import com.allen.emplyeemgs.entity.Employee;
import com.allen.emplyeemgs.util.DBUtil;

/***
 * Title: EmplyeeDAOImpl
 * 
 * Description: MVC之数据持久层实现类
 * 
 * Company: 个人
 * 
 * @author Allen Wang
 * 
 * @email:1303542271@qq.com
 * 
 * @date 2016年9月27日 下午2:11:52
 * 
 */
public class EmployeeDAOImpl implements EmployeeDAO {

	/**
	 * 查询员工
	 * 
	 * @see com.allen.emplyeemgs.dao.EmployeeDAO#queryEmp(java.lang.String)
	 */
	@Override
	public List<Employee> queryEmp(String e_name) {

		// 面向接口编程
		List<Employee> list = new ArrayList<Employee>();

		// 声明JDBC对象
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 得到连接
		conn = DBUtil.getConn();

		// 准备SQL
		String sql = "select * from employee where e_name like concat(?,'%')";

		// 得到预处理器
		pstmt = DBUtil.getPreparedStatement(conn, sql);

		try {
			// 传入参数
			pstmt.setString(1, e_name);

			// 执行SQL
			rs = pstmt.executeQuery();

			// 遍历
			while (rs.next()) {

				// 声明员工对象
				Employee emp = null;

				int e_no = rs.getInt("e_no");
				String name = rs.getString("e_name");
				int e_age = rs.getInt("e_age");
				double e_laborage = rs.getDouble("e_laborage");
				String e_address = rs.getString("e_address");
				int e_deptno = rs.getInt("e_deptno");

				// 实例化
				emp = new Employee(e_no, name, e_age, e_laborage, e_address,
						e_deptno);

				// 添加进集合
				list.add(emp);
			}

		} catch (SQLException e) {
			System.out.println("查询失败!!!");
		} finally {
			// 关闭连接
			DBUtil.closeAll(conn, pstmt, rs);
		}

		return list;
	}

	/**
	 * 查询部门信息
	 */
	@Override
	public List<Department> findDept() {

		// 面向接口编程
		List<Department> list = new ArrayList<Department>();

		// 声明JDBC对象
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 得到连接
		conn = DBUtil.getConn();

		// 准备SQL
		String sql = "select * from department";

		// 得到预处理器
		pstmt = DBUtil.getPreparedStatement(conn, sql);

		try {

			// 执行SQL
			rs = pstmt.executeQuery();

			while (rs.next()) {

				int d_no = rs.getInt("d_no");
				String d_name = rs.getString("d_name");

				Department dept = new Department(d_no, d_name);

				// 添加到容器中
				list.add(dept);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public boolean add(Employee emp) {

		// 准备SQL

		String sql = "insert into employee values(seq_employee.nextval,?,?,?,?,?)";

		// 存值
		Object[] obj = { emp.getE_name(), emp.getE_age(), emp.getE_laborage(),
				emp.getE_address(), emp.getE_deptno() };

		// 声明
		PreparedStatement pstmt = null;

		boolean flag = false;

		// 执行
		int i = DBUtil.execUpdate(pstmt, sql, obj);

		if (i == 1) {
			flag = true;
		}

		return flag;
	}

}
