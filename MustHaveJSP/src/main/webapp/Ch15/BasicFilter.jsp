<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
	function forSubmit(form, methodType){
		if(methodType==1){
			form.method = "get";
		} else if (methodType==2){
			form.method = "post";
		}
		form.submit();
	}
	</script>
	<h2>mapping at web.xml</h2>
	<form>
	<input type="button" value="get method" onclick="forSubmit(this.form,1)"/>
	<input type="button" value="post method" onclick="forSubmit(this.form,2)"/>
	</form>
</body>
</html>