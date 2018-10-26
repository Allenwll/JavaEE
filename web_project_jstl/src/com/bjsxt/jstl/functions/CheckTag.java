/**
 * 
 */
package com.bjsxt.jstl.functions;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author Allen
 * 
 *         Title: CheckTag
 * 
 *         Description: 自定义标签库的类
 * 
 *         Company:
 * 
 * @date 2016年9月13日 上午9:39:32
 * 
 *       Email:1303542271 @qq.com
 */
public class CheckTag extends TagSupport {

	private int lowPower;

	/**
	 * @return the lowPower
	 */
	public int getLowPower() {
		return lowPower;
	}

	/**
	 * @param lowPower
	 *            the lowPower to set
	 */
	public void setLowPower(int lowPower) {
		this.lowPower = lowPower;
	}

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {

		System.out.println("CheckTag.doStartTag(我是开始标签)" + lowPower);

		// 获取当前用户的使用权限
		int upower = (int) (this.pageContext.getSession()
				.getAttribute("upower"));
		System.out.println("当前用户使用权限为:" + upower);

		// 判断是否拥有相对应的操作权限

		if (upower >= lowPower) {
			return Tag.EVAL_BODY_INCLUDE;
		} else {
			return Tag.SKIP_BODY;
		}
	}

	@Override
	public int doEndTag() throws JspException {

		System.out.println("CheckTag.doEndTag()");
		
		return Tag.EVAL_PAGE;
	}

}
