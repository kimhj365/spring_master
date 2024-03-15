<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>now.jsp</title>
</head>
<body>
<my:myselect></my:myselect>
<h2>시간 알림 서비스</h2>
	현재 날짜와 시간은
	<%= request.getAttribute("today") %>
	<br><b><font color="green">${ requestScope.today }</font></b>
	입니다.
	<hr>클라이언트IP    : <%= request.getRemoteAddr() %>
	<br>클라이언트IP EL : ${ pageContext.request.remoteAddr } 
	<hr>클라이언트 브라우저    : <%= request.getHeader("User-Agent") %>
	<br>클라이언트 브라우저 EL : ${ header["USer-Agent"] }
	<hr>파라미터    : <%= request.getParameter("name") %>
	<br>파라미터 EL : ${param.name }
	<hr>쿠키 : <%= request.getCookies()[2].getValue() %>
	<br>쿠키 EL : ${ cookie.cart.value }
</body>
</html>