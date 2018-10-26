/**
 * 
 */
package allen.filter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author  Allen
 *
 * Title: KingServlet
 *
 * Description: 
 * 
 *	Company: 
 *  
 *  @date 2016年9月13日 下午2:25:39    
 *  
 *  Email:1303542271 @qq.com
 */
public class KingServlet extends HttpServlet {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("KingServlet.service(I'm the King！)");
	}
}
