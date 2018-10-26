/**
 * 
 */
package allen.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
public class HiELServlet2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 往不同的作用域存数据

		req.setAttribute("hello", "request");

		req.getSession().setAttribute("hello", "session");

		this.getServletContext().setAttribute("hello", "context");

		// 空

		req.setAttribute("e1", "");
		req.setAttribute("e1", " ");
		req.setAttribute("e2", null);
		req.setAttribute("e3", new ArrayList());
		req.setAttribute("e4", new HashMap());

		req.setAttribute("user", new User("earth", "momo", 66666, new Address(
				"BeiJing", "HaiDian", "ShangXueTang")));

		// 跳转

		req.getRequestDispatcher("/el2.jsp").forward(req, resp);

	}
}
