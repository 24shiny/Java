<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="num" value="100" />
	<c:set var="str" value="JSP" />
	
	<h3>even or odd</h3>
	<c:if test="${num mod 2 eq 0 }" var="result">is ${num} even?<br/></c:if>
	result : ${result }
	
	<h3>is ${str} java?</h3>
	<c:if test="${str eq 'java' }" var="result2">is java<br/></c:if>
	<c:if test="${not result2 }">not a java</c:if>
	
	
</body>
</html>