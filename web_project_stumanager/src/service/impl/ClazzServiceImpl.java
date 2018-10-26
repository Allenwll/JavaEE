/**
 * 
 */
package service.impl;

import service.ClazzService;
import dao.ClazzDao;
import dao.impl.ClazzDaoImpl;

/**
 * @author Allen
 * 
 *         Title: ClazzServiceImpl
 * 
 *         Description:
 * 
 *         Company:
 * 
 * @date 2016年9月18日 下午7:26:17
 * 
 *       Email:1303542271 @qq.com
 */
public class ClazzServiceImpl implements ClazzService {

	ClazzDao clazz = new ClazzDaoImpl();
	@Override
	public String queryClassName(int classId) {
		return clazz.queryClassName(classId);
	}
}
