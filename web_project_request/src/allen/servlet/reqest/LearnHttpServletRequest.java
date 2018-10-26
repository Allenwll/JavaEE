package allen.servlet.reqest;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author acer
 * 	
 *	HttpServletRequest (I)
 *	继承了ServletRequest(I)
 *	实现类是 ServletRequestWrapper
 *	服务器将请求信息封装成为一个特殊对象，是由服务器创建的 服务器将该对象作为一个参数传入到service方法中
 *	
 *	缺点:
 *		servlet依赖于servlet容器，耦合度较高
 *
 *Http协议中的请求信息:
 *		
 *		请求行
 *			
 *			提交方式
 *			
 *			URL		
 *
 *			版本号				
 *		
 *		请求头
 *		
 *		网络信息
 *
 *		请求实体信息
 *
 */
public class LearnHttpServletRequest extends HttpServlet {

	/**
	 * 默认序列码
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
		//请求行	
		testRequestLine(req);
		
		//请求头
		testRequestHead(req);
		
		//网络信息
		testRequestNet(req);
		
		//实体内容
		testRequestContent(req);
	}

	/**获取实体内容
	 * @param req
	 */
	private void testRequestContent(HttpServletRequest req) {
			
		
		//1.前台数据项没有任何value值时 获得""空字符串
		
		//2.前台数据项没有对应name属性时 获得null
		
		//获取单个值
		String name=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		System.out.println("用户信息:   姓名:"+name+"-----密码:"+pwd);
		
		//获取多个值
		String[] fav=req.getParameterValues("fav");
		
		//遍历
		if(fav!=null && fav.length>0){
			for (int i = 0; i < fav.length; i++) {
				System.out.println("爱好:"+fav[i]);
			}
		}
	}

	/**获取网络信息
	 * @param req
	 */
	private void testRequestNet(HttpServletRequest req) {
		
		//获取客户端网络信息
		System.out.println("客户端: 地址--->"+req.getRemoteAddr());
		System.out.println("客户端: 端口--->"+req.getRemotePort());
		System.out.println("客户端: 主机--->"+req.getRemoteHost());
		System.out.println("客户端: 用户--->"+req.getRemoteUser());
		//获取服务器端网络信息
		System.out.println("服务器: 地址--->"+req.getLocalAddr());
		System.out.println("服务器: 端口--->"+req.getLocalPort());
		System.out.println("服务器: 用户--->"+req.getLocalName());
	}

	/**
	 * @param req
	 * 获取请求头信息
	 */
	private void testRequestHead(HttpServletRequest req) {
			
		//获取指定请求头信息
			System.out.println("获取User-Agent:"+req.getHeader("User-Agent"));
			System.out.println("获取User-Agent:"+req.getHeader("User-agent"));
			
		//获取所有请求头信息
		@SuppressWarnings("unchecked")
		Enumeration<String> names=req.getHeaderNames();
		
		//进行遍历
		while(names.hasMoreElements()){
		String name=names.nextElement();
		System.out.println(name+"--->"+req.getHeader(name));
		}
	}

	/**
	 * 获取请求行信息
	 * @param req
	 */
	private void testRequestLine(HttpServletRequest req) {
		
		System.out.println("请求方式:"+req.getMethod());
		System.out.println("协议:"+req.getScheme());
		System.out.println("http协议版本号:"+req.getProtocol());
		System.out.println("资源路径URL:"+req.getRequestURL());
		System.out.println("资源路径URi:"+req.getRequestURI());
		System.out.println("请求方式 的信息:"+req.getQueryString());
		System.out.println("项目在服务器中的部署名:"+req.getContextPath());
	}
}
