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
	if(form.name.value==""){
		alert("check the name");
		form.name.focus();
		return false;
	}
	if(form.title.value==""){
		alert("check the title");
		form.title.focus();
		return false;
	}
	if(form.content.value==""){
		alert("check the content");
		form.content.focus();
		return false;
	}
	if(form.pass.value==""){
		alert("check the pass");
		form.pass.focus();
		return false;
	}			
</script>
</head>
<body>
	<h2>board - write</h2>
	<form name="wrtieFrm" method="post" enctype="multipart/form-data" action="./write.do"
	onsubmit="return validateForm(this);">
		<table border="1">
		<tr>
			<td>name</td>
			<td><input type="text" name="name" style="width:150px;"/></td>
		</tr>
		<tr>
			<td>title</td>
			<td><input type="text" name="title" style="width:90%;"/></td>		
		</tr>
		<tr>
			<td>content</td>
			<td><textarea name="content" style="width:90%;heigh:100px"></textarea></td>
		</tr>
		<tr>
			<td>attached file</td>
			<td><input type="file" name="ofile"/></td>
		</tr>
		<tr>
			<td>pass</td>
			<td><input type="password" name="pass" style="width:100px"/></td>
		</tr>
		<tr>
			<td colspan="2" aglign="center">
			<button type="submit">completed</button>
			<button type="reset">reset</button>
			<button type="button" onclick="location.href='./list.do';">list</button>
			</td>
		</tr>
		</table>
	</form>
</body>
</html>