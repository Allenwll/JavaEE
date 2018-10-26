/**
 * 
 */
package allen.filter.myfilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Allen
 * 
 *         Title: WeaponFilter
 * 
 *         Description:
 * 
 *         Company:
 * 
 * @date 2016年9月13日 下午2:31:31
 * 
 *       Email:1303542271 @qq.com
 */
public class WeaponFilter implements Filter {

	@Override
	public void init(FilterConfig filterconfig) throws ServletException {
		System.out.println("WeaponFilter.init(上班:开始检查武器了!)");
	}

	@Override
	public void doFilter(ServletRequest servletrequest,
			ServletResponse servletresponse, FilterChain filterchain)
			throws IOException, ServletException {

		// 实例化对象
		HttpServletRequest req = (HttpServletRequest) servletrequest;
		HttpServletResponse resp = (HttpServletResponse) servletresponse;

		System.out.println(req.getRequestURL()
				+ "WeaponFilter.doFilter(站住,我要检查武器1!)");

		// 执行过滤

		/*
		 * String name = req.getParameter("uname"); String pwd =
		 * req.getParameter("pwd"); if ("sxt".equals(name) && "666".equals(pwd))
		 * { // 放行 filterchain.doFilter(req, resp); } else {
		 * System.out.println("请重新输入!"); return; }
		 */
		filterchain.doFilter(req, resp);

		System.out.println(req.getRequestURL()
				+ "WeaponFilter.doFilter(站住,我要检查武器2)");
	}

	@Override
	public void destroy() {
		System.out.println("WeaponFilter.destroy(下班:我们武器检查完事了!)");
	}

}
