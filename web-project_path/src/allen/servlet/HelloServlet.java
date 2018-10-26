/**
 * 
 */
package allen.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Allen
 * 
 *         Title: HelloServlet
 * 
 *         Description:
 * 
 *         Company:
 * 
 * @date 2016年9月13日 上午11:33:15
 * 
 *       Email:1303542271 @qq.com
 */
public class HelloServlet extends HttpServlet {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("HelloServlet.service()");

		// 测试相对路径

		// 跳转 ---请求转发

		// req.getRequestDispatcher("/aa/aa.jsp").forward(req, resp);

		// 跳转 ---重定向
		// resp.sendRedirect("/aa/aa.jsp");
		return;
	}
}
