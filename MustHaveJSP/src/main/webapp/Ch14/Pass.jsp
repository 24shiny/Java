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
		if(form.pass.value=""){
			alert("enter a password");
			form.pass.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<h2>check a password</h2>
	<form name="writeFrm" method="post" action="./pass.do"
	onsubmit="return validateForm(this);">
		<input type="hidden" name="idx" value="${param.idx }"/>
		<input type="hidden" name="mode" value="${param.mode }"/>
		<table border="1" width="90%">
		<tr>
			<td>password</td>
			<td><input type="password" name="pass"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<button type="submit">verify</button>
			<button type="reset">reset</button>
			<button type="button" onclick="location.href='./list.do';">go to the list</button>
			</td>
		</tr>
		</table>
	</form>
</body>
</html>