<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.HashMap" import="Common.Person" import="java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>application area</h1>
	<%
	Map<String, Person> maps = new HashMap<>();
	maps.put("actor1", new Person("Shin",30));
	maps.put("actor2", new Person("Lee", 29));
	application.setAttribute("maps", maps);
	%>
	attributes are saved in the application area.
</body>
</html>