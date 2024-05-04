<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>submit a form</h2>
	<form name="frm" method="post" action="FormResult.jsp">
		name : <input type="text" name="name" /><br/>
		gender : <input type="radio" name="gender" value="male" />male
					<input type="radio" name="gender" value="female" />female<br/>
		education : 
		<select name="grade">
			<option value="ele">elementary</option>
			<option value="mid">middle</option>
			<option value="high">high</option>
			<option value="uni">univ</option>
		</select><br/>
		interests :
			<input type="checkbox" name="inter" value="pol" />politics
			<input type="checkbox" name="inter" value="eco" />economics
			<input type="checkbox" name="inter" value="ent" />entertaintment
			<input type="checkbox" name="inter" value="spo" />sport<br/>
			<input type="submit" value="submit"/>
	</form>
</body>
</html>