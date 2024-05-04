<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Common.JDBConnect" import="java.sql.PreparedStatement" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>add a member</h2>
	<%
	JDBConnect jdbc = new JDBConnect();
	String id = "canhave";
	String pass = "1446";
	String name = "lemon";
	String sql = "INSERT INTO member VALUES(?,?,?,now())";
	PreparedStatement psmt = jdbc.con.prepareStatement(sql);
	psmt.setString(1,id);
	psmt.setString(2,pass);
	psmt.setString(3,name);
	int inResult = psmt.executeUpdate();
	out.println(inResult + "is entered");
	jdbc.close();
	%>
</body>
</html>