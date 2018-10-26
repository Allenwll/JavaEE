/**
 * 
 */
package allen.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import allen.bean.Address;
import allen.bean.User;

/**
 * @author Allen
 * 
 *         Title: HiELServlet
 * 
 *         Description:
 * 
 *         Company:
 * 
 * @date 2016年9月10日 下午5:08:07
 * 
 *       Email:1303542271 @qq.com
 */
public class HiELServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 获取请求参数
		String name = req.getParameter("uname");
		String pwd = req.getParameter("pwd");

		System.out.println("请求参数: uname:" + name + "\tpwd:" + pwd);

		// 向作用域存数据
		req.setAttribute("realname", "tantan");

		// 模拟

		List<String> list = new ArrayList<String>();
		list.add("Marks");
		list.add("Mark");
		list.add("Andy");

		req.setAttribute("list", list);

		Map<String, String> map = new HashMap<String, String>();
		map.put("x", "110");
		map.put("y", "112");
		map.put("z", "114");

		req.setAttribute("map", map);

		req.setAttribute("user", new User("earth", "momo", 66666, new Address(
				"BeiJing", "HaiDian", "ShangXueTang")));
		List<User> userList = new ArrayList<User>();

		userList.add(new User("moon", "momo", 666, new Address("BeiJing",
				"HaiDian", "ShangXueTang")));
		userList.add(new User("sun", "lulu", 888, new Address("BeiJing",
				"HaiDian", "XiSanQi")));
		userList.add(new User("star", "tantan", 666, new Address("BeiJing",
				"HaiDian", "DongErQi")));

		req.setAttribute("userList", userList);

		Map<String, User> userMap = new HashMap<String, User>();
		userMap.put("a", new User("moon", "momo", 666, new Address("BeiJing",
				"HaiDian", "ShangXueTang")));
		userMap.put("b", new User("sun", "lulu", 888, new Address("BeiJing",
				"HaiDian", "XiSanQi")));
		userMap.put("c", new User("star", "tantan", 666, new Address("BeiJing",
				"HaiDian", "DongErQi")));
		
		
		req.setAttribute("userMap", userMap);

		// 跳转
		req.getRequestDispatcher("el.jsp").forward(req, resp);
		return;
	}
}
