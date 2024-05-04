<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="fileload.MyFileDAO" import="fileload.MyFileDTO" 
    import = "java.net.URLEncoder" import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>file list</h2>
	<a href="FileUploadMain.jsp">upload 1</a>
	<a href="MultiUploadMain">upload 2</a>
	<%
	MyFileDAO dao = new MyFileDAO();
	List<MyFileDTO> fileLists = dao.myFileList();
	dao.close();
	%>
	<table border="1">
	<tr>
		<th>No</th><th>title</th><th>category</th>
		<th>ofileName</th><th>sFileName</th><th>postdate</th>
	</tr>
	<%for (MyFileDTO f:fileLists) { %>
	<tr>
		<td><%=f.getIdx() %></td>
		<td><%=f.getTitle() %></td>
		<td><%=f.getCate() %></td>
		<td><%=f.getOfile() %></td>
		<td><%=f.getSfile() %></td>
		<td><%=f.getPostdate() %></td>
		<td><a href="Download.jsp?oName=<%=URLEncoder.encode(f.getOfile(),"UTF-8")%>
		&sName=<%= URLEncoder.encode(f.getSfile(),"UTF-8") %>">
		download</a></td>
	</tr>
	<% } %>
	</table>
</body>
</html>