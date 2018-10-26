/**
 * 
 */
package allen.filter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Allen
 * 
 *         Title: EunuchServlet
 * 
 *         Description:
 * 
 *         Company:
 * 
 * @date 2016年9月13日 下午2:30:05
 * 
 *       Email:1303542271 @qq.com
 */
public class EunuchServlet extends HttpServlet {

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
		System.out.println("EunuchServlet.service(You are a eunuch !)");
	}
}
