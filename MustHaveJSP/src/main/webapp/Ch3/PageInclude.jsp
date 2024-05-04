<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Common.Person"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>included page</h1>
	<%
	int pInteger2 = (Integer)(pageContext.getAttribute("pageInteger"));
	String pString2 = pageContext.getAttribute("pageString").toString();
	Person pPerson2 = (Person)(pageContext.getAttribute("pagePerson"));
	%>
	<ul>
		<li>Integer Object : <%= pInteger2 %></li>
		<li>String object : </li>
		<li>Person object : <%= pPerson2.getName() %>, <%=pPerson2.getAge() %></li>
	</ul>
</body>
</html>