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
	<c:forEach begin="1" end="3" var="i">
		<p>${i }</p>
	</c:forEach>
	<c:forEach begin="1" end="100" var="i">
		<c:if test="${j mod 2 ne 0 }">
			<c:set var="sum" value="${sum+j }"/>
		</c:if>
	</c:forEach>
	summation of odd numbers till 100 : ${sum}
	
	<table border="1">
		<c:forEach begin="3" end="5" varStatus="loop">
		<tr>
			<td>count : ${loop.count }</td>
			<td>index : ${loop.index }</td>
			<td>current : ${loop.current }</td>
			<td>first : ${loop.first }</td>
			<td>last : ${loop.last }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>