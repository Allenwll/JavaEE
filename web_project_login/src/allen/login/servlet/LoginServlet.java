package allen.login.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
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
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//设置编码格式
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
			resp.getWriter()
					.print("<h1><a href='show'>Show All Users</a></h1>");
		} else {
			resp.getWriter()
					.print("<h1><a href='login.html'>Sorry, Go Back To Login Page. </a></h1>");
		}

	}
}
