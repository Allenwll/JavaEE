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

import allen.login.entity.User;
import allen.login.service.UserService;

/**
 * @author Allen
 * 
 *         Title: IndexFilter
 * 
 *         Description:
 * 
 *         Company:
 * 
 * @date 2016年9月11日 上午10:18:10
 * 
 *       Email:1303542271 @qq.com
 */
public class LoginFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		// 实例化请求对象
		HttpServletRequest request = (HttpServletRequest) req;
		
		

		// 实例化响应对象
		HttpServletResponse response = (HttpServletResponse) resp;

		// 获取所有Cookie
		Cookie[] cookies = request.getCookies();

		// 临时数组
		String[] cooks = null;

		// 临时用户名变量
		String username = null;

		// 临时密码变量
		String password = null;

		// 如果有cookie
		if (cookies != null) {

			// 遍历查询是否有该Cookie
			for (Cookie cookie : cookies) {

				// 获取
				String temp = cookie.getValue();

				// 分隔
				cooks = temp.split("==");

				if (cooks.length == 2) {

					username = cooks[0];

					password = cooks[1];
				}
			}
		}

		// 实例化
		User user = new User();

		// 设置逻辑值ֵ

		boolean flag = false;

		// 设置姓名
		user.setName(username);
		user.setPwd(password);

		// 实例化
		UserService userService = new UserService();

		// 得到逻辑值
		flag = userService.findInfo(user);

		// 校验成功!
		if (flag) {

			// 将对象绑定到Session中
			request.getSession().setAttribute("username", username);
			// 跳转
			response.sendRedirect("show.action");
			return;
		} else {
			chain.doFilter(request, response);
			/*
			 * request.getRequestDispatcher("login.html").forward(request,
			 * response);
			 */
		}

	}

	public void init(FilterConfig config) throws ServletException {

	}

}
