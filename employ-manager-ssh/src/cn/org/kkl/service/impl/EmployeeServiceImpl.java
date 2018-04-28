package cn.org.kkl.service.impl;

import java.util.List;

import cn.org.kkl.dao.EmployeeDao;
import cn.org.kkl.domain.Employee;
import cn.org.kkl.domain.PageBean;
import cn.org.kkl.service.EmployeeService;
import cn.org.kkl.util.Properties;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	/* 
	 * 登录具体实现
	 */
	@Override
	public Employee login(Employee employee) {
		Employee existEmployee = employeeDao.findByUsernameAndPassword(employee);
		return existEmployee;
	}

	@Override
	public PageBean<Employee> findAllByPage(Integer currPage) {
		PageBean<Employee> pageBean = new PageBean<Employee>();
		int pageSize = Properties.Page_SIZE;
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);
		int totalCount = employeeDao.findTotalCount();
		pageBean.setTotalCount(totalCount);
		double tc = totalCount / (double) pageSize;
		System.out.println("=================tc=" + tc + "==============================");
		Double tp = Math.ceil(tc);
		System.out.println("===============tp=" + tp + " ===================");
		pageBean.setTotalPages(tp.intValue());
		int begin = (currPage - 1) * pageSize;
		List<Employee> list = employeeDao.findEmployeeByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void saveEmp(Employee employee) {
		employeeDao.saveEmp(employee);
	}

	@Override
	public Employee findEmpById(Integer geteId) {
		Employee employee = employeeDao.findEmpById(geteId);
		return employee;
	}

	@Override
	public void updateEmp(Employee employee) {
		employeeDao.updateEmp(employee);
	}

	@Override
	public void deleteEmp(Employee employee) {
		employeeDao.deleteEmp(employee);

	}

}
