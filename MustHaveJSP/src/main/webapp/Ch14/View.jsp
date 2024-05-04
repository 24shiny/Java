<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>view posts</h2>
	<table border="1" width="90%">
	<colgroup><col width="15%"/><col width="35%"/>
	<col width="15%"/><col width="*"/></colgroup>
	<tr>
		<td>num</td><td>${dto.idx }</td>
		<td>writer</td>${dto.name }<td></td>
	</tr>
	<tr>
		<td>postdate</td><td>${dto.postdate }</td>
		<td>visitcount</td>${dto.visitcount }<td></td>
	</tr>
	<tr>
		<td>title</td><td>${dto.title }</td>
	</tr>
	<tr>
		<td>content</td><td>${dto.content }
		<c:if test="${not empty dto.ofile and isImage eq true }">
		<br><img src="./Uploads/${dto.sfile }"/></c:if>
		</td>
	</tr>
	<tr>
		<td>attachment</td><td>
		<c:if test="${not empty dto.ofile}">${dto.sfile }
		<a href="./download.do?ofile=${dto.ofile }&sfile=${dto.sfile}
		&idx=${dto.idx}">download</a></c:if>
		</td>
		<td>download count</td>
		<td>${dto.downcount }</td>
	</tr>
	<tr>
		<td>
		<button type="button" onclick="location.href='./pass.do?mode=edit&idx=${param.idx}';">modify</button>
		<button type="button" onclick="location.href='./pass.do?mode=delete=${param.idx}';">delete</button>
		<button type="button" onclick="location.href='./list.do';">go to the list</button>
		</td>
	</tr>
	</table>
</body>
</html>