<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	int num = 0;
	try{
		num = Integer.parseInt(request.getParameter("dan"));
	} catch (Exception e) { 
		out.print("enter a number");
	}
	if(num!=0){
	out.print(num + "table <br/>");
	for(int i=1; i<10; i++){
		out.print(num + " * " + i + " = " + num*i + "<br/>");
	}
	}
	%>
</body>
</html>