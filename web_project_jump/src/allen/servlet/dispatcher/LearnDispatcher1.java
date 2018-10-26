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
public class LearnDispatcher1 extends HttpServlet {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 打印
		System.out.println("LearnDispatcher1.service(第二个)");

		// 二次转发参数
		System.out.println("请求参数:" + req.getParameter("phone"));

		// 跳转到具体页面
		// req.getRequestDispatcher("dis.jsp").forward(req, resp);

		// 访问外网: 不能实现    
		req.getRequestDispatcher("http://www.taobao.com").forward(req, resp);;

	}

}
