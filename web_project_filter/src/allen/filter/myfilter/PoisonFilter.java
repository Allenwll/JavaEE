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

/**
 * @author Allen
 * 
 *         Title: PoisonFilter
 * 
 *         Description:
 * 
 *         Company:
 * 
 * @date 2016年9月13日 下午3:22:51
 * 
 *       Email:1303542271 @qq.com
 */
public class PoisonFilter implements Filter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterconfig) throws ServletException {
		System.out.println("PoisonFilter.init(上班:开始检查毒药)");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest servletrequest,
			ServletResponse servletresponse, FilterChain filterchain)
			throws IOException, ServletException {
		System.out.println("PoisonFilter.doFilter(站住，检查食物1)");

		filterchain.doFilter(servletrequest, servletresponse);
		
		System.out.println("PoisonFilter.doFilter(站住，检查食物2)");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {

		System.out.println("PoisonFilter.destroy(下班,检查毒药完毕)");
	}

}
