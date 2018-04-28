package cn.org.kkl.service;

import cn.org.kkl.domain.Employee;
import cn.org.kkl.domain.PageBean;

/**
 * 员工管理业务层接口
 * 
 * @author Admin
 *
 */
public interface EmployeeService {

	Employee login(Employee employee);

	PageBean<Employee> findAllByPage(Integer currPage);

	void saveEmp(Employee employee);

	Employee findEmpById(Integer geteId);

	void updateEmp(Employee employee);

	void deleteEmp(Employee employee);

}
