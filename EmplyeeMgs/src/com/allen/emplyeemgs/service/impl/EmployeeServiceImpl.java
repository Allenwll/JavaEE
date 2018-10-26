package com.allen.emplyeemgs.service.impl;

import java.util.List;

import com.allen.emplyeemgs.dao.EmployeeDAO;
import com.allen.emplyeemgs.dao.impl.EmployeeDAOImpl;
import com.allen.emplyeemgs.entity.Department;
import com.allen.emplyeemgs.entity.Employee;
import com.allen.emplyeemgs.service.EmployeeService;

/***
 * Title: EmplyeeServiceImpl
 * 
 * Description:
 * 
 * MVC之服务层实现类
 * 
 * Company: 个人
 * 
 * @author Allen Wang
 * 
 * @email:1303542271@qq.com
 * 
 * @date 2016年9月27日 下午2:12:53
 * 
 */
public class EmployeeServiceImpl implements EmployeeService {

	// 面向接口编程
	EmployeeDAO empDao = new EmployeeDAOImpl();

	@Override
	public List<Employee> queryEmp(String e_name) {

		return empDao.queryEmp(e_name);
	}

	@Override
	public List<Department> findDept() {

		return empDao.findDept();
	}

	public boolean add(Employee emp) {
	
		return empDao.add(emp);
	}

}
