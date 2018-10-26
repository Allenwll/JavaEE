/**
 * 
 */
package allen.tiebar.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import allen.tiebar.bean.Reply;
import allen.tiebar.service.ReplyService;

/**
 * @author Allen
 * 
 *         Title: ReplayServlet
 * 
 *         Description:
 * 
 *         Company:
 * 
 * @date 2016年9月14日 上午11:07:50
 * 
 *       Email:1303542271 @qq.com
 */
public class ReplyServlet extends HttpServlet {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 设置字符集
		req.setCharacterEncoding("utf-8");

		// 接收用户的请求参数
		String method = req.getParameter("method");

		// 判断
		if ("create".equals(method)) {
			this.create(req, resp);
		}

	}

	/**
	 * 新增评论
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void create(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		// 实例化
		ReplyService service = new ReplyService();

		// 获取前台参数
		Integer topicId = Integer.parseInt(req.getParameter("topicId"));

		String author = req.getParameter("author");

		String content = req.getParameter("content");

		// 实例化
		Reply reply = new Reply();

		// 设置值
		reply.setTopic_id(topicId);
		reply.setAuthor(author);
		reply.setContent(content);
		reply.setCreate_Time(new Date());

		// 执行新增
		service.create(reply);

		// 跳转
		resp.sendRedirect(req.getContextPath()
				+ "/topic.action?method=detail&topicId=" + topicId);
		return;
	}

}
