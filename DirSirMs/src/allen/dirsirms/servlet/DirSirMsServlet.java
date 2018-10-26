package allen.dirsirms.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import allen.dirsirms.entity.Goods;
import allen.dirsirms.entity.Manager;
import allen.dirsirms.service.DirSirMsService;

public class DirSirMsServlet extends HttpServlet {

	/**
	 * 序列值
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 设置编码格式
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		// 获取前台参数
		String action = req.getParameter("method");

		// 分支判断
		if ("login".equals(action)) {
			try {
				this.login(req, resp);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else if ("query".equals(action)) {

			try {
				this.query(req, resp);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 查询所有
	 * 
	 * @param req
	 * @param resp
	 * @throws SQLException
	 * @throws IOException
	 * @throws ServletException 
	 */
	private void query(HttpServletRequest req, HttpServletResponse resp)
			throws SQLException, IOException, ServletException {

		// 获取当前页码
		int num = Integer.parseInt(req.getParameter("num") == null ? "1" : req
				.getParameter("num"));

		// 设置每页显示条数为2
		int size = 2;

		int total = 0;

		// 获取记录总数
		total = new DirSirMsService().getCount();

		// 总页数
		int count = (int) Math.ceil(((total * 1.0) / size));

		// 查询数据
		List<Goods> goodsList = new DirSirMsService().queryGoods(num, size);

		// 存储到作用域
		req.setAttribute("list", goodsList);
		req.setAttribute("num", num);// 当前页
		req.setAttribute("count", count);// 总页数

		// 重定向
		// resp.sendRedirect(req.getContextPath() + "/manage/index.jsp");
		req.getRequestDispatcher("manage/index.jsp").forward(req, resp);
		return;
	}

	/**
	 * 登录
	 * 
	 * @param req
	 * @param resp
	 * @throws SQLException
	 * @throws IOException
	 * @throws ServletException
	 */
	private void login(HttpServletRequest req, HttpServletResponse resp)
			throws SQLException, IOException, ServletException {

		// 得到前台参数
		String manager = req.getParameter("manager");
		String pwd = req.getParameter("PWD");

		System.out.println(manager + "  " + pwd);
		// 设置参数
		Manager mgr = new Manager(manager, pwd);

		// 执行login方法
		boolean flag = new DirSirMsService().login(mgr);

		if (flag) {
			this.query(req, resp);

		} else {
			// 请求转发
			req.setAttribute("MSG", "用户名或者密码错误!");
			req.getRequestDispatcher("manage/Login_M.jsp").forward(req, resp);
			return;
		}
	}
}
