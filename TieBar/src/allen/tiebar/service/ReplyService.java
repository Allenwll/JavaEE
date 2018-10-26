/**
 * 
 */
package allen.tiebar.service;

import java.sql.SQLException;
import java.util.List;

import allen.tiebar.bean.Reply;
import allen.tiebar.dao.ReplyDao;

/**
 * @author Allen
 * 
 *         Title: ReplayService
 * 
 *         Description: 服务层
 * 
 *         Company:
 * 
 * @date 2016年9月14日 上午11:06:14
 * 
 *       Email:1303542271 @qq.com
 */
public class ReplyService  {

	// 实例化
	ReplyDao dao = new ReplyDao();

	/**
	 * 新增
	 * 
	 * @param reply
	 */
	public void create(Reply reply) {

		// 调用持久层新建方法
		dao.create(reply);
	}

	/**
	 * 查询所有
	 * 
	 * @param topicId
	 * @return
	 * @throws SQLException
	 */
	public List<Reply> queryAllByTopicId(Integer topicId) throws SQLException {

		// 调用持久层查询所有方法
		return dao.queryAll(topicId);
	}
}
