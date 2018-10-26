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
 *         Title: EmpressServlet
 * 
 *         Description:
 * 
 *         Company:
 * 
 * @date 2016年9月13日 下午2:27:54
 * 
 *       Email:1303542271 @qq.com
 */
public class EmpressServlet extends HttpServlet {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -5806844841745708335L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("EmpressServlet.service(I'm Empress！)");
	}
}
