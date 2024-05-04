<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Common.Person"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>objects in scopes</h2>
	<ul>
		<li>name : ${personObj.name }, age:  ${personObj.age }</li>
		<li>${stringObj }</li>
		<li>${integerObj }</li>
	</ul>
	<h2>objects forwarded</h2>
		<ul>
		<li>${param.firstNum + param.secondNum }</li>
		<li>${param.firstNum } + ${param.secondNum }</li>
	</ul>
</body>
</html>