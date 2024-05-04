<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function validateForm(form){
		if(form.name.value=""){
			alert("enter a name");
			form.name.focus();
		}
		if(form.title.value=""){
			alert("enter a title");
			form.title.focus();
		}
		if(form.content.value=""){
			alert("enter a content");
			form.content.focus();
		}
	}
</script>
</head>
<body>
	<h2>edit</h2>
	<form name="writeFrm" method="post" enctype="multipart/form-data"
	action="./edit.do" onsubmit="return validateForm(this);">
	<input type="hidden" name="idx" value="${dto.idx }"/>
	<input type="hidden" name="preOfile" value="${dto.ofile }"/>
	<input type="hidden" name="preSfile" value="${dto.sfile }"/>
	<table border="1">
	<tr>
		<td>writer</td>
		<td><input type="text" name="name" value="${dto.name }"/></td>
	</tr>
	<tr>
		<td>title</td>
		<td><input type="text" name="title" value="${dto.title }"/></td>
	</tr>
	<tr>
		<td>content</td>
		<td><textarea name="content">${dto.content }</textarea></td>
	</tr>
	<tr>
		<td>attachment</td>
		<td><input type="file" name="ofile"/></td>
	</tr>
	<tr>
		<td>
		<button type="submit">completed</button>
		<button type="reset">reset</button>
		<button type="button" onclick="location.href='./list.do';"></button>
		</td>
	</tr>
	</table>
	</form>
</body>
</html>