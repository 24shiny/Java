<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" %>
<%
ArrayList<String> lists = new ArrayList<>();
lists.add("list");
lists.add("collection");
session.setAttribute("lists", lists);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>read attributes in the session area</h1>
	<a href="SessionLocation.jsp">go to SessionLocation.jsp</a>
</body>
</html>