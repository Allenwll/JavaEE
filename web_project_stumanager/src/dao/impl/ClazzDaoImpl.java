/**
 * 
 */
package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.BaseDao;
import dao.ClazzDao;

/**
 * @author Allen
 * 
 *         Title: ClazzDaoImpl
 * 
 *         Description:
 * 
 *         Company:
 * 
 * @date 2016年9月18日 下午7:06:53
 * 
 *       Email:1303542271 @qq.com
 */
public class ClazzDaoImpl implements ClazzDao {

	@Override
	public String queryClassName(int classId) {

		// 声明连接
		Connection conn = null;

		// 声明预处理器
		PreparedStatement pstmt = null;

		// 声明结果集
		ResultSet rs = null;

		// 得到连接
		conn = BaseDao.getConn();

		// 临时
		String name = null;

		// sql语句
		String sql = "select name from t_class where id=?";

		// ִ实例化预处理器
		pstmt = BaseDao.getPreparedStatement(conn, sql);

		try {

			pstmt.setInt(1, classId);

			// ִ执行sql
			rs = pstmt.executeQuery();

			if (rs.next()) {
				name = rs.getString("name");
			}

		} catch (Exception e) {
			System.out.println("查询失败!!!");
		} finally {
			BaseDao.closeAll(conn, pstmt, rs);
		}
		return name;
	}

}
