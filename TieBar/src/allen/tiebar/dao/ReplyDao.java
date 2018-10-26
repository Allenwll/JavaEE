/**
 * 
 */
package allen.tiebar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import allen.tiebar.bean.Reply;
import allen.tiebar.util.DBUtil;

/**
 * @author Allen
 * 
 *         Title: ReplayDao
 * 
 *         Description: 评论数据持久层
 * 
 *         Company:
 * 
 * @date 2016年9月14日 上午10:59:24
 * 
 *       Email:1303542271 @qq.com
 */
public class ReplyDao {

	// 新增评论
	public void create(Reply reply) {

		// 结果
		int result = 0;

		// 声明预处理器
		PreparedStatement pstmt = null;

		// 准备SQL语句
		String sql = "insert into t_reply(id,topic_id,author,content,create_time)VALUES (seq_topic.nextval,?,?,?,?)";

		// 存入数据
		Object[] obj = { reply.getTopic_id(), reply.getAuthor(),
				reply.getContent(),
				new Timestamp(reply.getCreate_Time().getTime()) };

		// 执行
		DBUtil.execUpdate(pstmt, sql, obj);

		// 分析结果
		if (result > 0)
			System.out.println("评论成功!!!");
		else {
			System.out.println("评论失败!!!");
		}

	}

	/**
	 * 查询所有内容
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Reply> queryAll(Integer topicId) throws SQLException {

		// 声明连接
		Connection conn = null;

		// 声明预处理器
		PreparedStatement pstmt = null;

		// 声明结果集
		ResultSet rs = null;

		// 连接数据库
		conn = DBUtil.getConn();

		// Sql语句
		String sql = "select * from t_reply  where topic_id=? order by topic_id desc";

		// 面向接口
		List<Reply> list = new ArrayList<Reply>();

		// 执行SQL
		pstmt = DBUtil.getPreparedStatement(conn, sql);

		// 传参
		pstmt.setInt(1, topicId);
		try {

			// 执行
			rs = pstmt.executeQuery();

			// 循环读取数据
			while (rs.next()) {

				// 实例化
				Reply reply = new Reply();

				// 得到值
				reply.setId(rs.getInt("id"));
				reply.setTopic_id(rs.getInt("topic_id"));
				reply.setAuthor(rs.getString("author"));
				reply.setContent(rs.getString("content"));
				reply.setCreate_Time(new Date(rs.getTimestamp("create_time")
						.getTime()));

				// 添加进集合
				list.add(reply);
			}

		} catch (SQLException e) {
			System.out.println("查询评论失败!");
		} finally {
			//关闭数据资源
			DBUtil.closeAll(conn, pstmt, rs);
		}
		//返回集合
		return list;
	}

}
