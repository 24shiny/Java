<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Common.JDBConnect" 
    import="java.sql.Statement" import="java.sql.ResultSet" import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>list of members</h2>
	<%
	JDBConnect jdbc = new JDBConnect();
	String sql = "SELECT * FROM member";
	Statement stmt = jdbc.con.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	while(rs.next()){
		String id = rs.getString(1);
		String pw = rs.getString(2);
		String name = rs.getString("name");
		java.sql.Date regidate = rs.getDate("regidate");
		out.println(String.format("%s %s %s %s", id, pw, name, regidate) + "<br/>");
	}
	jdbc.close();
	%>
</body>
</html>