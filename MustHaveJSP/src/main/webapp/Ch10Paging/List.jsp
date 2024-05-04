<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "java.util.List" import="java.util.HashMap" import="java.util.Map"
    import ="board.BoardDTO" import="board.BoardDAO" import="utils.BoardPage" %>
<%
BoardDAO dao = new BoardDAO();
Map<String,Object> param = new HashMap<String,Object>();
String searchField = request.getParameter("searchField");
String searchWord = request.getParameter("searchWord");
if(searchWord!=null){
	param.put("searchField",searchField);
	param.put("searchWord",searchWord);
}
int totalCount = dao.selectCount(param);

int pageSize = Integer.parseInt(application.getInitParameter("POSTS_PER_PAGE"));
int blockPage = Integer.parseInt(application.getInitParameter("PAGES_PER_BLOCK"));
int totalPage = (int)Math.ceil((double)totalCount/pageSize);
//current page
int pageNum = 1;
String pageTemp = request.getParameter("pageNum");
if(pageTemp!=null&&!pageTemp.equals("")){
	pageNum = Integer.parseInt(pageTemp);
}
// range of posts to print
int start = (pageNum-1)*pageSize;
param.put("start",start);
param.put("pageSize",pageSize);

List<BoardDTO> boardLists = dao.selectListPage(param);
dao.close();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../Common/Link.jsp" />
	<h2>show lists - current page : <%=pageNum %> out of <%=totalPage %></h2>
	<form method="get">
		<table border="1" width="90%">
		<tr>
			<td align="center">
				<select name="searchField">
					<option value="title">title</option>
					<option value="content">content</option>
				</select>
				<input type="text" name="searchWord" />
				<input type="submit" value="search" />
			</td>
		</tr>
		</table>
	</form>
	<table border="1" width="90%">
		<tr>
			<th width="10%">num</th>
			<th width="50%">title</th>
			<th width="15%">username</th>
			<th width="10%">visitcount</th>
			<th width="15%">postdate</th>
		</tr>
	<%
	if(boardLists.isEmpty()){
	%>
	<tr>
		<td colspan="5" align="center">no posts</td>
	</tr>
	<%
	} else {
		int virtualNum = 0;
		int countNum = 0;
		for(BoardDTO dto : boardLists){
			virtualNum = totalCount - (((pageNum-1)*pageSize)+countNum++);
	%>
		<tr aglign="center">
			<td><%=virtualNum%></td>
			<td align="left">
				<a href="View.jsp?num=<%= dto.getNum() %>"><%= dto.getTitle()%></a>
			</td>
			<td align="center"><%=dto.getId() %></td>
			<td align="center"><%=dto.getVisitcount() %></td>
			<td align="center"><%=dto.getPostdate() %></td>
		</tr>
	<%
		}
	}
	%>
	</table>
	<table border="1" width="90%">
		<tr align="center">
			<td>
			<%=BoardPage.pagingStr(totalCount,pageSize,blockPage,pageNum,request.getRequestURI()) %>
			</td>
			<td>
			<button type="button" onclick="location.href='Write.jsp';">write</button>
			</td>
		</tr>
	</table>
</body>
</html>