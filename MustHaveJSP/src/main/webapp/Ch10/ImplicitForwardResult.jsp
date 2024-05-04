<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Implicit Forwarded Page</h2>
	<h3>read attributes on each page</h3>
	<ul>
		<li>page area : ${pageScope.scopeValue} </li>
		<li>request area : ${requestScope.scopeValue}</li>
		<li>session area : ${sessionScope.scopeValue}</li>
		<li>application area : ${applicationScope.scopeValue}</li>
	</ul>
	<ul>
		<li>${scopeValue}</li>
	</ul>
</body>
</html>