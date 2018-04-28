<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.div1{ margin-top:50px; margin-left:600px; font-size:14px; color:white}
</style>
</head>

<body bgcolor="#0099FF">
			<table width="95%"  style="">
				<tr>
					<td align="center">
						<div class="headerBar">
							<div class="logoBar login_logo">
								<div class="comWidth">
									<div class="logo fl" align="left">
										<a href="#"><img src="${pageContext.request.contextPath }/images/logo.jpg" alt="慕课网"></a>
									</div>
								</div>
							</div>
						</div>
					</td>
					<td align="center" width="50%"></td>
					<td align="right"><span style="">欢迎 : <s:property value="#session.existEmployee.geteName()"/></span></td>
				</tr>
			</table>

<div class="div1">
<table ></table>
</div>
</body>
</html>