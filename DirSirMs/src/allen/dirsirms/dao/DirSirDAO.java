package allen.dirsirms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import allen.dirsirms.entity.Goods;
import allen.dirsirms.entity.Manager;
import allen.dirsirms.util.DBUtil;

/***
 * Title: DirSirDAO
 * 
 * Description:
 * 
 * DAO层
 * 
 * 
 * Company: 个人
 * 
 * @author Allen Wang
 * 
 * @email:1303542271@qq.com
 * 
 * @date 2016年10月8日 下午5:51:03
 * 
 */
public class DirSirDAO {

	/**
	 * 登录
	 * 
	 * @return
	 * @throws SQLException
	 */
	public boolean login(Manager manager) throws SQLException {

		// 临时逻辑值
		boolean flag = false;

		// 声明JDBC对象
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 得到连接
		conn = DBUtil.getConn();

		// 准备SQL
		String sql = "select * from tb_manager where Manager=? and Password=?";

		// 实例化预处理器
		pstmt = DBUtil.getPreparedStatement(conn, sql);

		// 传参
		pstmt.setString(1, manager.getManager());
		pstmt.setString(2, manager.getPassWord());

		// 执行SQL
		rs = pstmt.executeQuery();

		if (rs.next()) {
			flag = true;
		}

		// 关闭
		DBUtil.closeAll(conn, pstmt, rs);

		return flag;
	}

	/**
	 * 查询商品
	 * 
	 * @param size
	 * @param num
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Goods> queryGoods(int num, int size) throws SQLException {

		// 声明JDBC对象
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 得到连接
		conn = DBUtil.getConn();

		List<Goods> list = new ArrayList<Goods>();

		// 准备SQL
		String sql = "select * from tb_goods limit ?,?";

		// 得到预处理器
		pstmt = DBUtil.getPreparedStatement(conn, sql);

		pstmt.setInt(1, (num - 1) * size);
		pstmt.setInt(2, size);

		// 执行SQL
		rs = pstmt.executeQuery();

		// 遍历
		while (rs.next()) {
			Goods goods = new Goods();
			goods.setGoodsName(rs.getString("Goodsname"));
			goods.setIntroduce(rs.getString("introduce"));
			goods.setNewGoods(rs.getInt("Newgoods"));
			goods.setSale(rs.getInt("sale"));
			// 添加进集合
			list.add(goods);
		}

		DBUtil.closeAll(conn, pstmt, rs);

		return list;
	}

	/**
	 * 获取总记录数
	 * 
	 * @return
	 * @throws SQLException
	 */
	public int getCount() throws SQLException {

		// 声明JDBC对象
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int total = -1;// 代表无效值

		// 得到连接
		conn = DBUtil.getConn();

		// 准备SQL
		String sql = "select count(*) cnt from tb_goods";

		// 实例化预处理器
		pstmt = DBUtil.getPreparedStatement(conn, sql);

		// 执行SQL
		rs = pstmt.executeQuery();

		if (rs.next()) {
			total = rs.getInt("cnt");
		}

		// 关闭连接
		DBUtil.closeAll(conn, pstmt, rs);

		return total;
	}
}
