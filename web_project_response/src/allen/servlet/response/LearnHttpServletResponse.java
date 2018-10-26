package allen.servlet.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author acer
 * 	
 *	HttpServletResponse (I)
 *	继承了ServletResponse(I)
 *	实现类是 ServletResponseWrapper
 *	服务器将响应信息封装成为一个特殊对象，是由服务器创建的 服务器将该对象作为一个参数传入到service方法中
 *	
 *
 *Http协议中的请求信息:
 *		
 *		响应行
 *			
 *			版本号			
 *	
 *			状态码
 *				
 *				2开头成功
 *				
 *				3开头重定向
 *				
 *				4开头找不到资源文件
 *				
 *				5,6开头服务器错误	
 *			
 *		响应头
 *		
 *		响应实体信息
 *
 */
public class LearnHttpServletResponse extends HttpServlet {

	/**
	 * 默认序列码
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//获取响应头信息
			
			//设置响应头  相当于key 唯一   如果出现重复的 会覆盖
			resp.setHeader("content-Type", "text/html; charset=utf-8");
			
			//添加响应头
			resp.addHeader("sxt", "mark");
			resp.addHeader("sxt", "mars");
			
			
		
	}

}
