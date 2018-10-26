/**
 * 
 */
package service;

import entity.User;

/**
 * @author Allen
 * 
 *         Title: UserService
 * 
 *         Description: 用户服务层接口
 * 
 *         Company:
 * 
 * @date 2016年9月12日 下午4:10:33
 * 
 *       Email:1303542271 @qq.com
 */
public interface UserService {
	// 登录功能
	boolean login(User user);

	// 注册功能
	boolean addUser(User user);
}
