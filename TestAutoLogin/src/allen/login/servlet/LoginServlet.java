/**
 * 
 */
package allen.login.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import allen.login.service.LoginService;

/**
 * @author Allen
 * 
 *         Title: LoginServlet
 * 
 *         Description:
 * 
 *         Company:
 * 
 * @date 2016年9月11日 上午10:17:00
 * 
 *       Email:1303542271 @qq.com
 */
public class LoginServlet extends HttpServlet {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取前端参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String savetime = request.getParameter("saveTime");

		// 校验
		if (LoginService.login(username, password)) {

			if (null != savetime && !savetime.isEmpty()) {

				// 这里接受的表单值为天来计算的
				int saveTime = Integer.parseInt(savetime);

				int seconds = saveTime * 24 * 60 * 60;

				// 创建Cookie
				Cookie cookie = new Cookie("user", username + "==" + password);

				// 设置存活时间
				cookie.setMaxAge(seconds);

				// 添加Cookie
				response.addCookie(cookie);
			}

			// 设置属性值
			request.setAttribute("username", username);

			// 跳转
			/*request.getRequestDispatcher("/main.jsp")
					.forward(request, response);*/
			response.sendRedirect("main.jsp");
		} else {
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
		}
	}

}
