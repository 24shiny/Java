<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Common.JDBConnect" 
    import="java.sql.Statement" import="java.sql.ResultSet" import="java.sql.Connection"
    import="java.sql.ResultSetMetaData" %>
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
	String input = null;
	try{
	input = request.getParameter("id");
	} catch (Exception e) {
		e.printStackTrace();
	}
	String sql = "SELECT * FROM board WHERE id='" + input + "'";
	Statement stmt = jdbc.con.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	
	ResultSetMetaData meta = rs.getMetaData();
	int count = meta.getColumnCount();
	out.print("<table border=\"1\">\n <thead>\n <tr>\n");
	for(int i=1; i<=count; i++) {
		out.print("<th>"+ meta.getColumnLabel(i) + "</th>");
	}
	out.print("</tr>\n </thead>\n <tbody>\n <thead>");
	while(rs.next()){
		int num = rs.getInt("num");
		String title = rs.getString("title");
		String content = rs.getString("content");
		String id = rs.getString("id");
		java.sql.Date postdate = rs.getDate("postdate");
		int visitcount = rs.getInt("visitcount");
		out.print("<tr>");
		out.print("<td>" + String.format("%d", num) + "</td>\n");
		out.print("<td>" + String.format("%s", title) + "</td>\n");
		out.print("<td>" + String.format("%s", content) + "</td>\n");
		out.print("<td>" + String.format("%s", id) + "</td>\n");
		out.print("<td>" + String.format("%s", postdate) + "</td>\n");
		out.print("<td>" + String.format("%d", visitcount) + "</td>\n");
		// out.println(String.format("%d %s %s %s %s %d", num, title, content, id, postdate, visitcount) + "<br/>");
		out.print("</tr>");
	}
	out.print("</tbody>\n </table>");
	jdbc.close();
	%>
</body>
</html>