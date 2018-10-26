package allen.first.servlet;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 
 * @author Allen Wang
 * 
 * @Email 1303542271@qq.com
 * 
 * 
 * 
 * 
 * 
 */
public class HelloServlet extends HttpServlet {
	
	private static final long serialVersionUID = 6865434361023457749L;
	
	 
	/* (non-Javadoc) 重写父类service方法
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("i am allen  " + new Date() + "  " + " "
				+ req.getRemoteAddr());
	}
}
