<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>read the form with action tag</h3>
	<jsp:useBean id="person" class="Common.Person" />
	<jsp:setProperty property="*" name="person" />
	<ul>
		<li>name : <jsp:getProperty name="person" property="name" /></li>
		<li>age : <jsp:getProperty name="person" property="age" /></li>
	</ul>
</body>
</html>