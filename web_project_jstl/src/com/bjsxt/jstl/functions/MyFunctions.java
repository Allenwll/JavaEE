/**
 * 
 */
package com.bjsxt.jstl.functions;

/**
 * @author Allen
 * 
 *         Title: MyFunctions
 * 
 *         Description:
 * 
 *         Company:
 * 
 * @date 2016年9月11日 下午4:14:42
 * 
 *       Email:1303542271 @qq.com
 */
public class MyFunctions {

	public static String ltrim(String str) {
		// 定义替换规则
		String regex = "^\\s+";
		// 开始替换
		String newStr = str.replaceAll(regex, "");

		// 返回被替换后的字符串

		return newStr;

	}
	

	public static String Rtrim(String str) {
		// 定义替换规则
		String regex = "\\s*$";
		;
		// 开始替换
		String newStr = str.replaceAll(regex, "");

		// 返回被替换后的字符串

		return newStr;
		
	
	}
}
