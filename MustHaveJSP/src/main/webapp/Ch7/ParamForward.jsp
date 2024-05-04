<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="person" class="Common.Person" scope="request" />
	<h2>check variables on the forwarded page</h2>
	<ul>
		<li>nickname : <jsp:getProperty name="person" property="name" /></li>
		<li>age : <jsp:getProperty name="person" property="age" /></li>
		<li>name : <%=request.getParameter("param1") %></li>
		<li>age : <%=request.getParameter("param2") %></li>
		<li>age : <%=request.getParameter("param3") %></li>
	</ul>
	<jsp:include page="ParamInclude.jsp">
		<jsp:param name="loc1" value="Bermingham" />
		<jsp:param name="loc2" value="NewJersey" />
	</jsp:include>
</body>
</html>