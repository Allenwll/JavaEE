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
 *         Title: CityServlet
 * 
 *         Description:市
 * 
 *         Company:
 * 
 * @date 2016年9月18日 上午10:36:12
 * 
 *       Email:1303542271 @qq.com
 */
public class CityServlet extends HttpServlet {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码格式
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// response.setHeader("content-type", "text/html;charset=utf-8");

		// 获取前端参数
		String pCode = request.getParameter("pCode");
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		// 判断
		if (pCode.equals("001")) {
			Map<String, String> c1 = new HashMap<String, String>();
			c1.put("name", "石家庄");
			c1.put("code", "001001");
			Map<String, String> c2 = new HashMap<String, String>();
			c2.put("name", "保定");
			c2.put("code", "001002");
			Map<String, String> c3 = new HashMap<String, String>();
			c3.put("name", "张家口");
			c3.put("code", "001003");
			list.add(c1);
			list.add(c2);
			list.add(c3);
		} else if (pCode.equals("002")) {
			Map<String, String> c1 = new HashMap<String, String>();
			c1.put("name", "海淀区");
			c1.put("code", "002001");
			Map<String, String> c2 = new HashMap<String, String>();
			c2.put("name", "朝阳区");
			c2.put("code", "002002");
			Map<String, String> c3 = new HashMap<String, String>();
			c3.put("name", "昌平区");
			c3.put("code", "002003");
			list.add(c1);
			list.add(c2);
			list.add(c3);
		} else if (pCode.equals("003")) {
			Map<String, String> c1 = new HashMap<String, String>();
			c1.put("name", "郑州市");
			c1.put("code", "003001");
			Map<String, String> c2 = new HashMap<String, String>();
			c2.put("name", "新乡市");
			c2.put("code", "003002");
			Map<String, String> c3 = new HashMap<String, String>();
			c3.put("name", "洛阳市");
			c3.put("code", "003003");
			list.add(c1);
			list.add(c2);
			list.add(c3);
		}
		
		//设置编码格式
		response.setContentType("text/html;charset=utf-8");
		
		//转换成JSON格式
		response.getWriter().println(new Gson().toJson(list));

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
