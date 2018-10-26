/**
 * 
 */
package dao;

import entity.User;

/**
 * @author Allen
 * 
 *         Title: UserDao
 * 
 *         Description: 用户数据持久层接口
 * 
 *         Company:
 * 
 * @date 2016年9月12日 下午4:05:24
 * 
 *       Email:1303542271 @qq.com
 */
public interface UserDao {

	// 登录功能
	boolean login(User user);


	// 注册功能
	boolean addUser(User user);

}
