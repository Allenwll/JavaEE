package allen.servlet.dispatcher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author acer
 * 
 *         请求转发和重定向
 */
public class LearnDispatcher2 extends HttpServlet {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 打印
		System.out.println("LearnDispatcher2.service(第三个)");

		// 一次转发参数
		System.out.println("请求参数:" + req.getParameter("phone"));

		// 请求转发
		req.getRequestDispatcher("dispatcher1.action").forward(req, resp);

		// 请求转发之后的代码,可以执行,存在风险，一般加return
		System.out.println("第一次转发成功!");

		return;
	}
}
