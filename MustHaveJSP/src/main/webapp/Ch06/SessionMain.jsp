<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date" import="java.text.SimpleDateFormat" %>
<%
SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
long creationTime = session.getCreationTime();
String creationTimeStr = dateFormat.format(new Date(creationTime));
long lastTime = session.getLastAccessedTime();
String lastTimeStr = dateFormat.format(new Date(lastTime));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Session settings</h2>
	<ul>
		<li>session lasts for : <%= session.getMaxInactiveInterval() %></li>
		<li>session id : <%= session.getId() %></li>
		<li>created : <%= creationTimeStr %></li>
		<li>last accessed : <%= lastTimeStr %></li>
	</ul>
</body>
</html>