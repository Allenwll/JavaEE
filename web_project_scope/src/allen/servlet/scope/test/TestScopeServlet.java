/**
 * 
 */
package allen.servlet.scope.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Allen
 * 
 *Title: TestScopeServlet 作用域
 * 
 *Description: 作用域
 * 
 *     数据传递，保存数据
 * 
 *     要使用值的传递，必须先了解作用域对应的生命周期和使用范围
 * 
 *         
 * 生命周期
 * 
 *         	
 *   	request：只限于一次请求
 * 
 *         		
 *      session: 一次会话
 * 
 *         	开始:
 *         						
 *         		客户端发送请求
 * 
 *         	结束：
 * 
 *         		服务端:
 * 
 *         			关闭服务器
 * 
 *         			超过会话时间，自动销毁
 * 				
 * 				客户端：
 * 					
 * 					关闭浏览器
 * 
 *		
 *		application:项目加载到卸载
 *
 * 使用范围
 * 
 *         request:所有被请求转发的Servlet
 * 
 *         session:所有Servlet
 * 
 *         application:所有的Servlet(换一个浏览器，区分session和application)
 * 
 *如何选择作用域的使用:
 *			
 *		如果选择不对应，会造成什么后果
 *			
 *			浪费内存
 *
 * 		request:跟当前操作相关
 * 		
 * 		session:跟用户信息相关
 * 		
 * 		application:跟项目全局信息相关
 * 
 * @date 2016年9月9日 上午10:52:03
 * 
 * Email:1303542271 @qq.com
 */
public class TestScopeServlet extends HttpServlet {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("TestScopeServlet.service(测试)");

		// 获取Request作用域的值
		String testRequestId = (String) req.getAttribute("requestId");

		// 输出
		System.out.println("获取Request请求值:" + testRequestId);

		System.out.println("------------分割线------------");

		// 获取Session作用域的值，测试并输出
		String testSessionId = (String) req.getSession().getAttribute(
				"sessionId");

		// 输出
		System.out.println("获取Session请求值:" + testSessionId);

		System.out.println("------------分割线------------");

		// 获取Application作用域的值，测试并输出

		String appId = (String) this.getServletContext().getAttribute("uname");

		// 输出
		System.out.println("获取Application请求值:" + appId);
	}

}
