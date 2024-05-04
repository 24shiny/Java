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
		num = Integer.parseInt(request.getParameter("col"));
	} catch (Exception e) { 
		out.print("enter a number");
	}
	if(num!=0){
		for(int i=1; i<=Math.ceil(9/num); i++){ //rows
			for(int j=0; j<num; j++){
				for(int k=1; k<10; k++){
					out.print(2*i+j + " * " + k + " = " + (2*i+j)*k);
				}
				out.print("<br/>");
			}
		out.print("<br/>");
		}
	}
	%>
</body>
</html>