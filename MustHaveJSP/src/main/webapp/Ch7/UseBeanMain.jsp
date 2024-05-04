<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>useBean action tag</h2>
	<h3>create JavaBeans</h3>
	<jsp:useBean id="person" class="Common.Person" scope="request" />
	
	<h3>setProperty action tag</h3>
	<jsp:setProperty name="person" property = "name" value="Mr.Lim" />
	<jsp:setProperty name="person" property = "age" value="41" />
	
	<h3>getProperty action tag</h3>
	<ul>
		<li>name : <jsp:getProperty name="person" property = "name" /></li>
		<li>age : <jsp:getProperty name="person" property = "age" /></li>
	</ul>
	
</body>
</html>