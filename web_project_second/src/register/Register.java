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
		
		// ��ȡǰ̨�������Ĳ���ֵ request.getParameter("uname"),ֻ��������ֻ��һ���Ĳ�����
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		// String fav=request.getParameter("fav");
		
		// request.getParameterValues("fav");���ڻ�ȡ�ж��ֵ��������
		String[] fav = request.getParameterValues("fav");
		String school = request.getParameter("school");
		String intro = request.getParameter("intro");

		// ��������б���
		for (String s : fav) {
			System.out.print(s + " ");
		}

		// �Ի�ȡ����ֵ�������
		System.out.println("ע����Ϣ��" + uname + "\t" + pwd + "\t" + gender + "\t"
				+ fav + "\t" + school + "\t" + intro);

	}

}
