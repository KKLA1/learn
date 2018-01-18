<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>hello words</h1>
当前在线人数为：${ usernumber}<br/>
<% ArrayList<com.cn.entity.User> userlist= (ArrayList<com.cn.entity.User>)request.getServletContext().getAttribute("userlist"); 
if(userlist!=null){
	for(int i=0;i<userlist.size();i++){
		com.cn.entity.User user=userlist.get(i);
%>		
IP:<%=user.getIpstring() %>,FirstTime:<%=user.getFirstTime() %>,SessionId:<%=user.getSessionidstring() %><br>

<% 	}
}
%>
当前用户：<%=request.getSession().getAttribute("current") %>
<button onclick="location.href='<%=request.getContextPath()%>/init.jsp';" > init </button>
<button onclick="location.href='<%=request.getContextPath()%>/destory.jsp';" >destory</button>
</body>
</html>