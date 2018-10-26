package com.allen.emplyeemgs.service;

import java.util.List;

import com.allen.emplyeemgs.entity.Department;
import com.allen.emplyeemgs.entity.Employee;

/***
 * Title: EmplyeeService
 * 
 * Description:
 * 
 * MVC之服务层接口
 * 
 * Company: 个人
 * 
 * @author Allen Wang
 * 
 * @email:1303542271@qq.com
 * 
 * @date 2016年9月27日 下午2:12:29
 * 
 */
public interface EmployeeService {

	// 查询员工
	public List<Employee> queryEmp(String e_name);

	// 查询部门
	public List<Department> findDept();

	// 添加员工
	public boolean add(Employee emp);
}
