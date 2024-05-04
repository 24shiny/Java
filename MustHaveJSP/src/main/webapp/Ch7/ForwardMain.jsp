<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    pageContext.setAttribute("pAttr","Kim");
    request.setAttribute("rAttr","Beak");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Forwarding via action tag</h2>
	<jsp:forward page="./ForwardSub.jsp" />
</body>
</html>