<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String popupMode = "on";
Cookie[] cookies = request.getCookies();
if(cookies!=null){
	for(Cookie c : cookies){
		String cookieName = c.getName();
		String cookieValue = c.getValue();
		if(cookieName.equals("PopupClose")){
			popupMode = cookieValue;
		}
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>manage pop-ups with cookies ver 0.1</h1>
	<style>
	div#popup{
		position: absolute;
		top:100px;
		left:50px;
		color:yellow;
		width:300px;
		height:200px;
		background-color:gray;
	}
	div#popip>div{
		position:relative;
		background-color:#ffffff;
		top:0px;
		border:1px solid gray;
		padding:10px;
		color:black;
	}
	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
	<script>
	$(function(){
		$('#closeBtn').click(function(){
			$('#popup').hide();
			var chkVal = $("input:checkbox[id=inactiveToday]:checked").val();
		if(chkVal==1){
			$.ajax({
				url : './PopupCookie.jsp',
				type : 'get',
				data : {inactiveToday : chkVal},
				dataType : "text",
				success : function(resData){
					if(resData!='') location.reload();
				}
			});
		}
		});
	});
	</script>
	<h1>main page</h1>
	<%
		 for(int i=1; i<=10; i++){
			 out.print("the current popup window is " + popupMode + "<br/>");
		 }
	if(popupMode.equals("on"));
	%>
	<div id="popup">
		<h2 align="center">announcement</h2>
		<div align="right"><form name="popFrm">
			<input type="checkbox" id="inactiveToday" value="1" />
			not open until tomorrow
			<input type="button" value="close" id="closeBtn" />
		</form>
		</div>
	</div>
</body>
</html>