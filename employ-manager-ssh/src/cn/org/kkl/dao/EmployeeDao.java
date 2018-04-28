package cn.org.kkl.dao;

import java.util.List;

import cn.org.kkl.domain.Employee;

public interface EmployeeDao {

	Employee findByUsernameAndPassword(Employee employee);

	int findTotalCount();

	List<Employee> findEmployeeByPage(int begin, int pageSize);

	void saveEmp(Employee employee);

	Employee findEmpById(Integer geteId);

	void updateEmp(Employee employee);

	void deleteEmp(Employee employee);

}
