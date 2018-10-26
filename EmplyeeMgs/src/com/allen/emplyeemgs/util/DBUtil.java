package com.allen.emplyeemgs.util;

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
 * @author Allen
 * 
 *         Title: DBUtil
 * 
 *         Description: 数据库常用工具类
 * 
 *         Company:
 * 
 * @date 2016年9月27日 下午2:23:10
 * 
 *       Email:1303542271 @qq.com
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

	static {

		// 装载资源文件
		InputStream is = DBUtil.class.getClassLoader().getResourceAsStream(
				"conn.properties");

		// 实例化类
		Properties pt = new Properties();

		try {
			// 装载
			pt.load(is);

		} catch (IOException e) {

			// 提示错误
			System.err.println("读取资源失败!");
		}

		// 得到文件资源ֵ
		driver = pt.getProperty("oracleDriver");
		url = pt.getProperty("oracleUrl");
		user = pt.getProperty("oracleUser");
		pwd = pt.getProperty("oraclePassword");

		try {
			// 反射得到驱动
			Class.forName(driver);

		} catch (ClassNotFoundException e) {

			// 提示错误
			System.err.println("驱动加载失败!");

		}
	}

	/**
	 * 得到连接
	 * 
	 * @return
	 */
	public static Connection getConn() {

		// 声明连接
		Connection conn = null;
		try {

			// 得到连接对象
			conn = DriverManager.getConnection(url, user, pwd);

		} catch (SQLException e) {

			// 异常处理
			System.err.println("连接失败!");
		}

		// 返回连接对象
		return conn;
	}

	/**
	 * 得到预处理器
	 * 
	 * @param conn
	 * @param sql
	 * @return
	 */
	public static PreparedStatement getPreparedStatement(Connection conn,
			String sql) {

		// 声明预处理器对象
		PreparedStatement pstmt = null;

		try {
			// 得到预处理器对象
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {

			// 异常处理
			System.err.println("ִ执行sql失败!!!");

		}

		// 返回预处理器对象
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

		// 判断结果集是否为空
		if (rs != null) {
			try {
				// 关闭结果集
				rs.close();
			} catch (SQLException e) {

				// 异常处理
				System.err.println("关闭结果集失败!");
			}
		}
	}

	/**
	 * 关闭连接
	 * 
	 * @param conn
	 */
	public static void closeConn(Connection conn) {

		try {
			// 判断连接是否为空
			if (conn != null)
				// 关闭连接
				conn.close();
		} catch (SQLException e) {

			// 异常处理
			System.err.println("关闭连接失败!");

		}

	}

	/**
	 * 关闭数据库资源
	 * 
	 * @param conn
	 * @param st
	 * @param rs
	 */
	public static void closeAll(Connection conn, Statement st, ResultSet rs) {

		// 关闭连接
		DBUtil.closeConn(conn);

		// 关闭结果集
		DBUtil.closeResultSet(rs);
	}

}
