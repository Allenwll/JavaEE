package allen.servlet.charset;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CharsetDealServlet extends HttpServlet {

	/**
	 * 序列码
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// post方式乱码处理
		req.setCharacterEncoding("utf-8");

		/*
		 * get 方式乱码处理 1.req.setCharacterEncoding("utf-8");
		 * 2.在tomcat服务器下的config下server.xml下Connector 下加入
		 * useBodyEncodingForURI="true"
		 */
		// 获取请求参数信息
		String uname = req.getParameter("name");
		String realname = req.getParameter("realname");

		// 在控制台进行输出
		System.out.println("用户名:" + uname + "\n真名:" + realname);
	
		
		//设置响应输出的编码集
		
			//resp.setCharacterEncoding("utf-8");
			
		//告诉浏览器解析的编码格式
			
			resp.setHeader("content-type", "text/html;charset=utf-8");//第一种
				
			resp.setContentType("text/html;charset=utf-8");//第二种
		//响应输出
		resp.getWriter().print(realname);
	}
}
