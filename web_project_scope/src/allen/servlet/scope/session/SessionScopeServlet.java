/**
 * 
 */
package allen.servlet.scope.session;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Allen
 * 
 *         Title: SessionScopeServlet
 * 
 *         Description:
 * 
 *         Company:
 * 
 * @date 2016年9月9日 上午11:08:05
 * 
 *       Email:1303542271 @qq.com
 */
public class SessionScopeServlet extends HttpServlet {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
		//创建Session对象
		HttpSession session=req.getSession();
		
		
		// 生成一个订单号
		String sessionId ="------session"+ UUID.randomUUID().toString().replace("-", "");

		System.out.println(sessionId);

		// 向作用域内存值(值传递)
		session.setAttribute("sessionId", sessionId);

		// 请求转发  可以传递值   
		//req.getRequestDispatcher("testScope.action").forward(req, resp);
		
		//重定向 也可以传递
		resp.sendRedirect("testScope.action");
		
		return;

		
	}
}
