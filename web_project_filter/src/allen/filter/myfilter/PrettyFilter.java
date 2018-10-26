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
 * @author  Allen
 *
 * Title: PrettyFilter
 *
 * Description: 
 * 
 *	Company: 
 *  
 *  @date 2016年9月13日 下午3:32:18    
 *  
 *  Email:1303542271 @qq.com
 */
public class PrettyFilter implements Filter {

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterconfig) throws ServletException {
		System.out.println("PrettyFilter.init(上班:开始选妃)");
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest servletrequest,
			ServletResponse servletresponse, FilterChain filterchain)
			throws IOException, ServletException {
		System.out.println("PrettyFilter.doFilter(检查颜值)");
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		System.out.println("PrettyFilter.destroy(下班,丑的回去,美的入宫)");
		
	}

}
