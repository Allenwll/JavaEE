/**
 * 
 */
package allen.login.service;

/**
 * @author Allen
 * 
 *         Title: LoginService
 * 
 *         Description:
 * 
 *         Company:
 * 
 * @date 2016年9月11日 上午10:15:59
 * 
 *       Email:1303542271 @qq.com
 */
public class LoginService {

	public static boolean login(String username, String password) {

		// 判断
		if ("admin".equals(username) && "123456".equals(password)) {
			return true;
		} else {
			return false;
		}
	}
}
