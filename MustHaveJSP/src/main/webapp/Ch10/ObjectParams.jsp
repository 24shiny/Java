<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Common.Person" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setAttribute("personObj", new Person("Hong",50));
request.setAttribute("stringObj","this is String");
request.setAttribute("integerObj",99);
%>
<jsp:forward page="ObjectResult.jsp">
	<jsp:param value="10" name="firstNum" />
	<jsp:param value="20" name="secondNum" />
</jsp:forward>
</body>
</html>