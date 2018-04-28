package cn.org.kkl.domain;

import java.util.Date;

/**
 * 员工实体类
 * 
 * @author Admin
 *
 */
public class Employee {

	public Integer geteId() {
		return eId;
	}

	public void seteId(Integer eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getEno() {
		return eno;
	}

	public void setEno(String eno) {
		this.eno = eno;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	private Integer eId;
	private String eName;
	private String sex;
	private Date birthday;
	private Date joinDate;
	private String eno;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", sex=" + sex + ", birthday=" + birthday + ", joinDate=" + joinDate + ", eno=" + eno + ", userName=" + userName
				+ ", password=" + password + ", department=" + department + "]";
	}

	private String userName;
	private String password;

	private Department department;

}
