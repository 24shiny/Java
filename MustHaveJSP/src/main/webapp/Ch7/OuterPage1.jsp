<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>external file1</h2>
	<%
	String newVar1 = "King1";
	%>
	<ul>
		<li>attribute in the page area : <%=pageContext.getAttribute("pAttr") %></li>
		<li>attribute in the request area : <%=request.getAttribute("rAttr") %></li>
	</ul>
</body>
</html>