package allen.login.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import allen.login.entity.User;
import allen.login.service.UserService;

/**
 * @author acer
 * 
 *         MVC 控制层
 */
public class LoginServlet extends HttpServlet {

	/**
	 * 序列码
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 设置编码格式
		req.setCharacterEncoding("UTF-8");

		// 得到前端数据
		String name = req.getParameter("username");
		String pwd = req.getParameter("password");

		// 设置逻辑值ֵ
		boolean flag = false;

		// 实例化
		User user = new User();

		// 设置姓名
		user.setName(name);
		user.setPwd(pwd);

		// 实例化
		UserService userService = new UserService();

		// 得到逻辑值
		flag = userService.findInfo(user);

		// 判断
		if (flag) {

			if ("true".equals(req.getParameter("autoLogin"))) {

				// 创建cookie
				Cookie cookie = new Cookie("user", name + "==" + pwd);

				// 设置属性值
				req.setAttribute("username", name);

				// 设置三天
				cookie.setMaxAge(3600 * 24 * 3);

				// 添加
				resp.addCookie(cookie);

			}
			// 请求转发
			req.getRequestDispatcher("show.action").forward(req, resp);

			return;

		} else {
			
			resp.getWriter().write("查无此人!");

			// 重定向
			resp.sendRedirect(req.getContextPath() + "/login.html");
		}
	}

}
