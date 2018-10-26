/**
 * 
 */
package allen.servlet.scope.application;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Allen
 * 
 *         Title: ApplicationScopeServlet
 * 
 *         Description:
 * 
 *         Company:
 * 
 * @date 2016年9月9日 上午11:37:50
 * 
 *       Email:1303542271 @qq.com
 */
public class ApplicationScopeServlet extends HttpServlet {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 创建application对象
		ServletContext context = this.getServletContext();
		// ServletContext context1=this.getServletConfig().getServletContext();
		// ServletContext context2=req.getSession().getServletContext();

		// 向application作用域存值
		context.setAttribute("uname", "momo");

		// 跳转
		
		req.getRequestDispatcher("testScope.action").forward(req, resp);

		return;

	}
}
