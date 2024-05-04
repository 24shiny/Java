<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Common.Person" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>이동 후 페이지 영역의 속성값 읽기</h1>
	<%
	Object pInteger2 = pageContext.getAttribute("pageInteger");
	Object pString = pageContext.getAttribute("pageString");
	Object pPerson2 = pageContext.getAttribute("pagePerson");
	%>
	<ul>
		<li>Integer object : <%= (pInteger2==null)?"no value":pInteger2 %></li>
		<li>String object : <%= (pString==null)?"no value":pString %></li>
		<li>Person object : <%= (pPerson2==null)?"no value":((Person)pPerson2).getName() %></li>
	</ul>
</body>
</html>