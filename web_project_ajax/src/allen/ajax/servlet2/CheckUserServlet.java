/**
 * 
 */
package allen.ajax.servlet2;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Allen
 * 
 *         Title: CheckUserServlet
 * 
 *         Description:
 * 
 *         Company:
 * 
 * @date 2016年9月18日 下午3:28:17
 * 
 *       Email:1303542271 @qq.com
 */
public class CheckUserServlet extends HttpServlet {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取前台数据
		String uname = request.getParameter("uname");

		// 数据库中已有的值
		List<String> userList = Arrays.asList("aaa","bbb","ccc","ddd");

		// 判断
		String result = null;
		if (userList.contains(uname)) {
			result = "<font style='color:red;'>该用户名已存在！！！</font>";
		} else {
			result = "<font style='color:green;'>该用户名可以注册！！！</font>";
		}
		// 返回给客户端

		response.setContentType("text/html;charset=utf-8");

		response.getWriter().print(result);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
