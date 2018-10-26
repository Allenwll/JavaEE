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
 *         <p>
 *         Title: CookieServlet
 *         </p>
 *         <p>
 *         Description:由Servlet创建并将少量信息返回给客户端保存
 *         </p>
 * 
 *         设置Cookie的生存周期 cookie.SetMaxAge(seconds);
 * 
 *         1. 未设置存活时间，保存在浏览器内存中，浏览器一关闭就消亡
 * 
 *         2. 设置存活时间,保存在硬盘上，时间一到就销毁
 * 
 *         查看Cookie的生存周期   看调试工具的Expires属性值
 *         
 *         查看Cookie的访问路径   看调试工具的Path属性值
 *         
 *         可以设置cookie的访问机制 url，目的是更加合理的使用cookie
 * 
 *         <p>
 *         Company:
 *         </p>
 * @date 2016年9月8日 上午11:29:06 Email:1303542271@qq.com
 */
public class CookieServlet extends HttpServlet {

	/**
	 * 序列
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

		// 创建Cookie
		Cookie comCookie = new Cookie("computer", "Acer");
		Cookie mouseCookie = new Cookie("mouse", "RazerMantis");
		Cookie keyBoardCookie = new Cookie("keyBoard", "DoubleFlySwallow");

		// 保存三天 传入的是秒数
		mouseCookie.setMaxAge(60 * 60 * 24 * 3);

		// 动态设置访问路径
			
		//  '/car' 相当于 '/a*'
		keyBoardCookie.setPath(req.getContextPath() + "/car");

		// 响应给客户端
		resp.addCookie(mouseCookie);
		resp.addCookie(comCookie);
		resp.addCookie(keyBoardCookie);

	}
}
