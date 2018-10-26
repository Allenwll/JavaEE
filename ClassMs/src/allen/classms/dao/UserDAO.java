/**
 * 
 */
package allen.classms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import allen.classms.entity.User;
import allen.classms.util.DBUtil;

/**
 * @author Allen
 * 
 *         Title: UserDAO
 * 
 *         Description:
 * 
 *         Company:
 * 
 * @date 2016年9月21日 上午9:53:18
 * 
 *       Email:1303542271 @qq.com
 */
public class UserDAO {

	/**
	 * 查询用户
	 * 
	 * @param uname
	 * @param pwd
	 * @return
	 */
	public User queryUser(String uname, String pwd) {

		// 跟数据库交互
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;

		// 得到连接
		conn = DBUtil.getConn();

		// 准备Sql
		String sql = "select * from user where name=? and pwd=?";

		// 得到预处理器
		pstmt = DBUtil.getPreparedStatement(conn, sql);

		try {
			// 设置值
			pstmt.setString(1, uname);
			pstmt.setString(2, pwd);

			// 开始查询
			rs = pstmt.executeQuery();

			// 对结果进行处理

			if (rs.next()) {

				// 实例化
				user = new User();

				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPwd(rs.getString(3));
				user.setNickName(rs.getString(4));
				user.setSex(rs.getString(5));
				user.setAge(rs.getString(6));
				user.setFav(rs.getString(7));

			}
		} catch (SQLException e) {

			System.err.println("查询失败!");
		} finally {
			// 关闭连接
			DBUtil.closeAll(conn, pstmt, rs);
		}
		return user;
	}

	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	public List<User> queryAll(int num, int size) {

		// 实例化集合
		List<User> userList = new ArrayList<User>();

		// 声明JDBC对象
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 得到连接
		conn = DBUtil.getConn();

		// 准备SQL
		String sql = "select * from user order by id desc limit ?,?";

		// 得到预处理器
		pstmt = DBUtil.getPreparedStatement(conn, sql);

		try {
			// 添加分页参数
			pstmt.setInt(1, (num - 1) * size);

			pstmt.setInt(2, size);
			// 执行SQL
			rs = pstmt.executeQuery();

			// 遍历
			while (rs.next()) {
				// 实例化
				User user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPwd(rs.getString(3));
				user.setNickName(rs.getString(4));
				user.setSex(rs.getString(5));
				user.setAge(rs.getString(6));
				user.setFav(rs.getString(7));

				// 添加进容器
				userList.add(user);

			}
		} catch (SQLException e) {
			System.err.println("查询失败!!!" + e.getStackTrace());
		} finally {
			// 关闭资源
			DBUtil.closeAll(conn, pstmt, rs);
		}
		return userList;
	}

	public int addUser(User user) {

		// 结果码
		int result = 0;

		// 添加SQL
		String sql = "insert into user(name,pwd,nickname,sex,age,fav) values(?,?,?,?,?,?)";

		// 声明预处理器
		PreparedStatement pstmt = null;

		// 实例化数组
		Object[] obj = { user.getName(), user.getPwd(), user.getNickName(),
				user.getSex(), user.getAge(), user.getFav() };

		// 得到结果
		result = DBUtil.execUpdate(pstmt, sql, obj);

		return result;
	}

	/**
	 * 根据id获取用户信息
	 * 
	 * @param id
	 * @return
	 */
	public User queryUserById(int id) {

		// 跟数据库交互
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;

		// 得到连接
		conn = DBUtil.getConn();

		// 准备Sql
		String sql = "select * from user where id=?";

		// 得到预处理器
		pstmt = DBUtil.getPreparedStatement(conn, sql);

		try {
			// 设置值
			pstmt.setInt(1, id);

			// 开始查询
			rs = pstmt.executeQuery();

			// 对结果进行处理

			if (rs.next()) {

				// 实例化
				user = new User();

				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPwd(rs.getString(3));
				user.setNickName(rs.getString(4));
				user.setSex(rs.getString(5));
				user.setAge(rs.getString(6));
				user.setFav(rs.getString(7));

			}
		} catch (SQLException e) {

			System.err.println("查询失败!");
		} finally {
			// 关闭连接
			DBUtil.closeAll(conn, pstmt, rs);
		}
		return user;
	}

	public boolean delete(int id) {

		// 逻辑值
		boolean flag = false;

		// 声明预处理器
		PreparedStatement pstmt = null;

		// 实例化数组
		Object[] obj = { id };

		// 准备SQL语句
		String sql = "delete from user where id=?";

		// 得到结果
		int result = DBUtil.execUpdate(pstmt, sql, obj);

		if (result > 0) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 修改用户
	 * 
	 * @param user
	 * @return
	 */
	public int updateUser(User user) {

		// 结果码
		int result = 0;

		// 添加SQL
		String sql = "update user set name=?,pwd=?,nickname=?,sex=?,age=?,fav=? where id=?";

		// 声明预处理器
		PreparedStatement pstmt = null;

		// 实例化数组
		Object[] obj = { user.getName(), user.getPwd(), user.getNickName(),
				user.getSex(), user.getAge(), user.getFav(), user.getId() };

		// 得到结果
		result = DBUtil.execUpdate(pstmt, sql, obj);

		return result;

	}

	/**
	 * 根据姓名查询
	 * 
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public List<User> queryUser(String name) {

		// 实例化集合
		List<User> userList = new ArrayList<User>();

		// 声明JDBC对象
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 得到连接
		conn = DBUtil.getConn();

		// 准备SQL
		String sql = "select * from user where name like concat('%',?,'%') order by id desc";

		// 得到预处理器
		pstmt = DBUtil.getPreparedStatement(conn, sql);

		try {
			// 添加SQL参数
			pstmt.setString(1, name);

			// 执行SQL
			rs = pstmt.executeQuery();

			// 遍历
			while (rs.next()) {
				// 实例化
				User user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPwd(rs.getString(3));
				user.setNickName(rs.getString(4));
				user.setSex(rs.getString(5));
				user.setAge(rs.getString(6));
				user.setFav(rs.getString(7));

				// 添加进容器
				userList.add(user);
			}
		} catch (SQLException e) {

			System.err.println("sql语句出错");
		} finally {
			// 关闭资源
			DBUtil.closeAll(conn, pstmt, rs);
		}
		return userList;
	}

	/**
	 * 获取总数
	 * 
	 * @return
	 */
	public int getCount() {

		// 跟数据库交互
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int total = -1;// 代表无效值

		// 得到连接
		conn = DBUtil.getConn();

		// 准备Sql
		String sql = "select count(*) cnt from user";

		// 得到预处理器
		pstmt = DBUtil.getPreparedStatement(conn, sql);

		try {

			// 开始查询
			rs = pstmt.executeQuery();

			// 对结果进行处理

			if (rs.next()) {
				// total=rs.getInt(1);
				total = rs.getInt("cnt");

			}
		} catch (SQLException e) {

			System.err.println("查询失败!");
		} finally {
			// 关闭连接
			DBUtil.closeAll(conn, pstmt, rs);
		}
		return total;
	}

	public int getCount(String sql, String name) {

		// 跟数据库交互
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int total = -1;// 代表无效值

		// 得到连接
		conn = DBUtil.getConn();

		// 得到预处理器
		pstmt = DBUtil.getPreparedStatement(conn, sql);

		try {

			pstmt.setString(1, name);

			// 开始查询
			rs = pstmt.executeQuery();

			// 对结果进行处理
			if (rs.next()) {
				total = rs.getInt(1);
				// total = rs.getInt("cnt");

			}
		} catch (SQLException e) {

			System.err.println("查询失败!");
		} finally {
			// 关闭连接
			DBUtil.closeAll(conn, pstmt, rs);
		}
		return total;
	}

	/**
	 * 分页查询
	 * 
	 * @param name
	 * @param num
	 * @param size
	 * @return
	 */
	public List<User> queryUser(String name, int num, int size) {

		// 实例化集合
		List<User> userList = new ArrayList<User>();

		// 声明JDBC对象
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 得到连接
		conn = DBUtil.getConn();

		// 准备SQL
		String sql = "select * from user  where name like concat('%',?,'%')  order by id desc limit ?,?";

		// 得到预处理器
		pstmt = DBUtil.getPreparedStatement(conn, sql);

		try {

			pstmt.setString(1, name);

			// 添加分页参数
			pstmt.setInt(2, (num - 1) * size);

			pstmt.setInt(3, size);
			// 执行SQL
			rs = pstmt.executeQuery();

			// 遍历
			while (rs.next()) {
				// 实例化
				User user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPwd(rs.getString(3));
				user.setNickName(rs.getString(4));
				user.setSex(rs.getString(5));
				user.setAge(rs.getString(6));
				user.setFav(rs.getString(7));

				// 添加进容器
				userList.add(user);

			}
		} catch (SQLException e) {
			System.err.println("查询失败!!!" + e.getStackTrace());
		} finally {
			// 关闭资源
			DBUtil.closeAll(conn, pstmt, rs);
		}
		return userList;
	}

	/**
	 * 查询用户
	 * 
	 * @param name
	 * @return
	 */
	public int queryName(String name) {

		// 跟数据库交互
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int result = 0;

		// 得到连接
		conn = DBUtil.getConn();

		// 准备Sql
		String sql = "select * from user where name=?";

		// 得到预处理器
		pstmt = DBUtil.getPreparedStatement(conn, sql);

		try {
			// 设置值
			pstmt.setString(1, name);

			// 开始查询
			rs = pstmt.executeQuery();

			// 对结果进行处理

			if (rs.next()) {

				result = 1;
			}
		} catch (SQLException e) {

			System.err.println("查询失败!");
		} finally {
			// 关闭连接
			DBUtil.closeAll(conn, pstmt, rs);
		}
		return result;
	}

}
