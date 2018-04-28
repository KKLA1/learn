package cn.org.kkl.dao;

import java.util.List;

import cn.org.kkl.domain.Department;

public interface DepartmentDao {

	public int findCount();

	public List<Department> findByPage(int begin, int pageSize);

	public void saveDepartment(Department department);

	public Department findDepartmentByDid(Integer dId);

	public void updateDept(Department department);

	public void deleteDept(Department department);

	public List<Department> findAll();

}
