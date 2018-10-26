/**
 * 
 */
package allen.servlet.scope.request;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Allen
 * 
 *         Title: RequestScopeServlet
 * 
 *         Description:
 * 
 *         Company:
 * 
 * @date 2016年9月9日 上午10:48:35
 * 
 *       Email:1303542271 @qq.com
 */
public class RequestScopeServlet extends HttpServlet {

	/**
	 * 序列
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 生成一个订单号
		String requestId ="------request"+ UUID.randomUUID().toString().replace("-", "");

		System.out.println(requestId);

		// 向作用域内存值(值传递)
		req.setAttribute("requestId", requestId);

		// 请求转发  可以传递值   重定向不能传递值
		req.getRequestDispatcher("testScope.action").forward(req, resp);
		return;

	}
}
