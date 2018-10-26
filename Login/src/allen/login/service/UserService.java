package allen.login.service;

import java.util.List;

import allen.login.dao.UserDao;
import allen.login.entity.User;

/**
 * @author acer
 * MVC 	服务层 业务层  
 */
public class UserService {
	//实例化
	private UserDao userDao=new UserDao();
	
	//ִ查询
	
	public boolean findInfo(User user){
		return userDao.findByInfo(user);
	}
	
	//查询所有
	public List<User> findAll(){
		return userDao.findAll();
	}
	
}
