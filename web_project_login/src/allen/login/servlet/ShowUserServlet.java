package allen.login.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import allen.login.entity.User;
import allen.login.service.UserService;

/**
 * @author acer 服务器响应信息
 * 
 *         控制层
 */
public class ShowUserServlet extends HttpServlet {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 实例化对象
		UserService userService = new UserService();

		// 面向接口
		List<User> userList = userService.findAll();
		
		//设置编码格式
		resp.setCharacterEncoding("utf-8");
		resp.setHeader("content-type","text/html;charset=utf-8");
		
		
		// 向客户端返回信息
		resp.getWriter().print("<table  width='80%' border='1'>");
		resp.getWriter().print("<tr>");
		resp.getWriter().print("<th >用户名</th>");
		resp.getWriter().print("<th>密码</th>");
		resp.getWriter().print("</tr>");

		// 遍历输出
		for (int i = 0; i < userList.size(); i++) {
			User user = userList.get(i);
			resp.getWriter().print("<tr>");
			resp.getWriter().print("<th>" + user.getName() + "</th>");
			resp.getWriter().print("<th>" + user.getPwd() + "</th>");
			resp.getWriter().print("</tr>");
		}
		resp.getWriter().print("</table>");
	}

}
