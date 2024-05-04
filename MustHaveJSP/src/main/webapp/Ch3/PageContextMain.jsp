<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Common.Person" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
pageContext.setAttribute("pageInteger",1000);
pageContext.setAttribute("pageString", "페이지 영역의 문자열");
pageContext.setAttribute("pagePerson", new Person("Seok-bong Han", 99));
%>
<title>Insert title here</title>
</head>
<body>
	<h1>page 영역의 속성값 읽기</h1>
	<%
	int pInteger = (Integer)(pageContext.getAttribute("pageInteger"));
	String pString = pageContext.getAttribute("pageString").toString();
	Person pPerson = (Person)(pageContext.getAttribute("pagePerson"));
	%>
	<ul>
		<li>Integer Object : <%= pInteger %></li>
		<li>String Object : <%= pString %></li>
		<li>Person Object : <%= pPerson.getName() %>, <%=pPerson.getAge() %></li>
	</ul>
	<h1>include된 파일에서 페이지 영역 읽어오기</h1>
	<%@ include file="PageInclude.jsp" %>
	객체에 저장된 정보는 페이지를 벗어나면 사라짐..
	<h1>페이지 이동 후 페이지 영역 읽어오기</h1>
	<a href="PageLocation.jsp">PageLocation.jsp 바로가기</a>
</body>
</html>