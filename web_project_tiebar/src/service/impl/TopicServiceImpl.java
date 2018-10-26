package service.impl;

import java.util.List;

import Dao.TopicDao;
import Dao.impl.TopicDaoImpl;
import entity.Topic;
import service.TopicService;

/**
 * 服务层实现类
 * 
 * @author acer
 * 
 */
/**
 * @author acer
 * 
 */
public class TopicServiceImpl implements TopicService {

	// 面向接口
	TopicDao topicDao = new TopicDaoImpl();

	/**
	 * 查询所有
	 */
	@Override
	public List<Topic> queryAll() {

		return topicDao.queryAll();
	}

	/**
	 * 添加帖子
	 * 
	 * @param topic
	 * @return
	 */
	public boolean create(Topic topic) {

		return topicDao.create(topic);
	}

	/**
	 * 删除帖子
	 * 
	 * @param parseInt
	 * @return
	 */
	public int delete(int topic_id) {

		return topicDao.delete(topic_id);
	}

	/**
	 * 根据帖子编号查询
	 * 
	 * @param topic_id
	 * @return
	 */
	public Topic findById(int topic_id) {

		Topic topic = topicDao.findById(topic_id);

		// 增加浏览量
		topic.setClick_amount(topic.getClick_amount() + 1);

		// 同步数据库
		topicDao.updateClickAmount(topic);

		return topic;
	}

}
