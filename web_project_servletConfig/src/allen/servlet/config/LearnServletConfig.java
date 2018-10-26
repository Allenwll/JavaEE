/**
 * 
 */
package allen.servlet.config;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Allen
 * 
 *         Title: LearnServletConfig
 * 
 *         Description:
 * 
 *         Company:
 * 
 * @date 2016年9月8日 下午3:26:24
 * 
 *       Email:1303542271 @qq.com
 */
public class LearnServletConfig extends HttpServlet {

	/**
	 * 序列
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

		ServletConfig config = this.getServletConfig();

		// 获取配置文件信息
		System.out.println(config.getServletName());
		System.out.println(config.getInitParameter("uname"));
		System.out.println(config.getInitParameter("pwd"));
	}
}
