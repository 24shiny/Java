<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board.BoardDAO" import="board.BoardDTO" %>
<%@ include file="./IsLoggedIn.jsp" %>
<%
// read modified contents
String num = request.getParameter("num");
String title = request.getParameter("title");
String content = request.getParameter("content");
// store in DTO
BoardDTO dto = new BoardDTO();
dto.setNum(num);
dto.setTitle(title);
dto.setContent(content);
// reflect the modification into DB
BoardDAO dao = new BoardDAO();
int affected = dao.updateEdit(dto);
dao.close();
//success or failure
if(affected==1){
	response.sendRedirect("View.jsp?num="+dto.getNum());
} else {
	JSFunction.alertBack("fail to modify",out);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>