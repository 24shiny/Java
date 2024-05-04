<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board.BoardDAO" import="board.BoardDTO" %>
<%
String num = request.getParameter("num");
BoardDAO dao = new BoardDAO();
dao.updateVisitcount(num);
BoardDTO dto = dao.selectView(num);
dao.close();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function deletePost(){
		var confirmed = confirm("are you sure to delete?");
		if(confirmed){
			var form = document.writeFrm;
			form.method = "post";
			form.action = "DeleteProcess.jsp";
			form.submit();
		}
	}
</script>
</head>
<body>
<jsp:include page="../Common/Link.jsp" />
<h2>member board - view</h2>
<form name="writeFrm">
	<input type="hidden" name="num" value="<%=num %>" />
	<table border="1" width="90%">
		<tr>
			<td>num</td>
			<td><%=dto.getNum() %></td>
			<td>username</td>
			<td><%=dto.getName() %></td>
		</tr>
		<tr>
			<td>postdate</td>
			<td><%=dto.getPostdate() %></td>
			<td>visitcount</td>
			<td><%=dto.getVisitcount() %></td>
		</tr>
		<tr>
			<td>title</td>
			<td colspan="3"><%=dto.getTitle() %></td>
		</tr>
		<tr>
			<td>content</td>
			<td colspan="3" height="100"><%=dto.getContent().replace("\r\n","<br/>") %></td>
		</tr>
		<tr>
			<td colspan="4" align="center">
			<%
			if(session.getAttribute("UserId")!=null
			&& session.getAttribute("UserId").toString().equals(dto.getId())){
			%>
			<button type="button" onclick="location.href='Edit.jsp?num<%=dto.getNum() %>';">
			modify</button>
			<button type="button" onclick="deletePost();">delete</button>
			<%
			}
			%>
			<button type="button" onclick="location.href='List.jsp';">list</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>