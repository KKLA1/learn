<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head></head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 部门编辑</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('updateForm').submit()">保存</a> &nbsp;&nbsp;
<a href="${pageContext.request.contextPath}/department_findAll.action">退回</a>
</td>
</tr>
</table>
<br/>
 <br>
<s:form id="updateForm" method="post" action="department_update" namespace="/" theme="simple">
	<s:hidden name="dId" value="%{model.dId}"/>
	<table style="font-size::16px">
		<tr>
		  <td>部门名称</td>
		  <td><s:textfield name="dName" value="%{model.dName}"></s:textfield></td><!-- readonly="true" -->
		</tr>
		<%-- <tr>
		  <td>部门编号</td>
		  <td><s:textfield name="dId" value="%{model.dId}"></s:textfield></td>
		</tr> --%>
		<tr>
		  <td>部门介绍：</td>
		  <td></td>
		</tr>
		<tr>
		  <td width="10%"></td>
		  <td>
		  	 <s:textarea cols="50" rows="5" name="ddesc" value="%{model.ddesc}"></s:textarea>
		  </td>
		</tr>
	</table>
</s:form>
</body>
</html> 