package Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.DBUtil;
import Dao.TopicDao;
import entity.Topic;

/**
 * 数据持久层实现类
 * 
 * @author acer
 * 
 */
public class TopicDaoImpl implements TopicDao {
	/**
	 * 查询所有帖子
	 */
	@Override
	public List<Topic> queryAll() {

		// 声明JDBC对象
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 实例化List容器
		List<Topic> topicList = new ArrayList<Topic>();

		// 准备sql语句
		String sql = "select * from t_topic order by topic_id desc";

		// 得到连接
		conn = DBUtil.getConn();

		// 得到预处理器对象
		pstmt = DBUtil.getPreparedStatement(conn, sql);

		// 执行SQL语句
		try {
			rs = pstmt.executeQuery();

			// 循环遍历
			while (rs.next()) {

				// 声明帖子类对象
				Topic topic = null;

				int topic_id = rs.getInt("topic_id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String author = rs.getString("author");
				Date create_time = new Date(rs.getTimestamp("create_time")
						.getTime());
				int click_amount = rs.getInt("click_amount");

				topic = new Topic(topic_id, title, content, author,
						create_time, click_amount);

				// 添加进list容器
				topicList.add(topic);
			}

		} catch (SQLException e) {
			System.err.println("执行查询所有语句出错！！！");
		} finally {
			// 关闭连接
			DBUtil.closeAll(conn, pstmt, rs);
		}

		return topicList;
	}

	/**
	 * 添加帖子
	 */
	@Override
	public boolean create(Topic topic) {

		// 声明预处理器
		PreparedStatement pstmt = null;

		// 临时变量
		int i = 0;
		boolean flag = false;

		// 准备SQL语句
		String sql = "insert into t_topic(topic_id,title,content,author,create_time,click_Amount)VALUES (seq_topic.nextval,?,?,?,?,?)";

		// 数据存入
		Object[] obj = { topic.getTitle(), topic.getContent(),
				topic.getAuthor(),
				new Timestamp(topic.getCreate_time().getTime()),
				topic.getClick_amount() };

		// 执行方法
		i = DBUtil.execUpdate(pstmt, sql, obj);

		if (i == 1) {
			flag = true;
		}

		return flag;
	}

	// 删除帖子
	@Override
	public int delete(int topic_id) {

		// 声明预处理器
		PreparedStatement pstmt = null;
		// 声明变量
		int result = 0;

		// 准备SQL语句
		String sql = "delete from t_topic where topic_id=?";

		// 数据存入
		Object[] obj = { topic_id };

		// 执行方法
		result = DBUtil.execUpdate(pstmt, sql, obj);

		return result;
	}

	// 根据编号查询
	@Override
	public Topic findById(int topic_id) {

		// 声明JDBC对象
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 准备sql语句
		String sql = "select * from t_topic where topic_id=? order by topic_id desc";

		// 得到连接
		conn = DBUtil.getConn();

		// 得到预处理器对象
		pstmt = DBUtil.getPreparedStatement(conn, sql);

		try {
			pstmt.setInt(1, topic_id);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		// 声明帖子类对象
		Topic topic = null;

		// 执行SQL语句
		try {
			rs = pstmt.executeQuery();

			// 循环遍历
			if (rs.next()) {

				String title = rs.getString("title");
				String content = rs.getString("content");
				String author = rs.getString("author");
				Date create_time = new Date(rs.getTimestamp("create_time")
						.getTime());
				int click_amount = rs.getInt("click_amount");

				topic = new Topic(topic_id, title, content, author,
						create_time, click_amount);

			}

		} catch (SQLException e) {
			System.err.println("执行查询所有语句出错！！！");
		} finally {
			// 关闭连接
			DBUtil.closeAll(conn, pstmt, rs);
		}

		return topic;

	}

	@Override
	public void updateClickAmount(Topic topic) {

		// 获取预处理对像
		PreparedStatement pstmt = null;

		// 字符串
		String sql = "update t_topic set click_amount=? where topic_id=?";

		// 设置数组
		Object[] obj = { topic.getClick_amount(), topic.getTopic_id() };

		DBUtil.execUpdate(pstmt, sql, obj);

	}

}
