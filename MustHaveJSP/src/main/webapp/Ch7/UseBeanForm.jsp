<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>read the form with action tag</h2>
	<form method="post" action="UseBeanAction.jsp">
		name : <input type="text" name="name"/><br/>
		age : <input type="text" name="age"/><br/>
		<input type="submit" value="send the form" />
	</form>
</body>
</html>