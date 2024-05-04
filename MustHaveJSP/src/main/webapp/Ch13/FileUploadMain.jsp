<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
	function validateForm(form){
		if(form.title.value==""){
			alert("enter a title");
			form.title.focus();
			retirm false;
		}
		if(form.ofile.value=""){
			alert("attached file is a must");
			return false;
		}
	}
</script>
<body>
	<h3>file upload</h3>
	<span>${errorMessage }</span>
	<form name="fileForm" method="post" enctype="multipart/form-data"
		action="UploadProcess.do" onsubmit="return validateForm(this)";>
		title : <input type="text" name="title"/><br/>
		categories(optional) :
		<input type="checkbox" name ="cate" value="photo" checked />photo
		<input type="checkbox" name ="cate" value="assgn"  />assignment
		<input type="checkbox" name ="cate" value="word"  />word
		<input type="checkbox" name ="cate" value="music"  />music<br />
		attached file : <input type="file" name="ofile" /><br />
		<input type="submit" value="submit" />
	</form>
</body>
</html>