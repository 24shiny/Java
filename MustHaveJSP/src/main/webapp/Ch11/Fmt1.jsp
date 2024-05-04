<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="num1" value="12345" />
	<fmt:formatNumber value="${num1 }"/><br/>
	<fmt:formatNumber value="${num1 }" groupingUsed="false"/><br/>
	<fmt:formatNumber value="${num1 }" type="currency" var="printNum1"/><br/>
	${printNum1 }<br/>
	<fmt:formatNumber value="0.03" type="percent" var="printNum2"/><br/>
	${printNum2 }<br/>
	
	<c:set var="num2" value="6,789.01" />
	<fmt:parseNumber value="${num2 }" pattern="00,000.00" var="printNum3"/>
	${printNum3 }<br/>
	<fmt:parseNumber value="${num2 }" integerOnly="true" var="printNum4"/>
	${printNum4 }<br/>
</body>
</html>