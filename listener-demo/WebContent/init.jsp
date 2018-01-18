<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%
String path = request.getContextPath();


request.setAttribute("requestName", "requestNamevalue");
request.getSession().setAttribute("sessionName", "sessionNamevalue");
request.getSession().getServletContext().setAttribute("rssservletContext", "servletContextvalue");
request.getServletContext().setAttribute("rsContext", "rsContextvalue");

request.getSession().setAttribute("current", new com.cn.entity.Student());
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
这是初始化值的页面：
<button onclick="location.href='<%=request.getContextPath()%>/init.jsp';" > init </button>
<button onclick="location.href='<%=request.getContextPath()%>/destory.jsp';" >destory</button>
</body>
</html>