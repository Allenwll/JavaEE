package allen.lift.singleton;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("我来了" + this.hashCode());
	}

	/*
	 * @Override protected void doGet(HttpServletRequest req,
	 * HttpServletResponse resp) throws ServletException, IOException { }
	 * 
	 * @Override protected void doPost(HttpServletRequest req,
	 * HttpServletResponse resp) throws ServletException, IOException { }
	 */

	@Override
	public void destroy() {
		System.out.println("我走了");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("别闹了");
	}
}
