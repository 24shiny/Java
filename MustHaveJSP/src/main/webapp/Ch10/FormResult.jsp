<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>get the form</h3>
	<ul>
		<li>name : ${param.name}</li>
		<li>gender : ${param.gender}</li>
		<li>education : ${param.grade}</li>
		<li>interests : ${paramValues.inter[0]}
		${paramValues.inter[1]}
		${paramValues.inter[2]}
		${paramValues.inter[3]}</li>
	</ul>
</body>
</html>