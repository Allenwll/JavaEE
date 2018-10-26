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
 *         Title: ProvinceServlet
 * 
 *         Description: 省
 * 
 *         Company:
 * 
 * @date 2016年9月18日 上午9:57:28
 * 
 *       Email:1303542271 @qq.com
 */
public class ProvinceServlet extends HttpServlet {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置编码格式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 读取对象
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		Map<String, String> pHebei = new HashMap<String, String>();
		pHebei.put("code", "001");
		pHebei.put("name", "河北省");

		Map<String, String> pBeiJing = new HashMap<String, String>();
		pBeiJing.put("code", "002");
		pBeiJing.put("name", "北京市");

		Map<String, String> pHeNan = new HashMap<String, String>();
		pHeNan.put("code", "003");
		pHeNan.put("name", "河南省");

		list.add(pHeNan);
		list.add(pBeiJing);
		list.add(pHebei);

		// 返回给客户端
		// 一般这个时候需要引入第三方架包，把集合或者对象转换成json格式的字符串返回给客户端
		// google-gson.jar
		Gson gson = new Gson();
		String json = gson.toJson(list);
		response.getWriter().print(json);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
