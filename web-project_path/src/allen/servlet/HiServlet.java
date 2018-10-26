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
 *         Title: HiServlet
 * 
 *         Description:
 * 
 *         Company:
 * 
 * @date 2016年9月13日 上午11:30:41
 * 
 *       Email:1303542271 @qq.com
 */
public class HiServlet extends HttpServlet {

	/**
	 * 序列号
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("HiServlet.service()");

		// 测试相对路径

		// 跳转 ---请求转发

		// req.getRequestDispatcher("a/aa/aa.jsp").forward(req, resp);

		// 跳转 ---重定向
		// resp.sendRedirect("a/aa/aa.jsp");

		// 测试绝对路径

		// 跳转 ---请求转发 ------指向项目根路径
		req.getRequestDispatcher("/a/aa/aa.jsp").forward(req, resp);

		// 跳转 ---重定向----指向服务器根路径
		//resp.sendRedirect("/webPath/a/aa/aa.jsp"); 不灵活,一旦部署名改变，路径失效
		resp.sendRedirect(req.getContextPath());
		
		
		
		return;
	}
}
