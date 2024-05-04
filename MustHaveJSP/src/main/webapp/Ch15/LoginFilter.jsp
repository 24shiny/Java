<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>logIn[Filter]</h2>
	<span><%=request.getAttribute("LoginErrMsg")==null?"":request.getAttribute("LoginErrMsg") %></span>
	<%
	if(session.getAttribute("UserId")==null){
	%>
	<script>
	function validateForm(form){
		if(!form.user_id.value){
			alert("enter an id");
			return false;
		}
		if(form.user_pw.value==""){
			alert("enter a password");
			return false;
		}
	}
	</script>
	<form method="post" name="loginFrm" onsubmit="return validateForm(this);">
	<input type="hidden" name="backUrl" value=${param.backUrl }/>
	id : <input type="text" name="user_id" /><br/>
	pass : <input type="password" name="user_pw" /><br/>
	<input type="submit" value="login" />
	</form>
	<%
	} else {
	%>
		<%=session.getAttribute("UserName") %>your are logged in<br/>
		<a href="?mode=logout">logout</a>
	<%
	}
	%>
</body>
</html>