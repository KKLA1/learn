package cn.org.kkl.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.org.kkl.dao.DepartmentDao;
import cn.org.kkl.domain.Department;
import cn.org.kkl.util.Properties;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	/* 
	 * 根据部门编号查出部门信息
	 */
	@Override
	public Department findDepartmentByDid(Integer dId) {
		/*String hql = "from Department where dId = ? ";
		List<?> list = this.getHibernateTemplate().find(hql, dId);
		if (list.size() > 0) {
			return (Department) list.get(0);
		}*/

		return this.getHibernateTemplate().get(Department.class, dId);
	}

	@Override
	public int findCount() {
		String hql = "select count(*) from Department ";
		List<?> list = this.getHibernateTemplate().find(hql);
		if (list.size() > 0) {
			System.out.println(list.get(0).getClass());
			Long count = (Long) list.get(0);
			return count.intValue();
		}
		return 0;
	}

	Long a;

	/* 
	 * 分页查询部门
	 */
	@Override
	public List<Department> findByPage(int begin, int pageSize) {
		System.out.println("====3333======begin:" + begin + "=====pageSize:" + pageSize + "===========================33333333====");
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		List<Department> list = (List<Department>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@Override
	public void saveDepartment(Department department) {
		System.out.println(Properties.getId());
		department.setdId(Properties.getId());
		/*if (null == department.getdId()) {
			department.setdId(Properties.getId());
		}*/
		System.out.println("***********" + department.toString() + "***********");
		/*this.getHibernateTemplate().saveOrUpdate(department);*/
		this.getHibernateTemplate().save(department);

	}

	@Override
	public void updateDept(Department department) {
		this.getHibernateTemplate().update(department);
	}

	@Override
	public void deleteDept(Department department) {
		this.getHibernateTemplate().delete(department);

	}

	@Override
	public List<Department> findAll() {
		List<Department> list = (List<Department>) this.getHibernateTemplate().find(" from Department ");
		return list;
	}

}
