<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board.BoardDAO" import="board.BoardDTO" %>
<%@ include file="./IsLoggedIn.jsp" %>
<%
String num = request.getParameter("num");
BoardDTO dto = new BoardDTO();
BoardDAO dao = new BoardDAO();
dto = dao.selectView(num);
String sessionId = session.getAttribute("UserId").toString();
int delResult = 0;
if(sessionId.equals(dto.getId())){
	dto.setNum(num);
	delResult = dao.deletePost(dto);
	dao.close();
	
	if(delResult==1){
		JSFunction.alertLocation("deleted","List.jsp",out);
	} else {
		JSFunction.alertBack("fail to delete", out);
	}
} else {
	JSFunction.alertBack("only writers can delete posts",out);
	return;
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