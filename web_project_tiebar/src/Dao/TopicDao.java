package Dao;

import java.util.List;

import entity.Topic;

/**
 * 数据持久层接口
 * 
 * @author acer
 * 
 */
public interface TopicDao {

	// 查询所有
	List<Topic> queryAll();

	// 添加
	boolean create(Topic topic);

	// 删除
	int delete(int topic_id);

	// 根据ID查询
	Topic findById(int topic_id);

	//更新点击量
	void updateClickAmount(Topic topic);
}
