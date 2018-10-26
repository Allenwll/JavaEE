/**
 * 
 */
package allen.servlet.jstl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Allen
 * 
 *         Title: JSTLServlet
 * 
 *         Description:
 * 
 *         Company:
 * 
 * @date 2016年9月11日 上午11:41:12
 * 
 *       Email:1303542271 @qq.com
 */
public class JSTLServlet extends HttpServlet {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 设置

		req.setAttribute("hello", "I'm here!");

		req.setAttribute("bj", "sxt");

		List<String> list = new ArrayList<String>();

		list.add("aa");
		list.add("bb");
		list.add("cc");
		list.add("dd");
		list.add("ee");

		req.setAttribute("list", list);

		Map<String, String> map = new HashMap<String, String>();

		map.put("x", "xx");
		map.put("y", "yy");
		map.put("z", "zz");

		req.setAttribute("map", map);

		// 存储分数
		req.setAttribute("score", (int) Math.random() * 101);

		// 跳转
		req.getRequestDispatcher("index.jsp").forward(req, resp);

		return;
	}
}
