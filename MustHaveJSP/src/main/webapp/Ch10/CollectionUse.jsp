<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.HashMap" import="java.util.Map" import="java.util.List" import="java.util.ArrayList"
    import="Common.Person"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>list collection</h2>
<%
List<Object> aList = new ArrayList<Object>();
aList.add("Blue House");
aList.add(new Person("president",55));
pageContext.setAttribute("Mt",aList);
%>
<ul>
	<li>0th : ${ Mt[0]}</li>
	<li>1th : ${ Mt[1].name} is ${ Mt[1].age} years old</li>
</ul>

<h2>map collection</h2>
<%
Map<String,String> map = new HashMap<>();
map.put("korean","korea");
map.put("german","germany");
pageContext.setAttribute("Lan",map);
%>
<ul>
	<li>0th : ${ Lan.korean}</li>
	<li>1th : ${ Lan.german}</li>
</ul>
</body>
</html>