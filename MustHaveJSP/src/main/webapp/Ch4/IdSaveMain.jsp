<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="utils.CookieManager" %>
<%
	String loginId = CookieManager.readCookie(request, "loginId");
	String cookieCheck = "";
	if(!loginId.equals("")){
		cookieCheck = "checked";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>login page</h1>
	<form action="IdSaveProcess.jsp" method="post">
	id : <input type="text" name="user_id" value="<%=loginId %>" />
	<input type = "checkbox" name="save_check" value="Y" <%= cookieCheck %> />
	rememer id
	<br />
	pw : <input type="text" name="user_pw" />
	<br />
	<input type="submit" value="login" />
	</form>
</body>
</html>