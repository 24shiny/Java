<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "utils.JSFunction"
    %>
<%
if(session.getAttribute("UserId")==null){
	JSFunction.alertLocation("please log in","../Ch06/LoginForm.jsp",out);
	return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>