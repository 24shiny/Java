<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="membership.MemberDTO" import="membership.MemberDAO"%>
<%
	// id&pw from the login form
	String userId = request.getParameter("user_id");
	String userPwd = request.getParameter("user_pw");
	
	// init parameters from web.xml
	String MySQLDriver = application.getInitParameter("MySQLDriver");
	String MySQLURL = application.getInitParameter("MySQLURL");
	String MySQLId = application.getInitParameter("MySQLId");
	String MySQLPwd = application.getInitParameter("MySQLPwd");
	
	// info from [member]
	MemberDAO dao = new MemberDAO();
	MemberDTO dto = dao.getMemberDTO(userId, userPwd);
	dao.close();
	
	// depending on success in login,
	if (dto.getId()!=null){
		session.setAttribute("UserId",dto.getId());
		// get an object 'dto'
		// session.setAttribute("user", dto);
		session.setAttribute("UserName",dto.getName());
		response.sendRedirect("LoginForm.jsp");
	} else {
		request.setAttribute("LoginErrMsg", "error in login");
		request.getRequestDispatcher("LoginForm.jsp").forward(request,response);
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