<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String pValue="minstrel";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="person" class="Common.Person" scope="request" />
	<jsp:setProperty property="name" value="Kim1" name="person"/>
	<jsp:setProperty property="age" value="56" name="person"/>
	<jsp:forward page="ParamForward.jsp?param1=Kim2">
		<jsp:param name="param2" value="LA" />
		<jsp:param name="param3" value="<%=pValue%>" />
	</jsp:forward>
</body>
</html>