package service;

import java.util.List;

import entity.Reply;

public interface ReplyService {

	// 添加
	public void create(Reply reply);

	// 查询所有品论
	public List<Reply> queryAll(Integer topicId);
}
