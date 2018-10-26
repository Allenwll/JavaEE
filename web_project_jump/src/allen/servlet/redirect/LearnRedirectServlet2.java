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
public class LearnRedirectServlet2 extends HttpServlet {

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
		// 打印
		System.out.println("LearnRedirectServlet2.service(我是第二个)");
		
		System.out.println("能获取到参数吗?:" + req.getParameter("phone"));
		
		//重定向访问外网的情况
		resp.sendRedirect("http://www.baidu.com");
	}
}
