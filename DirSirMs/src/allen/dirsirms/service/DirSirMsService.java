package allen.dirsirms.service;

import java.sql.SQLException;
import java.util.List;

import allen.dirsirms.dao.DirSirDAO;
import allen.dirsirms.entity.Goods;
import allen.dirsirms.entity.Manager;

/***
 * Title: DirSirMsService
 * 
 * Description:
 * 
 * 服务层
 * 
 * Company: 个人
 * 
 * @author Allen Wang
 * 
 * @email:1303542271@qq.com
 * 
 * @date 2016年10月8日 下午6:02:10
 * 
 */
public class DirSirMsService {

	// 实例化DirSirDAO类
	DirSirDAO dao = new DirSirDAO();

	/**
	 * 登录
	 * 
	 * @param manager
	 * @return
	 * @throws SQLException
	 */
	public boolean login(Manager manager) throws SQLException {

		return dao.login(manager);
	}

	/**
	 * 得到总记录数
	 * 
	 * @return
	 * @throws SQLException
	 */
	public int getCount() throws SQLException {
		return dao.getCount();
	}

	public List<Goods> queryGoods(int num, int size) throws SQLException {
		return dao.queryGoods(num, size);
	}

}
