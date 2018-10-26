/**
 * 
 */
package allen.tiebar.service;

import java.util.List;

import allen.tiebar.bean.Topic;
import allen.tiebar.dao.TopicDAO;

/**
 * @author Allen
 * 
 *         Title: TopicService
 * 
 *         Description: 业务层
 * 
 *         Company:
 * 
 * @date 2016年9月13日 下午5:26:35
 * 
 *       Email:1303542271 @qq.com
 */

public class TopicService {

	// 实例化
	TopicDAO dao = new TopicDAO();

	/**
	 * 新建方法
	 * 
	 * @param topic
	 * @return
	 */
	public int save(Topic topic) {
		return dao.save(topic);
	}

	/**
	 * 查询所有帖子
	 * 
	 * @return
	 */
	public List<Topic> queryAll() {

		return dao.queryAll();
	}

	/**
	 * 单个查询
	 * 
	 * @param
	 * @return
	 */
	public Topic findById(Integer topicId) {

		Topic topic = dao.findById(topicId);

		// 增加浏览量
		topic.setClickAmount(topic.getClickAmount() + 1);

		// 同步数据库
		dao.updateClickAmount(topic);

		return topic;
	}

	/**
	 * 删除
	 * 
	 * @param topicId
	 */
	public void delete(Integer topicId) {

		dao.delete(topicId);
	}
}
