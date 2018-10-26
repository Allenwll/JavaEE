package entity;

import java.util.Date;

/**
 * 帖子实体
 * 
 * @author acer
 * 
 */
public class Topic {

	// 帖子编号
	private int topic_id;

	// 标题
	private String title;

	// 内容
	private String content;

	// 作者
	private String author;

	// 发帖日期
	private Date create_time;

	// 点击量
	private int click_amount;

	public int getTopic_id() {
		return topic_id;
	}

	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
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

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public int getClick_amount() {
		return click_amount;
	}

	public void setClick_amount(int click_amount) {
		this.click_amount = click_amount;
	}

	@Override
	public String toString() {
		return "Topic [topic_id=" + topic_id + ", title=" + title
				+ ", content=" + content + ", author=" + author
				+ ", create_time=" + create_time + ", click_amount="
				+ click_amount + "]";
	}

	public Topic() {
		// TODO Auto-generated constructor stub
	}

	public Topic(int topic_id, String title, String content, String author,
			Date create_time, int click_amount) {
		super();
		this.topic_id = topic_id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.create_time = create_time;
		this.click_amount = click_amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + click_amount;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result
				+ ((create_time == null) ? 0 : create_time.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + topic_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topic other = (Topic) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (click_amount != other.click_amount)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (create_time == null) {
			if (other.create_time != null)
				return false;
		} else if (!create_time.equals(other.create_time))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (topic_id != other.topic_id)
			return false;
		return true;
	}

}
