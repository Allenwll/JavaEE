/**
 * 
 */
package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.BaseDao;
import dao.UserDao;
import entity.User;

/**
 * @author Allen
 * 
 *         Title: UserDaoImpl
 * 
 *         Description: 用户数据持久层实现
 * 
 *         Company:
 * 
 * @date 2016年9月12日 下午4:09:44
 * 
 *       Email:1303542271 @qq.com
 */
public class UserDaoImpl implements UserDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.UserDao#login()
	 */
	@Override
	public boolean login(User user) {

		// 声明连接
		Connection conn = null;

		// 声明预处理器
		PreparedStatement pstmt = null;

		// 声明结果集
		ResultSet rs = null;

		// 逻辑值ֵ
		boolean flag = false;

		// 得到连接
		conn = BaseDao.getConn();

		// sql语句
		String sql = "select * from t_user where username=? and password=?";

		// ִ实例化预处理器
		pstmt = BaseDao.getPreparedStatement(conn, sql);

		try {
			// 设置
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());

			// ִ执行sql
			rs = pstmt.executeQuery();

			// 判断是否查到到数据
			if (rs.next()) {

				// 赋值为true
				flag = true;

			}
		} catch (SQLException e) {
			System.out.println("执行sql出错!!");
		} finally {
			// ִ关闭连接
			BaseDao.closeAll(conn, pstmt, rs);
		}

		return flag;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.UserDao#addUser(entity.User)
	 */
	@Override
	public boolean addUser(User user) {
		// 定义Sql
		String sql = "insert into t_user(username,password) values(?,?)";

		// 传入参数
		Object[] obj = {user.getUsername(), user.getPassword() };

		// 结果
		int result = 0;
		boolean flag = false;
		// 执行
		try {
			result = BaseDao.updateStudent(sql, obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (result > 0)
			flag = true;

		return flag;

	}

}
