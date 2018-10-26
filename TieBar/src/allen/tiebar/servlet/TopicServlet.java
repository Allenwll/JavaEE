/**
 * 
 */
package allen.tiebar.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import allen.tiebar.bean.Reply;
import allen.tiebar.bean.Topic;
import allen.tiebar.service.ReplyService;
import allen.tiebar.service.TopicService;

/**
 * @author Allen
 * 
 *         Title: TopicServlet
 * 
 *         Description:
 * 
 *         Company:
 * 
 * @date 2016年9月13日 下午5:29:37
 * 
 *       Email:1303542271 @qq.com
 */
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

		// 接收用户的请求参数
		String method = req.getParameter("method");

		// 分支判断
		if ("create".equals(method)) {
			this.create(req, resp);
		} else if ("list".equals(method)) {
			this.queryAll(req, resp);
		} else if ("detail".equals(method)) {
			try {
				this.showDetailInfo(req, resp);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if ("delete".equals(method)) {
			this.delete(req, resp);
		}

	}

	/**
	 * 删除
	 * 
	 * @param req
	 * @param resp
	 */
	private void delete(HttpServletRequest req, HttpServletResponse resp) {

		// 实例化
		TopicService topicService = new TopicService();

		// 获取前台参数
		Integer topicId = Integer.parseInt(req.getParameter("topicId"));

		// 执行方法
		topicService.delete(topicId);

		// 跳转
		try {
			resp.sendRedirect(req.getContextPath()
					+ "/topic.action?method=list");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}

	/**
	 * 查看单条详细信息
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 * @throws SQLException
	 * @throws NumberFormatException
	 */
	private void showDetailInfo(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, NumberFormatException,
			SQLException {

		// 初始化
		TopicService service = new TopicService();
		ReplyService replyService = new ReplyService();

		// 指定的帖子编号
		String topicId = req.getParameter("topicId");

		// 执行查询方法
		Topic topic = service.findById(Integer.parseInt(topicId));

		// 查找所有
		List<Reply> list = replyService.queryAllByTopicId(Integer
				.parseInt(topicId));

		// 存数据
		req.setAttribute("list", list);
		req.setAttribute("topic", topic);

		// 跳转
		req.getRequestDispatcher("/detail.jsp").forward(req, resp);
		return;
	}

	/**
	 * 查询所有
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void queryAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 实例化
		TopicService service = new TopicService();

		// 执行查询所有
		List<Topic> list = service.queryAll();

		// 设置
		req.setAttribute("list", list);

		// 跳转
		req.getRequestDispatcher("/topicList.jsp").forward(req, resp);
		return;
	}

	/**
	 * 新增帖子
	 * 
	 * @param req
	 * @throws IOException
	 * @throws ServletException
	 */
	private void create(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 实例化
		TopicService topicService = new TopicService();

		// 执行方法
		Topic topic = this.getTopicObject(req);

		// 执行新建方法
		int i = topicService.save(topic);

		// 分析结果
		if (i == 1) {
			System.out.println("添加成功");
		} else {
			System.out.println("添加失败");
		}

		// 跳转

		req.getRequestDispatcher("/topic.action?method=list")
				.forward(req, resp);
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
		topic.setCreateDate(new Date());
		topic.setClickAmount(0);

		// 返回对象
		return topic;
	}

}
