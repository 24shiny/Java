<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String outerPage1 = "./OuterPage1.jsp";
String outerPage2 = "./OuterPage2.jsp";
pageContext.setAttribute("pAttr","king1");
request.setAttribute("rAttr", "king2");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>compare two methods - directive and action tag</h2>
	<h3>***directive</h3>
	<%@ include file="./OuterPage1.jsp" %>
	<p> variable defined in Outerpage1 : <%=newVar1 %> </p>
	<h3>***action tag</h3>
	<jsp:include page="./OuterPage2.jsp" />
	<jsp:include page="<%=outerPage2 %>"/>
</body>
</html>