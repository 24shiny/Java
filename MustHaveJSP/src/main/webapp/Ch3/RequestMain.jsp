<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Common.Person" %>
<%
request.setAttribute("requestString", "request area String");
request.setAttribute("requestPerson", new Person("Ahn", 31));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>delete attributes</h1>
	<%
	request.removeAttribute("requestString");
	request.removeAttribute("requestInteger");
	%>
	<h1>read attributes</h1>
	<%
	Person rPerson = (Person)(request.getAttribute("requestPerson"));
	%>
	<ul>
		<li>String object : <%= request.getAttribute("requestString") %></li>
		<li>Person object : <%= rPerson.getName() %>,<%= rPerson.getAge() %></li>
	</ul>
	<h1>read attributes on the forwarded page</h1>
	<% 
	request.getRequestDispatcher("RequestForward.jsp?paramHan=hangeul&paramEng=English")
	.forward(request,response);
	%>
</body>
</html>