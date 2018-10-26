/**
 * 
 */
package allen.classms.server;

import java.util.List;

import allen.classms.dao.UserDAO;
import allen.classms.entity.User;

/**
 * @author Allen
 * 
 *         Title: UserService
 * 
 *         Description:
 * 
 *         服务层 Company:
 * 
 * @date 2016年9月21日 上午10:12:34
 * 
 *       Email:1303542271 @qq.com
 */
public class UserService {

	// 实例化
	UserDAO userDao = new UserDAO();

	/**
	 * 查询用户
	 * 
	 * @param uname
	 * @param pwd
	 * @return
	 */
	public User queryUser(String uname, String pwd) {

		return userDao.queryUser(uname, pwd);
	}

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public List<User> queryAll(int num, int size) {

		return userDao.queryAll(num, size);
	}

	/**
	 * 添加用户
	 * 
	 * @param user
	 * @return
	 */
	public int addUser(User user) {

		return userDao.addUser(user);
	}

	/**
	 * 根据id查询用户
	 * 
	 * @param id
	 * @return
	 */
	public User queryUserById(int id) {

		return userDao.queryUserById(id);
	}

	/**
	 * 删除用户
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(int id) {

		return userDao.delete(id);
	}

	/**
	 * 修改用户
	 * 
	 * @param user
	 * @return
	 */
	public int updateUser(User user) {

		return userDao.updateUser(user);
	}

	/**
	 * 根据姓名查询
	 * 
	 * @param name
	 * @return
	 */
	public List<User> queryUser(String name) {

		return userDao.queryUser(name);
	}

	/**
	 * 获取总数
	 * 
	 * @return
	 */
	public int getCount() {
		return userDao.getCount();
	}

	/**
	 * 方法重载
	 * 
	 * @param sql
	 * @param name
	 * @return
	 */
	public int getCount(String sql, String name) {

		return userDao.getCount(sql, name);
	}

	/**
	 * 分页查询
	 * 
	 * @param name
	 * @param num
	 * @param size
	 * @return
	 */
	public List<User> queryUser(String name, int num, int size) {
		
		return userDao.queryUser(name, num, size);
	}

	/**
	 * 查询用户
	 * @param name
	 * @return
	 */
	public int qeuryName(String name) {
		
		return userDao.queryName(name);
	}

}
