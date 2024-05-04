<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="el.MyELClass"%>
<%
MyELClass myClass = new MyELClass();
pageContext.setAttribute("myClass",myClass);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>call a method stored in a scope</h3>
	001225-3000000 => ${myClass.getGender("001225-3000000") }<br/>
	001225-2000000 => ${myClass.getGender("001225-2000000") }<br/>
	
	<h3>call a static method</h3>
	<h4>show me your number table</h4>
	${MyELClass.showGugu(7) }
	<h4>is number?</h4>
	<ul>
		<li>7: ${myClass.isNumber("7") }</li>
		<li>gugu : ${myClass.isNumber("gugu") }</li>
	</ul>
</body>
</html>