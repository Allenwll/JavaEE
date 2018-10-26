package com.bjsxt.jqlearning.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class NewsServlet extends HttpServlet {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 5763203059647430204L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 得到前台数据
		String ntype = req.getParameter("ntype");

		// 面向接口编程
		List<Map<String, String>> newsList = new ArrayList<Map<String, String>>();

		// 分支选择
		if ("local".equals(ntype)) {

			newsList.add(this.createNews("中国食品绝对安全", "你们相信吗？", "2016-8-4"));
			newsList.add(this.createNews("中国足球很牛逼", "反正我不相信", "2016-8-6"));
			newsList.add(this.createNews("中国贫富差距很明显", "我信", "2016-8-7"));

		} else if ("international".equals(ntype)) {
			newsList.add(this.createNews("美国暴乱", "我希望看见", "2016-7-4"));
			newsList.add(this.createNews("美国答应南海是中国的", "喜闻乐见", "2016-8-6"));
			newsList.add(this.createNews("日本海啸", "我期望世界和平", "2016-8-7"));

		}

		// 设置响应编码
		resp.setHeader("content-type", "text/html;charset=utf-8");

		// 以JSON格式返回
		resp.getWriter().print(new Gson().toJson(newsList));
	}

	/**
	 * 创建新闻的方法
	 * 
	 * @param title
	 * @param content
	 * @param date
	 * @return
	 */
	private Map<String, String> createNews(String title, String content,
			String date) {
		Map<String, String> m = new HashMap<String, String>();
		m.put("title", title);
		m.put("content", content);
		m.put("date", date);
		return m;
	}
}
