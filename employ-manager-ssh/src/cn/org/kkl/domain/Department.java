package cn.org.kkl.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 部门实体类
 * 
 * @author Admin
 *
 */
public class Department {

	@Override
	public String toString() {
		return "Department [dId=" + dId + ", dName=" + dName + ", ddesc=" + ddesc + "]";
	}

	private Integer dId;
	private String dName;
	private String ddesc;

	private Set<Employee> employees = new HashSet<Employee>();

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Integer getdId() {
		return dId;
	}

	public void setdId(Integer dId) {
		this.dId = dId;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getDdesc() {
		return ddesc;
	}

	public void setDdesc(String ddesc) {
		this.ddesc = ddesc;
	}

}
