<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>3. 요청 헤더 정보 출력하기</h1>
	<%
	Enumeration headers = request.getHeaderNames();
	while(headers.hasMoreElements()){
		String headerName = (String)headers.nextElement();
		String headerValue = request.getHeader(headerName);
		out.print("헤더명 : " + headerName + "헤더값 : " + headerValue + "<br/>");
	}
	%>
	<p>이 파일을 직접 실행하면 refer 정보는 출력되지 않음</p>
</body>
</html>