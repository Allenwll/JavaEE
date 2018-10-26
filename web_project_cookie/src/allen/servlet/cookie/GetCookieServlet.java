/**
 * 
 */
package allen.servlet.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Allen
 * 
 *Title: GetCookieServlet 
 *
 *Description: 获取Cookie信息
 *
 * Company:
 *
 * @date 2016年9月8日 下午2:58:50
 * 
 * Email:1303542271@qq.com
 */
public class GetCookieServlet extends HttpServlet {

	/**
	 * 序列码
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

		// 获取Cookie信息
		Cookie[] cookies = req.getCookies();

		// 判断
		if (cookies != null && cookies.length > 0) {
			// 遍历
			for (int i = 0; i < cookies.length; i++) {
				System.out.println("cookie信息:" + cookies[i].getName() + "--->"
						+ cookies[i].getValue());
			}

			
		}
	}
}
