<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date" import="Common.Person" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="a" value="100" />
	<c:set var="today" value="<%=new Date() %>"/>
	<c:set var="b">200</c:set>
	<ul>
		<li>${ a}</li>
		<li>${today }</li>
		<li>${b }</li>
	</ul>
	<h2>javaBeans - comparator</h2>
	<c:set var="per1" value='<%=new Person("Hong",50) %>' scope="request"/>
	<ul>
		<li>name: ${requestScope.per1.name}</li>
		<li>age : ${requestScope.per1.age}</li>
	</ul>

	<h2>javaBeans - target and property</h2>
	<c:set var="per2" value="<%=new Person() %>" scope="request"/>
	<c:set target="${per2}" property="name" value="Blue House" />
	<c:set target="${per2}" property="age" value="500"/>
	<ul>
		<li>name: ${per2.name }</li>
		<li>age : ${per2.age }</li>
	</ul>
</body>
</html>