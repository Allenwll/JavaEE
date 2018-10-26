/**
 * 
 */
package allen.servlet.redirect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Allen
 * 
 *         <p>
 *         Title: LearnRedirectServlet
 *         </p>
 *         <p>
 *         Description:
 *         </p>
 *         <p>
 *         Company:
 *         </p>
 * @date 2016年9月8日 上午10:31:06 Email:1303542271@qq.com
 */
public class LearnRedirectServlet extends HttpServlet {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("LearnRedirectServlet.service(我是第一个)");

		// 获取前台参数
		String ok = req.getParameter("iphone");

		System.out.println("参数:" + ok);

		// 重定向,一共发送了2个请求，都是有客户端发送的
		resp.sendRedirect("redirect2.action?phone=" + ok);

		// 重定向之后的代码也能够执行，但是存在风险,所以一般加return
		System.out.println("重定向成功!");
		return;
	}
}
