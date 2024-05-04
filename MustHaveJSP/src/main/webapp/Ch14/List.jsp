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
	<h2>MVC board list</h2>
	<form method="get">
		<table border="1">
		<tr>
			<td align="center">
				<select name="searchField">
					<option value="title">title</option>
					<option value="content">content</option>
				</select>
				<input type="text" name="searchWord"/>
				<input type="submit" value="search"/>
			</td>
		</tr>
		</table>
	</form>
	
	<table border="1">
		<tr>
			<th width="10%">num</th>
			<th width="*">title</th>
			<th width="15%">writer</th>
			<th width="10%">visitcount</th>
			<th width="15%">postdate</th>
			<th width="8%">attachment</th>
		</tr>
		<c:choose>
			<c:when test="${empty boardLists }">
			<tr>
				<td colspan="6" align="center">no post</td>
			</tr>
			</c:when>
			<c:otherwise>
			<c:forEach items="${boardLists }" var="row" varStatus="loop">
				<tr align="center">
					<td>${map.totalCount - (((map.pageNum-1)*map.pageSize)+loop.index) }</td>
					<td><a href="./view.do?idx=${row.idx }">${row.title }</a></td>
					<td>${row.name }</td>
					<td>${row.visitcount }</td>
					<td>${row.postdate }</td>
					<td><c:if test="${not empty row.ofile }">
						<a href="./download.do?ofile=${row.ofile }&sfile=${row.sfile}
						&idx=${row.idx}">[down]</a>
					</c:if></td>
				</tr>
			</c:forEach>
			</c:otherwise>
	</c:choose>
	</table>
	
	<table border="1">
		<tr align="center">
			<td>${map.pagingImg }</td>
			<td width="100"><button type="button" onclick="location.href='./write.do';">write</button></td>
		</tr>
	</table>
</body>
</html>