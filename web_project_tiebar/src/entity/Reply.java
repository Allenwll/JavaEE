/**
 * 
 */
package entity;

import java.util.Date;

/**
 * @author Allen
 * 
 *         Title: Reply
 * 
 *         Description: 评论实体类
 * 
 *         Company:
 * 
 * @date 2016年9月14日 上午10:59:01
 * 
 *       Email:1303542271 @qq.com
 */
public class Reply {

	// 评论编号
	private int id;

	// 帖子编号

	private int topic_id;

	// 昵称
	private String author;

	// 内容
	private String content;

	// 创建时间
	private Date create_time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTopic_id() {
		return topic_id;
	}

	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	/**
	 * 无参构造
	 */
	public Reply() {
	}

}
