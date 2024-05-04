<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%! 
    	String greeting = "Welcome";
    	String farewell = "Good bye";
    	String str2 = "Afternoon"; 
    	public int add(int num1, int num2){
    		return num1 + num2;
    	}
    	public String getMessage(String str1){
    		if(str1.equals("java"))
    			return "Let's hit the book";
    		else 
    			return "Let's call it a day!^^*";
    	}
    	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP</title>
</head>
<body>
	
	<p>
	<%
	String str1 = request.getParameter("lang");
	String str3 = request.getParameter("short");
	out.println(greeting + ", " + str1 + " and "+ str3 + ", " + getMessage(str1));
	int result = add(5,10);
	%>
	<br>
	result1 : <%= result %>
	<br>
	result2 : <%= add(30,40) %>
	</p>
</body>
</html>