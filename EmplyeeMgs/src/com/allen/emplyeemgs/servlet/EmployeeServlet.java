package com.allen.emplyeemgs.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.allen.emplyeemgs.entity.Department;
import com.allen.emplyeemgs.entity.Employee;
import com.allen.emplyeemgs.service.impl.EmployeeServiceImpl;
import com.google.gson.Gson;

/***
 * Title: EmployeeServlet
 * 
 * Description:
 * 
 * MVC之员工控制层
 * 
 * Company: 个人
 * 
 * @author Allen Wang
 * 
 * @email:1303542271@qq.com
 * 
 * @date 2016年9月27日 下午2:23:10
 * 
 */
public class EmployeeServlet extends HttpServlet {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 设置编码格式
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		// 获取前台参数
		String method = req.getParameter("method");

		// 分支选择
		if ("query".equals(method)) {

			// 查询
			this.queryEmployee(req, resp);
		} else if ("findDept".equals(method)) {

			// 查询部门
			this.findDept(req, resp);
		} else if ("add".equals(method)) {

			// 添加员工
			this.add(req, resp);
		}

	}

	// 添加员工
	private void add(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Employee emp = null;

		// 获取前台数据
		String e_name = req.getParameter("e_name");
		int e_age = Integer.parseInt(req.getParameter("e_age"));
		double e_laborage = Double.parseDouble(req.getParameter("e_laborage"));
		String e_address = req.getParameter("e_address");
		int e_deptno = Integer.parseInt(req.getParameter("dept"));

		emp = new Employee(e_name, e_age, e_laborage, e_address, e_deptno);

		// 执行添加
		boolean flag = new EmployeeServiceImpl().add(emp);

		if (flag) {

			String str = "添加员工成功!";
			System.out.println(str);

			req.setAttribute("Msg", str);

		} else {

			String str = "添加员工失败!";
			System.out.println(str);
			req.setAttribute("Msg", str);
		}

		// 跳转
		req.getRequestDispatcher("/result.jsp").forward(req, resp);
		return;
	}

	// 查询部门
	private void findDept(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		// 执行查询
		List<Department> dept = new EmployeeServiceImpl().findDept();

		// 返回
		resp.getWriter().print(new Gson().toJson(dept));

		return;
	}

	/**
	 * 查询员工
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void queryEmployee(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 获取前端参数
		String e_name = req.getParameter("e_name");

		// 进数据库查询数据
		List<Employee> empList = new EmployeeServiceImpl().queryEmp(e_name);

		// 设置作用域
		req.setAttribute("empList", empList);

		System.out.println("查询成功!!!");

		// 跳转显示
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		return;
	}
}
