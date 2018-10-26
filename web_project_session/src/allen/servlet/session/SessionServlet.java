/**
 * 
 */
package allen.servlet.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Allen
 * 
 *         Title: SessionServlet
 * 
 *         Description:
 * 
 *         HttpSession(I)
 * 
 *         会话，服务器端和客户端的交互
 * 
 *   Session:
 * 
 *         客户第一次访问项目的时候创建一个JSessionId
 * 
 *         第二次时直接使用前面的JSessionId
 * 
 * 	可不可以取消Cookie
 * 		
 * 			不可以，一旦浏览器关闭，JSessionId丢失，会话就结束了
 * 				
 * 			Session跟踪机制与Cookie关联
 * 				
 * 
 * 	加入浏览器管理，会话是否还会销毁
 * 		
 * 		会
 * 			
 * 			1.设置不活动周期,一旦超过不活动周期，Session自动销毁
 * 			
 * 			2.全局 默认限制 30分钟
 * 				
 * 				在服务器tomcat——>conf——>web.xml进行不活动周期的配置
 * 				
 * 				<session-config>
 * 											
 * 					<session-timeout>分钟</session-timeout>					
 * 
 * 				</session-config>					
 * 			
 * 			3.在当前项目的web.xml下进行配置	针对本项目		
 * 
 * 			4.在指定的Servlet中设置不活动周期，相当于重写了整个web项目的会话时间
 * 
 * 	Session-会话
 * 		
 * 		开始
 * 				
 * 			客户端向服务器发送请求的时候
 * 		
 * 		结束
 * 			
 * 			客户端
 * 				
 * 				丢失JSessionId时，即浏览器关闭
 * 
 * 			服务器端		
 * 				
 * 				关闭服务器
 * 				
 * 				超过不活动周期，会话自动销毁
 * 
 *         Company:
 * 
 * @date 2016年9月9日 上午9:15:05
 * 
 *       Email:1303542271 @qq.com
 */
public class SessionServlet extends HttpServlet {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 创建Session
		HttpSession session = req.getSession();

		
 		//设置不活动周期,一旦超过不活动周期，Session自动销毁
		session.setMaxInactiveInterval(10);//设置生存周期为十秒 ， 负数代表永不销毁
		
		//注销方式
		session.invalidate();
		
		// 打印Session唯一标识
		System.out.println("Session编号：" + session.getId());
		

	}

}
