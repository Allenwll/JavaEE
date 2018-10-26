/**
 * 
 */
package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.StudentService;
import service.UserService;
import service.impl.StudentServiceImpl;
import service.impl.UserServiceImpl;
import entity.Student;
import entity.User;

/**
 * @author Allen
 * 
 *         Title: OperatorServlet
 * 
 *         Description:
 * 
 *         Company:
 * 
 * @date 2016年9月18日 下午9:03:30
 * 
 *       Email:1303542271 @qq.com
 */
public class OperatorServlet extends HttpServlet {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 设置编码格式
		req.setCharacterEncoding("utf-8");
		resp.setHeader("content-type", "text/html;charset=utf-8");

		// 获取前台参数
		String method = req.getParameter("method");

		System.out.println("method=" + method);

		if ("create".equals(method)) {
			this.create(req, resp);
		} else if ("register".equals(method)) {
			this.register(req, resp);
		} else if ("logOut".equals(method)) {
			this.logOut(req, resp);
		} else if ("delete".equals(method)) {
			this.delete(req, resp);
		} else if ("update".equals(method)) {
			this.update(req, resp);
		} else if ("login".equals(method)) {
			this.login(req, resp);
		} else if ("queryAll".equals(method)) {
			this.queryAll(req, resp);
		} else if ("choiceQuery".equals(method)) {
			this.choiceQuery(req, resp);

		}

	}

	/**
	 * 条件查询
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void choiceQuery(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 获取前台参数
		String name = req.getParameter("name");
		double score = Double.parseDouble(req.getParameter("score"));
		int clazz = Integer.parseInt(req.getParameter("clazz"));

		req.setAttribute("name", name);
		String sql = null;

		switch (clazz) {
		case -1:

			sql = "select * from t_student where name like '%" + name
					+ "%' and score>" + score;
			break;
		case 1:
			sql = "select * from t_student where name like '%" + name
					+ "%' and score>" + score + "and classId =" + 1;
			break;
		case 2:
			sql = "select * from t_student where name like '%" + name
					+ "%' and score>" + score + "and classId =" + 2;
			break;
		case 3:
			sql = "select * from t_student where name like '%" + name
					+ "%' and score>" + score + "and classId =" + 3;
			break;
		default:

		}

		// 实例化服务层
		StudentService service = new StudentServiceImpl();

		// 实例化容器对象
		List<Student> list = new ArrayList<Student>();

		list = service.queryByChoice(sql);

		req.setAttribute("stuList", list);

		req.getRequestDispatcher("/show.jsp").forward(req, resp);

		return;

	}

	/**
	 * 查询所有
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void queryAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 实例化服务层
		StudentService service = new StudentServiceImpl();

		// 实例化容器对象
		List<Student> list = new ArrayList<Student>();

		// 调用dao层方法
		list = service.queryAll();

		req.setAttribute("myName", req.getParameter("uname"));
		req.setAttribute("Count", req.getParameter("count"));
		req.setAttribute("stuList", list);

		req.getRequestDispatcher("/show.jsp").forward(req, resp);
		return;
	}

	/**
	 * 登录
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void login(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 得到前端数据
		String name = req.getParameter("username");
		String pwd = req.getParameter("password");

		// 设置逻辑值ֵ
		boolean flag = false;

		// 实例化
		User user = new User();

		// 设置姓名
		user.setUsername(name);
		user.setPassword(pwd);

		// 实例化
		UserService userService = new UserServiceImpl();

		// 得到逻辑值
		flag = userService.login(user);

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

			user.setCount(user.getCount() + 1);

			req.setAttribute("myCount", user.getCount());
			// 请求转发
			req.getRequestDispatcher("operatorPage.jsp").forward(req, resp);
			return;

		} else {
			// 重定向
			resp.sendRedirect(req.getContextPath() + "/login.html");
			return;
		}
	}

	/**
	 * 修改
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void update(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		// 获取前端参数
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String score = req.getParameter("score");
		String age = req.getParameter("age");
		int clazzId = Integer.parseInt(req.getParameter("clazz"));

		// 实例化
		StudentService service = new StudentServiceImpl();

		Student student = new Student();

		student.setId(Integer.parseInt(id));
		student.setName(name);
		student.setScore(Double.parseDouble(score));
		student.setAge(Integer.parseInt(age));
		student.setClassId(clazzId);

		int result = 0;

		result = service.updateStudent(student);

		if (result > 0) {
			resp.getWriter().write("修改成功!");

		} else {
			resp.getWriter().write("修改失败!");
		}

		// 跳转
		req.getRequestDispatcher("/operator.action?method=queryAll").forward(
				req, resp);

		return;
	}

	/**
	 * 删除
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void delete(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		// 获取前台数据
		String id = req.getParameter("stuId");

		// 实例化服务层
		StudentService service = new StudentServiceImpl();

		int result = 0;

		// 调用方法
		result = service.deleteStudent(Integer.parseInt(id));

		if (result > 0) {
			resp.getWriter().write("删除成功!");

		} else {
			resp.getWriter().write("删除失败!");
		}
	
		// 跳转
		req.getRequestDispatcher("/operator.action?method=queryAll").forward(
				req, resp);
		return;
	}

	/**
	 * 注销
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */
	private void logOut(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		// 防止创建Session
		HttpSession session = req.getSession(false);

		if (session == null) {
			// 重定向
			req.getRequestDispatcher("/login.html").forward(req, resp);
			return;
		}

		// 移除属性
		session.removeAttribute("username");
		
		//销毁会话
		session.invalidate();
		
		// 获取所有Cookie
		Cookie[] cookies = req.getCookies();

		// 如果有cookie
		if (cookies != null) {

			// 遍历查询是否有该Cookie
			for (Cookie cookie : cookies) {
				cookie.setMaxAge(0);
			}
		}
		// 重定向
		resp.sendRedirect(req.getContextPath() + "/login.html");
		return;
	}

	/**
	 * 注册
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void register(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		// 获取前端数据
		String name = req.getParameter("username");
		String password = req.getParameter("password");

		// 实例化服务层
		UserService service = new UserServiceImpl();

		// 实例化
		User user = new User();

		// 设置值
		user.setUsername(name);
		user.setPassword(password);

		// 变量
		boolean flag = false;
		// 执行添加方法
		flag = service.addUser(user);

		if (flag) {
			resp.getWriter().write("添加成功!");

		} else {
			resp.getWriter().write("添加失败!");
		}
		// 跳转
		req.getRequestDispatcher("/operatorPage.jsp").forward(req, resp);
		return;
	}

	/**
	 * 新建
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void create(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		// 获取前端数据
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String score = req.getParameter("score");
		int clazzId = Integer.parseInt(req.getParameter("clazz"));

		// 实例化学生类
		Student student = new Student();

		// 实例化服务层
		StudentService service = new StudentServiceImpl();

		// 设置值
		student.setName(name);
		student.setAge(Integer.parseInt(age));
		student.setScore(Double.parseDouble(score));
		student.setClassId(clazzId);

		// 变量
		int result = 0;
		// 执行添加方法
		result = service.addStudent(student);

		if (result > 0) {
			resp.getWriter().write("添加成功!");

		} else {
			resp.getWriter().write("添加失败!");
		}
		// 跳转
		req.getRequestDispatcher("/operator.action?method=queryAll").forward(
				req, resp);
		return;
	}
}
