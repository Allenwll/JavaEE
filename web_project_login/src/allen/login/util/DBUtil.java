package allen.login.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author acer 工具类
 * 
 *         数据常用工具类
 * 
 */
public class DBUtil {

	// 驱动
	private static String driver = null;

	// url
	private static String url = null;

	// 用户名
	private static String user = null;

	// 密码
	private static String pwd = null;

	// 静态代码块
	/*
	 * static {
	 * 
	 * // 装载资源文件 InputStream is =
	 * DBUtil.class.getClassLoader().getResourceAsStream( "DBUtil.properties");
	 * 
	 * // 实例化类 Properties pt = new Properties();
	 * 
	 * try {
	 * 
	 * // 装载 pt.load(is);
	 * 
	 * // 得到文件资源ֵ driver = pt.getProperty("oracleDriver"); url =
	 * pt.getProperty("oracleUrl"); user = pt.getProperty("oracleUser"); pwd =
	 * pt.getProperty("oraclePassword"); } catch (IOException e) {
	 * System.err.println("获取资源失败!"); } try { //反射得到装载驱动 Class.forName(driver);
	 * } catch (ClassNotFoundException e) { System.err.println("驱动!"); } }
	 */
	// mysql配置

	static {
		Properties p = new Properties();
		try {
			InputStream is = DBUtil.class.getClassLoader().getResourceAsStream(
					"DBUtil.properties");
			p.load(is);
			driver = p.getProperty("mysqlDriver");
			url = p.getProperty("mysqlUrl");
			user = p.getProperty("mysqlUser");
			pwd = p.getProperty("mysqlPassword");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.err.println("驱动加载失败!");
		}
	}

	// 得到连接
	public static Connection getConn() {
		// 声明
		Connection conn = null;
		try {
			// 得到连接
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			System.err.println("连接失败!");
		}
		return conn;
	}

	// 关闭连接
	public static void closeConn(Connection conn) {

		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.err.println("关闭连接失败!");
		}

	}

	// 执行sql命令的预处理器
	public static PreparedStatement getPreparedStatement(Connection conn,
			String sql) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			System.err.println("ִ执行sql失败!!!");
		}

		return pstmt;
	}

	// 关闭结果集
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 关闭所有
	public static void closeAll(Connection conn, Statement st, ResultSet rs) {
		DBUtil.closeConn(conn);
		DBUtil.closeResultSet(rs);
	}

}
