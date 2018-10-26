/**
 * 
 */
package allen.login.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import allen.login.service.LoginService;

/**
 * @author Allen
 * 
 *         Title: LoginFilter
 * 
 *         Description:
 * 
 *         Company:
 * 
 * @date 2016年9月11日 上午10:18:10
 * 
 *       Email:1303542271 @qq.com
 */
public class IndexFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		// 实例化
		HttpServletRequest request = (HttpServletRequest) req;

		// 实例化
		HttpServletResponse response = (HttpServletResponse) resp;

		// 获取所有Cookie
		Cookie[] cookies = request.getCookies();

		// 临时数组
		String[] cooks = null;
		String username = null;
		String password = null;
		if (cookies != null) {

			// 遍历查询是否有该Cookie
			for (Cookie cookie : cookies) {
				String temp = cookie.getValue();
				cooks = temp.split("==");
				if (cooks.length == 2) {
					username = cooks[0];
					password = cooks[1];
				}
			}
		}
		// 校验成功!
		if (LoginService.login(username, password)) {

			// 将对象绑定到Session中
			request.getSession().setAttribute("username", username);

			// 跳转
			response.sendRedirect("/showUser.action");

		} else {
			response.sendRedirect("index.jsp");
		}

	}

	public void init(FilterConfig config) throws ServletException {

	}

}
