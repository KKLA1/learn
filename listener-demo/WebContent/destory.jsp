<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%
request.removeAttribute("requestName");
request.getSession().setAttribute("sessionName", "sessionNamevalue2");
request.getSession().getServletContext().setAttribute("rssservletContext", "rssservletContextvalue2");
request.getServletContext().setAttribute("rsContext", "rsContext2");

request.getSession().removeAttribute("current");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<button onclick="location.href='<%=request.getContextPath()%>/init.jsp';" > init </button>
<button onclick="location.href='<%=request.getContextPath()%>/destory.jsp';" >destory</button>
</head>
<body>
这是销毁页面：
</body>
</html>