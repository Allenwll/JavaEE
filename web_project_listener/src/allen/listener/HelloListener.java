/**
 * 
 */
package allen.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author Allen
 * 
 *         Title: HelloListener
 * 
 *         Description: 监听器(统计一个网站的 在线人数)
 * 
 *    					 ServletContext
 * 
 *        				 HttpSession
 * 
 *       				  ServletRequest
 * 
 *         生命周期
 * 
 *         		init
 * 
 *		         destroy
 * 
 * 
 *         值的变化
 * 
 *      	   set
 * 
 *         			add
 * 
 *         			replace
 * 
 *	         get
 * 
 *  			       不监听
 * 
 *	         remove
 * 
 *  		       remove
 * 
 *     具体实现: 
 *     
 *     		XXXListener和 XXXXAttributeListener			
 *     
 *     	Company:
 * 
 * @date 2016年9月13日 下午4:06:45
 * 
 *       Email:1303542271 @qq.com
 */
public class HelloListener implements ServletRequestAttributeListener,
		ServletRequestListener, HttpSessionListener,
		HttpSessionAttributeListener, ServletContextAttributeListener,
		ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("开启ServletContextListener监听!");

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("结束ServletContextListener监听!");

	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		System.out.println("全局属性值添加的监听");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		System.out.println("全局属性值移除的监听");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		System.out.println("全局属性值更改的监听");
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		System.out.println("会话绑定属性值添加的监听");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		System.out.println("会话绑定属性值移除的监听");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		System.out.println("会话绑定属性值更改 的监听");
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("创建session监听");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("结束session监听");
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("结束请求监听");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("初始化请求监听");
	}

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("请求属性值添加的监听");
	
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("请求属性值移除的监听");
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("请求属性值更改的监听");
	}

}
