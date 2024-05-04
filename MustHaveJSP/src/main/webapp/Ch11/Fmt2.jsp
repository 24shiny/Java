<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="today" value="<%=new java.util.Date() %>"/>
	<h2>date</h2>
	<fmt:formatDate value="${today}" type="date" dateStyle="default" /><br/>
	<fmt:formatDate value="${today}" type="date" dateStyle="short" /><br/>
	<fmt:formatDate value="${today}" type="date" dateStyle="medium" /><br/>
	<fmt:formatDate value="${today}" type="date" dateStyle="long" /><br/>
	<fmt:formatDate value="${today}" type="date" dateStyle="full" /><br/>
	<h2>time</h2>
	<fmt:formatDate value="${today}" type="time" timeStyle="default" /><br/>
	<fmt:formatDate value="${today}" type="time" timeStyle="short" /><br/>
	<fmt:formatDate value="${today}" type="time" timeStyle="medium" /><br/>
	<fmt:formatDate value="${today}" type="time" timeStyle="long" /><br/>
	<fmt:formatDate value="${today}" type="time" timeStyle="full" /><br/>
	<h2>date/time</h2>
	<fmt:formatDate value="${today}" type="both" dateStyle="default" timeStyle="default" /><br/>
	<fmt:formatDate value="${today}" type="both" pattern="yyyy-MM-dd hh:mm:ss" /><br/>
	<h2>time zone</h2>
	<h3>central european time zone</h3>
	<fmt:timeZone value="CET">
	<fmt:formatDate value="${today}" type="both" dateStyle="default" timeStyle="default" /><br/>
	</fmt:timeZone>
	<h3>America/Chicago</h3>
	<fmt:timeZone value="America/Chicago">
	<fmt:formatDate value="${today}" type="both" dateStyle="default" timeStyle="default" /><br/>
	</fmt:timeZone>
	<h3>America - set locale</h3>
	<fmt:setLocale value="en_US"/>
	<fmt:formatNumber value="10000" type="currency" />
	<fmt:formatDate value="${today }"/>
</body>
</html>