package allen.servlet.dispatcher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author acer
 *
 * 请求转发和重定向
 */

public class LearnDispatcher extends HttpServlet {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//请求转发
		req.getRequestDispatcher("dispatcher2.action").forward(req, resp);;
		
		
		//打印
		System.out.println("LearnDispatcher.service(第一个)");
	}
		
}
