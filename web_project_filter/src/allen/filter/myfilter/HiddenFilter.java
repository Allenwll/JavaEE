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
 *         Title: HiddenFilter
 * 
 *         Description:
 * 
 *         Company:
 * 
 * @date 2016年9月13日 下午3:17:07
 * 
 *       Email:1303542271 @qq.com
 */
public class HiddenFilter implements Filter {

	@Override
	public void init(FilterConfig filterconfig) throws ServletException {
		System.out.println("HiddenFilter.init(上班:开始检查暗器!)");
	}

	@Override
	public void doFilter(ServletRequest servletrequest,
			ServletResponse servletresponse, FilterChain filterchain)
			throws IOException, ServletException {
		System.out.println("HiddenFilter.doFilter(站住!检查暗器1)");
		filterchain.doFilter(servletrequest, servletresponse);
		System.out.println("PoisonFilter.doFilter(站住，检查食物)");
	}

	@Override
	public void destroy() {
		System.out.println("HiddenFilter.destroy(下班,停止检查)");
	}

}
