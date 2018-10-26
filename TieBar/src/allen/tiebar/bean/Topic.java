/**
 * 
 */
package allen.tiebar.bean;

import java.util.Date;

/**
 * @author Allen
 * 
 *         Title: Topic
 * 
 *         Description: 帖子实体类
 * 
 *         Company:
 * 
 * @date 2016年9月13日 下午5:12:22
 * 
 *       Email:1303542271 @qq.com
 */
public class Topic {

	// 编号
	private Integer topicId;

	// 标题
	private String title;

	// 内容
	private String content;

	// 作者
	private String author;

	// 时间
	private Date createDate;

	// 点击量
	private Integer clickAmount;

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getClickAmount() {
		return clickAmount;
	}

	public void setClickAmount(Integer clickAmount) {
		this.clickAmount = clickAmount;
	}

	/**
	 * 无参构造
	 */
	public Topic() {
	}

	public Topic(Integer topicId, String title, String content, String author,
			Date createDate, Integer clickAmount) {
		super();
		this.topicId = topicId;
		this.title = title;
		this.content = content;
		this.author = author;
		this.createDate = createDate;
		this.clickAmount = clickAmount;
	}

}
