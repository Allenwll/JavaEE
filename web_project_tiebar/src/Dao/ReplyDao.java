package Dao;

import java.util.List;

import entity.Reply;

public interface ReplyDao {

	// 添加
	public void create(Reply reply);

	// 查询所有品论
	public List<Reply> queryAll(Integer topicId);
}
