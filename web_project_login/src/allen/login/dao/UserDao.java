package allen.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import allen.login.entity.User;
import allen.login.util.DBUtil;

/**
 * @author acer
 * 
 *         MVC : 数据访问层
 * 
 */
public class UserDao {

	// 根据用户名和密码查询
	public boolean findByInfo(User user) {

		// 声明连接
		Connection conn = null;

		// 声明预处理器
		PreparedStatement pstmt = null;

		// 声明结果集
		ResultSet rs = null;

		// 逻辑值ֵ
		boolean flag = false;

		// 得到连接
		conn = DBUtil.getConn();

		// sql语句
		String sql = "select * from t_user where name=? and pwd=?";

		// ִ实例化预处理器
		pstmt = DBUtil.getPreparedStatement(conn, sql);

		try {
			// 设置
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPwd());

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
			DBUtil.closeAll(conn, pstmt, rs);
		}

		return flag;
	}

	// 查询所有用户
	public List<User> findAll() {
		// 声明连接
		Connection conn = null;

		// 声明预处理器
		PreparedStatement pstmt = null;

		// 声明结果集
		ResultSet rs = null;

		// 逻辑值ֵ
		@SuppressWarnings("unused")
		boolean flag = false;

		// 得到连接
		conn = DBUtil.getConn();

		// sql语句
		String sql = "select * from t_user";

		// ִ实例化预处理器
		pstmt = DBUtil.getPreparedStatement(conn, sql);

		// 面向接口编程
		List<User> list = new ArrayList<User>();

		// 实例化User类

		User user = null;
		try {
			// 执行sql
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// 获取值
				String name = rs.getString(1);
				String pwd = rs.getString(2);
				// 实例化
				user = new User(name, pwd);

				// 添加
				list.add(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭
			DBUtil.closeAll(conn, pstmt, rs);
		}
		return list;
	}
}
