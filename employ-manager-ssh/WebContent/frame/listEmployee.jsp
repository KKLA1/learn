<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
        .table1{
            border:1px solid #ddd;
            width:900px;
            
        }
        thead{
            background-color:lightblue;
        }

    </style>
</head>
<body>
<table border="0" width="900px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 员工管理</td>
</tr>
<tr>
<td align="right" > <a href="${pageContext.request.contextPath }/employee_addUI.action">添加</a></td>
</tr>
</table>
<br/>


<table cellspacing="0" border="1" class="table1">
<thead>
  <tr>
<td align="center">编号</td>
<td align="center">员工姓名</td>
<td align="center">性别</td>
<td align="center">出生日期</td>
<td align="center">入职时间</td>
<td align="center">所属部门</td>
<td align="center">编辑</td>
<td align="center">删除</td>
</tr>
</thead>
<tbody>
	<s:iterator value="list" var="employee">
		<tr>
			<td align="center"><s:property value="#employee.eno"/></td>
			<td align="center"><s:property value="#employee.eName"/></td>
			<td align="center"><s:property value="#employee.sex"/></td>
			<td align="center"><s:date name="#employee.birthday" format="yyyy-MM-dd hh:mm:ss"/></td>
			<td align="center"><s:date name="#employee.joinDate" format="yyyy-MM-dd hh:mm:ss"/></td>
			<td align="center"><s:property value="#employee.department.dName"/></td>
			<td align="center"><a href="${pageContext.request.contextPath }/employee_edit.action?eId=<s:property value="#employee.eId"/>"><img src="${pageContext.request.contextPath }/images/edit.png"></a></a></td>
			<td align="center"><a href="${pageContext.request.contextPath }/employee_delete.action?eId=<s:property value="#employee.eId"/>"><img src="${pageContext.request.contextPath }/images/trash.gif"></a></a></td>
		</tr>
	</s:iterator>
</tbody>
</table>
<br/>

<table table border="0" cellspacing="0" cellpadding="0"  width="900px">
<tr>
<td align="right">
   <span>第<s:property value="currPage"/>/<s:property value="totalPages"/>页,每页显示<s:property value="pageSize"/>条，共<s:property value="totalCount"/>条记录。</span>
   <apan>
       <s:if test="currPage != 1">
       	<a href="${pageContext.request.contextPath }/employee_findAll.action?currPage=1">[首页]</a>&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath }/employee_findAll.action?currPage=<s:property value="currPage-1"/>">[上一页]</a>&nbsp;&nbsp;
       </s:if>
       <s:if test="currPage < totalPages">
       	<a href="${pageContext.request.contextPath }/employee_findAll.action?currPage=<s:property value="currPage+1"/>">[下一页]</a>&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath }/employee_findAll.action?currPage=<s:property value="totalPages"/>">[尾页]</a>&nbsp;&nbsp;
       </s:if>
   </span>
</td>
</tr>
</table>
</body>
</html>