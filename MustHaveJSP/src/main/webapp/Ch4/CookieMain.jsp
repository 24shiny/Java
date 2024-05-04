<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>1. Set Cookie</h1>
	<%
	Cookie cookie = new Cookie("myCookie","how palatable!");
	cookie.setPath(request.getContextPath());
	cookie.setMaxAge(3600);
	response.addCookie(cookie);
	%>
	<h2>2. check its value after setting the cookie</h2>
	<%
	Cookie[] cookies = request.getCookies();
	if(cookies!=null){
		for(Cookie c : cookies){
			String cookieName = c.getName();
			String cookieValue = c.getValue();
			out.println(String.format("%s : %s<br />", cookieName, cookieValue));
		}
	}
	%>
	<h2>3. check its value after transition to the next page</h2>
	<a href="CookieResult.jsp">check it on the next page</a>
</body>
</html>