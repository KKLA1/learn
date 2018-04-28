package cn.org.kkl.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.org.kkl.domain.Department;
import cn.org.kkl.domain.PageBean;
import cn.org.kkl.service.DepartmentService;

public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -538133564049209339L;

	private Department department = new Department();

	private DepartmentService departmentService;

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@Override
	public Department getModel() {
		return department;
	}

	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	public String findAll() {
		System.out.println("=======111======当前的页数是：" + currPage + "=====111========");
		PageBean<Department> pageBean = departmentService.findAllDept(currPage);
		System.out.println(pageBean.toString());
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}

	public String saveUi() {
		System.out.println("I am coming ");
		return "saveUI";
	}

	/**
	 * 添加新部门
	 */
	public String save() {
		departmentService.save(department);
		return "saveSuccess";
	}

	/**
	 * 编辑修改部门
	 */
	public String edit() {
		System.out.println("==========修改部门id：" + department.getdId() + "===========================");
		department = departmentService.findByDid(department.getdId());
		return "editSuccess";
	}

	/**
	 * 修改部门
	 */
	public String update() {
		departmentService.updateDempartment(department);
		return "updateSuccess";
	}

	/**
	 * 删除部门信息
	 */
	public String delete() {
		department = departmentService.findByDid(department.getdId());
		departmentService.deleteDept(department);
		System.out.println("=================删除成功================");
		return "deletSuccess";
	}

}
