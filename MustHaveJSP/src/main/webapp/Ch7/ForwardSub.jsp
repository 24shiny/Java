<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>being forwarded</h2>
	<ul>
		<li>page area : <%=pageContext.getAttribute("pAttr") %></li>
		<li>request area : <%=request.getAttribute("rAttr") %></li>
	</ul>
</body>
</html>