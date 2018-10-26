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

import allen.tiebar.bean.Topic;
import allen.tiebar.util.DBUtil;

/**
 * @author Allen
 * 
 *         Title: TopicDAO
 * 
 *         Description: 数据访问层
 * 
 *         Company:
 * 
 * @date 2016年9月13日 下午5:15:19
 * 
 *       Email:1303542271 @qq.com
 */
public class TopicDAO {

	/**
	 * 新增帖子
	 * 
	 * @param topic
	 * @return
	 */
	public int save(Topic topic) {

		// 声明预处理器
		PreparedStatement pstmt = null;

		// 临时变量
		int i = 0;

		// 准备SQL语句
		String sql = "insert into t_topic(topic_id,title,content,author,create_time,click_Amount)VALUES (seq_topic.nextval,?,?,?,?,?)";

		// 数据存入
		Object[] obj = { topic.getTitle(), topic.getContent(),
				topic.getAuthor(),
				new Timestamp(topic.getCreateDate().getTime()),
				topic.getClickAmount() };

		// 执行方法
		i = DBUtil.execUpdate(pstmt, sql, obj);

		return i;

	}

	/**
	 * 查询所有内容
	 * 
	 * @return
	 */
	public List<Topic> queryAll() {

		// 声明连接
		Connection conn = null;

		// 声明预处理器
		PreparedStatement pstmt = null;

		// 声明结果集
		ResultSet rs = null;

		// 连接数据库
		conn = DBUtil.getConn();

		// Sql语句
		String sql = "select * from t_topic order by topic_id desc";

		// 面向接口
		List<Topic> list = new ArrayList<Topic>();

		// 执行SQL
		pstmt = DBUtil.getPreparedStatement(conn, sql);

		try {
			rs = pstmt.executeQuery();

			while (rs.next()) {

				// 实例化
				Topic topic = new Topic();

				// 得到值
				topic.setTopicId(rs.getInt("topic_id"));
				topic.setTitle(rs.getString("title"));
				topic.setAuthor(rs.getString("author"));
				topic.setContent(rs.getString("content"));
				topic.setCreateDate(new Date(rs.getTimestamp("create_time")
						.getTime()));
				topic.setClickAmount(rs.getInt("click_Amount"));

				// 添加进集合
				list.add(topic);
			}

		} catch (SQLException e) {
			System.out.println("查询失败!");
		} finally {
			DBUtil.closeAll(conn, pstmt, rs);
		}
		return list;
	}

	/**
	 * 查看单个帖子
	 * 
	 * @param topicId
	 * @return
	 */
	public Topic findById(Integer topicId) {

		// 声明连接
		Connection conn = null;

		// 声明预处理器
		PreparedStatement pstmt = null;

		// 声明结果集
		ResultSet rs = null;

		// 连接数据库
		conn = DBUtil.getConn();

		// Sql语句
		String sql = "select * from t_topic where topic_id=?";

		// 执行SQL

		pstmt = DBUtil.getPreparedStatement(conn, sql);

		// 实例化
		Topic topic = null;

		try {

			pstmt.setInt(1, topicId);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				topic = new Topic();

				// 得到值
				topic.setTopicId(rs.getInt("topic_id"));
				topic.setTitle(rs.getString("title"));
				topic.setAuthor(rs.getString("author"));
				topic.setContent(rs.getString("content"));
				topic.setCreateDate(new Date(rs.getTimestamp("create_time")
						.getTime()));
				topic.setClickAmount(rs.getInt("click_Amount"));
			}

		} catch (SQLException e) {
			System.out.println("查询所有记录失败!");
		} finally {
			DBUtil.closeAll(conn, pstmt, rs);
		}
		return topic;
	}

	/**
	 * 同步点击量
	 * 
	 * @param topic
	 */
	public void updateClickAmount(Topic topic) {

		// 声明预处理器
		PreparedStatement pstmt = null;

		// Sql语句
		String sql = "update t_topic set click_amount=?where topic_id=?";

		// 声明变量
		int i = 0;

		// 存入数据
		Object[] obj = { topic.getClickAmount(), topic.getTopicId() };

		i = DBUtil.execUpdate(pstmt, sql, obj);

		// 分析结果
		if (i > 0) {
			System.out.println("同步成功!");

		} else {
			System.out.println("同步失败!");
		}

	}

	/**
	 * 删除该贴
	 * 
	 * @param topicId
	 */
	public void delete(Integer topicId) {

		// 声明预处理器
		PreparedStatement pstmt = null;

		// Sql语句
		String sql = "delete from t_topic where topic_id=?";

		// 声明变量
		int i = 0;

		// 存入数据
		Object[] obj = { topicId };

		i = DBUtil.execUpdate(pstmt, sql, obj);

		// 分析结果
		if (i > 0) {
			System.out.println("删除成功!");
		} else {
			System.out.println("删除失败!");
		}
	}
}
