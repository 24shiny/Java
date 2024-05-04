<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>read attributes in the session area</h1>
	<% 
	ArrayList<String> lists = (ArrayList<String>)session.getAttribute("lists");
	for(String str : lists) out.print(str + "<br />");
	%>
</body>
</html>