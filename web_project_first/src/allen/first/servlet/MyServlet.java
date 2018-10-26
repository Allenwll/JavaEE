package allen.first.servlet;

import java.io.IOException;

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
 */
public class MyServlet extends HttpServlet {


	private static final long serialVersionUID = -7630750534410531400L;

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("MyServlet.service()");
	}

}
