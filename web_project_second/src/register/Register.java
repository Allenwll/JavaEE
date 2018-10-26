package register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 获取前台传过来的参数值 request.getParameter("uname"),只能适用于只有一个的参数项
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		// String fav=request.getParameter("fav");
		
		// request.getParameterValues("fav");用于获取有多个值的数据项
		String[] fav = request.getParameterValues("fav");
		String school = request.getParameter("school");
		String intro = request.getParameter("intro");

		// 对数组进行遍历
		for (String s : fav) {
			System.out.print(s + " ");
		}

		// 对获取到的值进行输出
		System.out.println("注册信息：" + uname + "\t" + pwd + "\t" + gender + "\t"
				+ fav + "\t" + school + "\t" + intro);

	}

}
