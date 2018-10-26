/**
 * 
 */
package allen.classms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import allen.classms.entity.User;
import allen.classms.server.UserService;

/**
 * @author Allen
 * 
 *         Title: UserServlet
 * 
 *         Description:
 * 
 *         登录控制
 * 
 *         Company:
 * 
 * @date 2016年9月19日 下午5:55:50
 * 
 *       Email:1303542271 @qq.com
 */
public class UserServlet extends HttpServlet {
	
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 设置请求的编码格式
		req.setCharacterEncoding("utf-8");

		// 设置响应的编码格式
		resp.setCharacterEncoding("utf-8");

		// 告诉浏览器如何解析
		resp.setContentType("text/html;charset=utf-8");

		// 获取用户的操作符
		String operate = req.getParameter("operate");

		if ("login".equals(operate)) {

			// 用户登录
			this.userLogin(req, resp);

		} else if ("out".equals(operate)) {

			// 用户退出
			this.userOut(req, resp);

		} else if ("all".equals(operate)) {

			// 查询所有用户
			this.getAllUserInfo(req, resp);

		} else if ("add".equals(operate)) {

			// 添加用户
			this.addUser(req, resp);
		} else if ("update".equals(operate)) {

			// 预修改
			this.updatePre(req, resp);
		} else if ("updateUser".equals(operate)) {

			// 修改用户
			this.updateReal(req, resp);

		} else if ("delete".equals(operate)) {

			// 删除
			this.deleteUser(req, resp);
		} else if ("sel".equals(operate)) {
			// 模糊查询
			this.selUser(req, resp);
		} else if ("check".equals(operate)) {

			// 验证用户名
			this.checkName(req, resp);
		}
	}

	/**
	 * 检查名字
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void checkName(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		// 获取前端参数
		String name = req.getParameter("uname");

		// 查询用户
		int i = new UserService().qeuryName(name);

		String result = "";

		if (i == 1) {

			result = "<font style='color:red;'>该用户名已存在！！！</font>";

		} else if (i == 0) {
			result = "<font style='color:green;'>该用户名可以注册！！！</font>";
		}
		// 返回给客户端

		resp.setContentType("text/html;charset=utf-8");

		resp.getWriter().print(result);
	}

	/**
	 * 根据用户名查询
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void selUser(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 获取用户名
		String name = req.getParameter("sel");

		// 获取当前页码
		int num = Integer.parseInt(req.getParameter("num") == null ? "1" : req
				.getParameter("num"));

		// 设置每页显示条数为5
		int size = 5;

		// 字符串
		String sql = "";
		int total = 0;
		if ("".equals(name)) {
			// 获取记录总数
			total = new UserService().getCount();

		} else {
			sql = "select count(*) from user where name like concat('%',?,'%')";
			// 获取记录总数
			total = new UserService().getCount(sql, name);
		}

		// 总页数
		int count = (int) Math.ceil(((total * 1.0) / size));

		// 查询数据
		List<User> userList = new UserService().queryUser(name, num, size);

		// 存储到作用域
		req.setAttribute("userList", userList);
		req.setAttribute("num", num);// 当前页
		req.setAttribute("total", total);// 总记录数
		req.setAttribute("count", count);// 总页数
		// 跳转
		req.getRequestDispatcher("/user/selUser.jsp").forward(req, resp);

		return;
	}

	/**
	 * 修改用户
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void updateReal(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 实例化Service
		UserService userService = new UserService();

		// 实例化User类
		User user = this.getUserObject(req, resp);

		// 执行添加方法
		int result = userService.updateUser(user);

		 String sel = req.getParameter("sel");
		String control = req.getParameter("control");

		// 判断
		if (result > 0) {
			System.err.println("修改成功!!!");

			req.setAttribute("message", "修改");
			req.setAttribute("sel", sel);
			if ("norUpdate".equals(control)) {

				req.getRequestDispatcher("/user/success.jsp")
						.forward(req, resp);
				return;
			} else if ("conUpdate".equals(control)) {

				this.selUser(req, resp);
				return;
			}

		} else {
			System.err.println("修改失败!!!");
		}

	}

	/**
	 * 删除用户
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void deleteUser(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 获取前台数据
		int id = Integer.parseInt(req.getParameter("id"));
		String del = req.getParameter("control");

		// 执行删除操作
		boolean flag = new UserService().delete(id);

		if (flag) {
			System.out.println("用户删除------------成功!");

			req.setAttribute("message", "删除");

			if (del.equals("conDel")) {

				// 跳转
				this.selUser(req, resp);
				return;
			} else if (del.equals("norDel")) {
				// 跳转
				req.getRequestDispatcher("/user/success.jsp")
						.forward(req, resp);
			}
		} else {
			System.out.println("用户删除-------------失败");
		}

	}

	/**
	 * 预修改
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void updatePre(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 获取用户想要修改的用户信息
		int id = Integer.parseInt(req.getParameter("id"));
		String sel = req.getParameter("sel");
		String control = req.getParameter("control");

		// 取数据
		User user = new UserService().queryUserById(id);

		// 存入作用域中
		req.setAttribute("sel", sel);
		req.setAttribute("user", user);
		req.setAttribute("control", control);

		if (user != null) {

			System.out.println("用户修改-------预修改");

			// 跳转
			req.getRequestDispatcher("/user/updateUser.jsp").forward(req, resp);

			return;
		}

	}

	/**
	 * 添加用户
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void addUser(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 实例化Service
		UserService userService = new UserService();

		// 实例化User类
		User user = this.getUserObject(req, resp);

		// 执行添加方法
		int result = userService.addUser(user);

		// 判断
		if (result > 0) {
			System.err.println("添加成功!!!");

		} else {
			System.err.println("添加失败!!!");
		}

		// 跳转

		req.setAttribute("message", "添加");

		// this.getAllUserInfo(req, resp);
		req.getRequestDispatcher("/user/success.jsp").forward(req, resp);
	}

	/**
	 * 查询所有用户
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void getAllUserInfo(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 调用DAO层得到数据
		UserService userService = new UserService();

		// 分页显示

		// 获取当前页码
		int num = Integer.parseInt(req.getParameter("num") == null ? "1" : req
				.getParameter("num"));

		// 设置每页显示条数为5
		int size = 5;

		// 获取记录总数

		int total = new UserService().getCount();
		// 总页数
		int count = (int) Math.ceil(((total * 1.0) / size));

		List<User> userList = userService.queryAll(num, size);

		// 添加进作用域
		req.setAttribute("userList", userList);
		req.setAttribute("num", num);// 当前页
		req.setAttribute("total", total);// 总记录数
		req.setAttribute("count", count);// 总页数
		System.err.println("查询所有用户----成功");

		// 跳转
		req.getRequestDispatcher("/user/userInfo.jsp").forward(req, resp);

		return;
	}

	/**
	 * 退出
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void userOut(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		// 获取Session
		HttpSession session = req.getSession();

		// 销毁会话
		session.invalidate();
		// 跳转
		resp.sendRedirect(req.getContextPath() + "/login.jsp");
		return;
	}

	/**
	 * 登录功能
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void userLogin(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 获取客户端参数
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		// 校验用户信息
		User user = new UserService().queryUser(uname, pwd);
		// 创建session
		HttpSession session = req.getSession();
		// 对结果进行判断处理
		if (user != null) {

			// 将用户信息存储到Session中
			session.setAttribute("user", user);

			System.err.println("登录成功----login" + user.getName());

			// 跳转
			req.getRequestDispatcher("/main.jsp").forward(req, resp);
			return;
		} else {

			// 没找到用户信息
			req.setAttribute("errorInfo", "用户名或者密码错误!!!");

			System.err.println("登录失败----");

			// 跳转
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
	}

	/**
	 * 获取前端对象
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	public User getUserObject(HttpServletRequest req, HttpServletResponse resp) {

		// 声明User类
		User user = null;

		// 获取前台数据
		String id = req.getParameter("id");
		String name = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		String nickName = req.getParameter("nickname");
		String sex = req.getParameter("sex");
		String age = req.getParameter("age");
		String fav = req.getParameter("fav");

		if (id == null) {
			user = new User(name, pwd, nickName, sex, age, fav);
		} else {
			user = new User(Integer.parseInt(id), name, pwd, nickName, sex,
					age, fav);
		}
		return user;
	}
}
