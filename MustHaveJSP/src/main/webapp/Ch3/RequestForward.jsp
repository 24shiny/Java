<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Common.Person" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>forwarded page</h1>
	<h2>read attributes of Request Main</h2>
	<% Person rPerson = (Person)(request.getAttribute("requestPerson")); %>
	<ul>
		<li>String object : <%= request.getAttribute("requestString") %></li>
		<li>Person object : <%= rPerson.getName() %>,<%= rPerson.getAge() %></li>
	</ul>
	<h1>print attributes of parameters</h1>
	<%
	request.setCharacterEncoding("UTF-8");
	out.println(request.getParameter("paramHan"));
	out.println(request.getParameter("paramEng"));
	%>
</body>
</html>