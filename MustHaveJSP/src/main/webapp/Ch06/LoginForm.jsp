<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../Common/Link.jsp" />
	<h2>login page</h2>
	<span style="color:red; font-size:1.2em;">
		<%=request.getAttribute("LoginErrMsg")==null? "" : request.getAttribute("LoginErrMsg") %>
	</span>
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
	<form action="LoginProcess.jsp" method="post" name="loginFrm"
	onsubmit="return validateForm(this);">
	id : <input type="text" name="user_id" /><br/>
	pw : <input type="password" name="user_pw" /><br />
	<input type="submit" value="login" />
	</form>
	<% 
	} else {
	%>
	<%= session.getAttribute("UserName")%> you are logged in <br />
	<a href="Logout.jsp">[logout]</a>
	<% 
	} 
	%>
</body>
</html>