<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>${message }</p>
	<p><%=request.getContextPath() %></p>
	<a href="<%=request.getContextPath() %>/Ch12/AnnoMapping.do">check the result</a>
</body>
</html>