package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Reply;
import service.ReplyService;
import service.impl.ReplyServiceImpl;

/**
 * 评论控制层
 * 
 * @author acer
 * 
 */
public class ReplyServlet extends HttpServlet {

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
		if ("create".equals(method)) {

			// 添加评论
			this.create(req, resp);
		}

	}

	/**
	 * 添加评论
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void create(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		// 实例化
		ReplyService service = new ReplyServiceImpl();

		// 获取前台参数
		Integer topic_id = Integer.parseInt(req.getParameter("topic_id"));

		String author = req.getParameter("author");

		String content = req.getParameter("content");

		// 实例化
		Reply reply = new Reply();

		// 设置值
		reply.setTopic_id(topic_id);
		reply.setAuthor(author);
		reply.setContent(content);
		reply.setCreate_time(new Date());

		// 执行新增
		service.create(reply);

		// 跳转
		resp.sendRedirect(req.getContextPath()
				+ "/topic.action?method=detail&topic_id=" + topic_id);
		return;
	}

}
