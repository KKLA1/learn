package cn.org.kkl.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.org.kkl.dao.EmployeeDao;
import cn.org.kkl.domain.Employee;
import cn.org.kkl.util.Properties;

public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

	/*
	 * 根据用户名和密码查询数据库中该用户
	 */
	@Override
	public Employee findByUsernameAndPassword(Employee employee) {
		String hql = " from Employee where userName= ? and password = ?  ";
		System.out.println("==========11111111111==============");
		@SuppressWarnings("unchecked")
		List<Employee> list = (List<Employee>) this.getHibernateTemplate().find(hql, employee.getUserName(), employee.getPassword());
		if (list.size() > 0) {
			System.out.println("==========" + list.get(0).geteName() + list.get(0).getPassword() + "==============");
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public int findTotalCount() {
		String hql = "select count(*) from Employee";
		List<?> list = this.getHibernateTemplate().find(hql);
		if (list.size() > 0) {
			Long tc = (Long) list.get(0);
			return tc.intValue();
		}
		return 0;
	}

	@Override
	public List<Employee> findEmployeeByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		@SuppressWarnings("unchecked")
		List<Employee> list = (List<Employee>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@Override
	public void saveEmp(Employee employee) {
		employee.seteId(Properties.getEid());
		System.out.println(employee.toString());
		this.getHibernateTemplate().save(employee);
	}

	@Override
	public Employee findEmpById(Integer eId) {
		Employee employee = this.getHibernateTemplate().get(Employee.class, eId);
		return employee;
	}

	@Override
	public void updateEmp(Employee employee) {
		System.out.println(employee.toString());
		this.getHibernateTemplate().update(employee);
	}

	@Override
	public void deleteEmp(Employee employee) {
		this.getHibernateTemplate().delete(employee);

	}

}
