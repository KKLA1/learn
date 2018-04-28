package cn.org.kkl.service.impl;

import java.util.List;

import cn.org.kkl.dao.DepartmentDao;
import cn.org.kkl.domain.Department;
import cn.org.kkl.domain.PageBean;
import cn.org.kkl.service.DepartmentService;
import cn.org.kkl.util.Properties;

public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public PageBean<Department> findAllDept(int currPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		pageBean.setCurrPage(currPage);// 封装当前页数
		int pageSize = Properties.Page_SIZE;
		pageBean.setPageSize(pageSize);
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double tp = Math.ceil(tc / pageSize);
		pageBean.setTotalPages(tp.intValue());
		int begin = (currPage - 1) * pageSize;
		System.out.println("===22222=====currpage:" + pageSize + "====pageSize:" + pageSize + "======================2222222======");
		List<Department> list = departmentDao.findByPage(begin, pageSize);
		pageBean.setList(list);

		return pageBean;
	}

	/* 
	 * 添加新部门
	 */
	@Override
	public void save(Department department) {
		departmentDao.saveDepartment(department);
	}

	@Override
	public Department findByDid(Integer dId) {
		Department department = departmentDao.findDepartmentByDid(dId);
		return department;
	}

	@Override
	public void updateDempartment(Department department) {
		departmentDao.updateDept(department);
	}

	@Override
	public void deleteDept(Department department) {
		departmentDao.deleteDept(department);
	}

	@Override
	public List<Department> findAll() {
		List<Department> list = departmentDao.findAll();
		return list;
	}

}
