<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ include file="./IsLoggedIn.jsp" %>
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
	<h2>user board - write</h2>
	<form name="writeFrm" method="post" action="WriteProcess.jsp"
	onsubmit="return validateForm(this);">
		<table border="1" width="90%">
		<tr>
			<td>title</td>
			<td>
				<input type="text" name="title" style="width:90%"/>
			</td>
		</tr>
		<tr>
			<td>content</td>
			<td>
				<textarea name="content" style="width:90%; height:100px;"></textarea>
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