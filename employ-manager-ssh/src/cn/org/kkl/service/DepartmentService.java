package cn.org.kkl.service;

import java.util.List;

import cn.org.kkl.domain.Department;
import cn.org.kkl.domain.PageBean;

public interface DepartmentService {

	public PageBean<Department> findAllDept(int currPage);

	public void save(Department department);

	public Department findByDid(Integer dId);

	public void updateDempartment(Department department);

	public void deleteDept(Department department);

	public List<Department> findAll();
}
