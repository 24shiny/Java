<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board.BoardDAO" import="board.BoardDTO" %>
<%@ include file="./IsLoggedIn.jsp" %>
<%
String num = request.getParameter("num");
BoardDAO dao = new BoardDAO();
BoardDTO dto = dao.selectView(num);
String sessionId = session.getAttribute("UserId").toString();
if(!sessionId.equals(dto.getId())){
	JSFunction.alertBack("only writers can modify posts", out);
	return;
}
dao.close();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function validateForm(form){
	if(form.title.value==""){
		alert("enter a title");
		form.title.focus();
		return false;
	}
	if(form.content.value==""){
		alert("enter a content");
		form.content.focus();
		return false;
	}
</script>
</head>
<body>
	<jsp:include page="../Common/Link.jsp"/>
	<h2>user board - modify</h2>
	<form name="writeFrm" method="post" action="EditProcess.jsp"
	onsubmit="return validateForm(this);">
		<input type="hidden" name="num" value="<%=dto.getNum() %>" />
		<table border="1" width="90%">
		<tr>
			<td>title</td>
			<td>
				<input type="text" name="title" style="width:90%" value="<%=dto.getTitle()%>"/>
			</td>
		</tr>
		<tr>
			<td>content</td>
			<td>
				<textarea name="content" style="width:90%; height:100px;"><%=dto.getContent() %></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit">completed</button>
				<button type="reset">rewrite</button>
				<button type="button" onclick="location.href='List.jsp';">list</button>
			</td>
		</tr>
		</table>
	</form>
</body>
</html>