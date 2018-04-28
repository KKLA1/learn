package cn.org.kkl.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.org.kkl.domain.Department;
import cn.org.kkl.domain.Employee;
import cn.org.kkl.domain.PageBean;
import cn.org.kkl.service.DepartmentService;
import cn.org.kkl.service.EmployeeService;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {
	private Employee employee = new Employee();// 方便与前端交互使用

	private EmployeeService employeeService;

	private DepartmentService departmentService;

	/**
	 * @param departmentService
	 *            the departmentService to set
	 */
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@Override
	public Employee getModel() {
		return employee;
	}

	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	/**
	 * 登录执行的方法
	 * 
	 * @return
	 */
	public String login() {
		System.out.println("我已经安全进入了,username:" + employee.getUserName() + "  ||password:" + employee.getPassword());
		// 调用EmployeeService方法
		Employee existEmployee = employeeService.login(employee);
		System.out.println("====================3333==============");
		if (null == existEmployee) {
			this.addActionError("用户名或密码错误!!!!");
			System.out.println("====================444==============");
			return INPUT;
		} else {
			System.out.println("====================555==============");
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			System.out.println("====================666==============");
			return SUCCESS;
		}
	}

	/**
	 * 查询所遇员工信息
	 * 
	 * @return
	 */
	public String findAll() {
		PageBean<Employee> pageBean = employeeService.findAllByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		System.out.println(pageBean.toString());
		return "findAll";
	}

	/**
	 * 增加员工跳转页面
	 */
	public String addUI() {
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "addUI";
	}

	public String save() {
		employeeService.saveEmp(employee);
		return "saveSuccess";
	}

	/**
	 * 编辑员工
	 */
	public String edit() {
		employee = employeeService.findEmpById(employee.geteId());
		System.out.println("*******" + employee.toString() + "******");
		List<Department> list = departmentService.findAll();
		System.out.println("*********" + list.size() + "****************");
		ActionContext.getContext().getValueStack().set("list", list);

		return "editSuccess";
	}

	/**
	 * 修改员工信息
	 */
	public String update() {
		System.out.println(employee.toString());
		employeeService.updateEmp(employee);

		return "updateSuccess";
	}

	/**
	 * 删除员工
	 */
	public String delete() {
		employee = employeeService.findEmpById(employee.geteId());
		employeeService.deleteEmp(employee);
		return "deleteSuccess";
	}

}
