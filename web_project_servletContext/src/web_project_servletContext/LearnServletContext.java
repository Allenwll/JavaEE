/**
 * 
 */
package web_project_servletContext;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Allen
 * 
 *         Title: LearnServletContext
 * 
 *         Description: Servlet上下文 又名 application
 * 
 *         对于整个web项目来说，只有一个全局对象
 * 
 *         1.获取全局配置文件
 * 
 *         3.获取项目部署的绝对路径
 * 
 *         2.获取WebRoot下的文件
 * 
 * 
 *         Company:
 * 
 * @date 2016年9月8日 下午4:04:18
 * 
 *       Email:1303542271 @qq.com
 */
public class LearnServletContext extends HttpServlet {

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

		/**
		 * 获取全局对象
		 **/

		// 第一种方式
		ServletContext sc = this.getServletContext();

		// 第二种方式
		ServletContext sc1 = this.getServletConfig().getServletContext();

		// 第三种方式
		ServletContext sc2 = req.getSession().getServletContext();

		// 判断是不是同一个对象
		System.out.println(sc == sc1);
		System.out.println("对象标识：" + sc.hashCode() + "--->" + sc1.hashCode()
				+ "--->" + sc2.hashCode());

		// 获取配置文件的值
		System.out.println(sc.getInitParameter("boss"));
		System.out.println(sc.getInitParameter("wife"));

		// 2.获取项目部署的绝对路径
		System.out.println(sc.getRealPath(""));
		System.out.println(sc.getRealPath("/"));
		System.out.println(sc.getRealPath("/upload"));

		// 获取src下的文件

		// LearnServletContext.class.getClassLoader().getResourceAsStream("DBUtil.properties");

		// Thread.currentThread().getContextClassLoader().getResourceAsStream("DBUtil.properties");

		// 获取WebRoot下的文件
		sc.getResourceAsStream("index.jsp");
	}
}
