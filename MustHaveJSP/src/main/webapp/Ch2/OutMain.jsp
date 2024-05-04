<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	out.print("not to print");
	out.clearBuffer();
	%>
	<h1>out implicit object</h1>
	<%
	out.print("buffer size : " + out.getBufferSize() + "<br>");
	out.print("remaining buffer : " + out.getRemaining() + "<br>");
	out.flush();
	
	out.print("buffer size after flush : " + out.getRemaining() + "<br>");
	
	out.print(1);
	out.print(false);
	out.print("gaga" + "<br>");
	out.print("buffer size : " + out.getBufferSize() + "<br>");
	%>
</body>
</html>