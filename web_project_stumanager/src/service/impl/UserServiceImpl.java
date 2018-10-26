/**
 * 
 */
package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import service.UserService;

/**
 * @author Allen
 * 
 *         Title: UserServiceImpl
 * 
 *         Description:
 * 
 *         Company:
 * 
 * @date 2016年9月12日 下午4:11:02
 * 
 *       Email:1303542271 @qq.com
 */
public class UserServiceImpl implements UserService {

	// 实例化持久层
	UserDao dao = new UserDaoImpl();

	@Override
	public boolean login(User user) {

		return dao.login(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.UserService#addUser(entity.User)
	 */
	@Override
	public boolean addUser(User user) {

		return dao.addUser(user);

	}

}
