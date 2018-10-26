package allen.classms.util;

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

	// mysql配置

	// 静态代码块,类加载时第一位执行
	static {

		// 实例化资源类
		Properties p = new Properties();
		try {
			// 通过反射机制得到将其存在读取流中
			InputStream is = DBUtil.class.getClassLoader().getResourceAsStream(
					"conn.properties");

			// 装载
			p.load(is);

			// 得到资源
			driver = p.getProperty("mysqlDriver");
			url = p.getProperty("mysqlUrl");
			user = p.getProperty("mysqlUser");
			pwd = p.getProperty("mysqlPassword");

		} catch (IOException e1) {
			System.out.println("读取资源失败");
		}
		try {
			//利用反射机制装载驱动
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

	/**
	 * 增删改操作
	 * 
	 * @param sql
	 * @param obj
	 * @return
	 */
	public static int execUpdate(PreparedStatement pstmt, String sql,
			Object[] obj) {

		// 得到预处理器
		pstmt = getPreparedStatement(getConn(), sql);

		// 声明结果
		int result = 0;

		// 进行操作
		for (int i = 1; i <= obj.length; i++) {

			try {
				// 传入参数
				pstmt.setObject(i, obj[i - 1]);

			} catch (SQLException e) {

				System.err.println("赋值失败!!!");

			}
		}

		try {
			// 执行SQL指令
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("执行SQL指令失败!!!");
		} finally {
			closeAll(getConn(), pstmt, null);
		}

		// 返回结果
		return result;
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
