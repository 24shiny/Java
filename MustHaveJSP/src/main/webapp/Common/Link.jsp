<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table border="1" width="90%">
	<tr>
		<td aglign="center">
			<% if (session.getAttribute("UserId")==null){ %>
				<a href="../Ch06/LoginForm.jsp">login</a>
			<% } else { %>
				<a href="../Ch06/Logout.jsp">logout</a>
			<% } %>
			&nbsp;&nbsp;&nbsp;
			<a href="../Ch8/List.jsp">board(w/o paging)</a>
			&nbsp;&nbsp;&nbsp;
			<a href="../Ch9/List.jsp">board(w paging)</a>
		</td>
	</tr>
</table>