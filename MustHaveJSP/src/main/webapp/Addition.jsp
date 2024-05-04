<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%! 
    public int addition(int num1, int num2){
    	return num1 + num2;
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	int num1 = 0;
	int num2 = 0;
	try{
	num1 = Integer.parseInt(request.getParameter("param1"));
	num2 = Integer.parseInt(request.getParameter("param2"));
	} catch (Exception e) {
		out.println("fail");
	}
	 %>
	result : <%= addition(10,50) %>
	result : <%= addition(num1,num2) %> 
</body>
</html>