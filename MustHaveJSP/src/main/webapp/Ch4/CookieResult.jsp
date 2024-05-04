<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>check cookie's value</h2>
	<%
	Cookie[] cookies = request.getCookies();
	for(int i=0; i<cookies.length; i++){
		String cookieName = cookies[i].getName();
		String cookieValue = cookies[i].getValue();
		out.println(String.format("cookie name : %s ", cookieName));
		out.println("<br/>");
		out.println(String.format("cookie value : %s", cookieValue));
	}
	%>
</body>
</html>