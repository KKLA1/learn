<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head></head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 添加员工</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('updateForm').submit()">保存</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">退回</a>
</td>
</tr>
</table>
<br/>
<s:form action="employee_update" id="updateForm" method="post" namespace="/" theme="simple">
	<s:hidden name="eId" value="%{model.eId}"/>
	<%-- <s:hidden name="%{model.department.dName}"/>
	<s:hidden name="%{model.department.ddesc}"/> --%>
	<table border='0' cellpadding="0" cellspacing="10">
		<tr>
			<td>姓名</td>
			<td><s:textfield name="eName" value="%{model.eName}"></s:textfield></td>
			<td>性别</td>
			<td><s:radio name="sex" list="{'男','女'}" value="%{model.sex}"></s:radio></td>
		</tr>
		<tr>
			<td>用户名：</td>
			<td><s:textfield name="userName" value="%{model.userName}"></s:textfield></td>
			<td>密码：</td>
			<td><s:password name="password" value="%{model.password}" showPassword="true"></s:password></td>
		</tr>
		<tr> 
			<td>出生日期：</td>
			<td><input type="text" name="birthday" value='<s:date name="model.birthday" format="yyyy-MM-dd hh:mm:ss"/>'/></td>
			<td>入职时间：</td>
			<td><input type="text" name="joinDate" value='<s:date name="model.joinDate" format="yyyy-MM-dd hh:mm:ss"/>'/></td>
		</tr>

		<tr>
			<td>所属部门:</td>
			<td><s:select name="department.dId" value="%{model.department.dId}" list="list" listKey="dId" listValue="dName" headerKey="" headerValue="---请 选 择---"></s:select></td>
			<td>编号:</td>
			<td><s:textfield name="eno" value="%{model.eno}"></s:textfield></td>
		</tr>
	</table>
</s:form>
</body>
</html>