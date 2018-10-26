/**
 * 
 */
package allen.ajax.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * @author Allen
 * 
 *         Title: CountyServlet
 * 
 *         Description: 县
 * 
 *         Company:
 * 
 * @date 2016年9月18日 上午10:43:48
 * 
 *       Email:1303542271 @qq.com
 */
public class CountyServlet extends HttpServlet {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取前端参数
		String cCode = request.getParameter("cCode");

		// 实例化容器
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		if (cCode.equals("001001")) {
			Map<String, String> c1 = new HashMap<String, String>();
			c1.put("name", "长安区");
			c1.put("code", "001001001");
			Map<String, String> c2 = new HashMap<String, String>();
			c2.put("name", "新华区");
			c2.put("code", "001001002");
			Map<String, String> c3 = new HashMap<String, String>();
			c3.put("name", "裕华区");
			c3.put("code", "001001003");
			list.add(c1);
			list.add(c2);
			list.add(c3);
		} else if (cCode.equals("002001")) {
			Map<String, String> c1 = new HashMap<String, String>();
			c1.put("name", "西三旗");
			c1.put("code", "002001001");
			Map<String, String> c2 = new HashMap<String, String>();
			c2.put("name", "西二旗");
			c2.put("code", "002001002");
			Map<String, String> c3 = new HashMap<String, String>();
			c3.put("name", "清河");
			c3.put("code", "002001003");
			list.add(c1);
			list.add(c2);
			list.add(c3);
		} else if (cCode.equals("003001")) {
			Map<String, String> c1 = new HashMap<String, String>();
			c1.put("name", "二七区");
			c1.put("code", "003001001");
			Map<String, String> c2 = new HashMap<String, String>();
			c2.put("name", "高新区");
			c2.put("code", "003001002");
			Map<String, String> c3 = new HashMap<String, String>();
			c3.put("name", "金水区");
			c3.put("code", "003001003");
			list.add(c1);
			list.add(c2);
			list.add(c3);
		}
		// 设置解析方式
		response.setContentType("text/html;charset=utf-8");
		// 返回JSON格式
		response.getWriter().println(new Gson().toJson(list));

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
