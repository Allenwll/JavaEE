package com.bjsxt.jqlearning.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductServlet extends HttpServlet {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String product = req.getParameter("product");
		String html = "<img src='img/" + product + ".jpg'/>";
		resp.setHeader("content-type", "text/html;charset=utf-8");
		resp.getWriter().print(html);
	}
}
