package servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ReplyService;
import service.impl.ReplyServiceImpl;
import service.impl.TopicServiceImpl;
import entity.Reply;
import entity.Topic;

public class TopicServlet extends HttpServlet {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 设置编码格式
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		// 获取前端数据
		String method = req.getParameter("method");

		// 分支选择
		if ("login".equals(method)) {

			// 查询所有
			this.queryAll(req, resp);
		} else if ("create".equals(method)) {

			// 添加帖子
			this.create(req, resp);
		} else if ("delete".equals(method)) {

			// 删除帖子
			this.delete(req, resp);
		} else if ("detail".equals(method)) {

			// 查看详细信息
			this.showDetail(req, resp);
		}

	}

	/**
	 * 查询详细信息
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void showDetail(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 获取前端数据
		int topic_id = Integer.parseInt(req.getParameter("topic_id"));

		// 查询详细信息
		Topic topic = new TopicServiceImpl().findById(topic_id);

		ReplyService replyService = new ReplyServiceImpl();

		// 查找所有
		List<Reply> list = replyService.queryAll(topic_id);
		// 设置作用域
		req.setAttribute("topic", topic);
		req.setAttribute("list", list);

		// 跳转
		req.getRequestDispatcher("/detail.jsp").forward(req, resp);

		return;
	}

	/**
	 * 删除帖子
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 获取前台数据
		String topic_id = req.getParameter("topic_id");

		// 删除数据库中的对应的记录
		int result = new TopicServiceImpl().delete(Integer.parseInt(topic_id));

		if (result == 1)
			System.out.println("删除成功!!!");
		else
			System.out.println("删除失败!!!");

		// 跳转
		this.queryAll(req, resp);

	}

	/**
	 * 添加帖子
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void create(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 添加到数据库中
		Topic topic = this.getTopicObject(req);
		boolean flag = new TopicServiceImpl().create(topic);

		if (flag) {
			System.out.println("添加成功!!!");
		} else {
			System.out.println("添加失败！！！");
		}

		// 跳转
		this.queryAll(req, resp);
		return;
	}

	/**
	 * 查询所有帖子
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void queryAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 查询所有帖子
		List<Topic> list = new TopicServiceImpl().queryAll();

		// 添加进作用域
		req.setAttribute("list", list);

		// 跳转
		req.getRequestDispatcher("/topicList.jsp").forward(req, resp);
		return;

	}

	/**
	 * 获取前台参数
	 * 
	 * @param req
	 * @return
	 */
	private Topic getTopicObject(HttpServletRequest req) {

		// 实例化对象
		Topic topic = new Topic();

		// 获取前台参数
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String content = req.getParameter("content");
		// 设置值
		topic.setTitle(title);
		topic.setAuthor(author);
		topic.setContent(content);
		topic.setCreate_time(new Date());
		topic.setClick_amount(0);

		// 返回对象
		return topic;
	}
}
