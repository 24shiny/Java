<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.text.SimpleDateFormat" import="java.util.Collection" %>
    <%
    SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    long add_date = s.parse(request.getParameter("add_date")).getTime();
    int add_int = Integer.parseInt(request.getParameter("add_int"));
    String add_str = request.getParameter("add_str");
    
    //응답헤더에 값을 추가
    response.addDateHeader("myBirthday",add_date);
    response.addIntHeader("myNumber",add_int);
    response.addIntHeader("myNumber",1004);
    response.addHeader("myName",add_str);
    response.setHeader("myName","안중근");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>내장 객체 출력하기</h1>
	<%
	Collection<String> headerNames = response.getHeaderNames();
	for(String hName : headerNames){
		String hValue = response.getHeader(hName);
	}
	%>
</body>
</html>