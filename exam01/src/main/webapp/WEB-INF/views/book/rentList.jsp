<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>rentList.jsp</title>
<style>
table {
	border: 1px solid black;
}
td, th {
	border: 1px solid black;
}
</style>
</head>
<body>
	<h3>도서별 대여매출현황</h3>
	<table>
		<thead>
			<tr>
				<th>도서번호</th>
				<th>도서명</th>
				<th>대여총계</th>
				<th>대여횟수</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${rentList}" var="rent">
			<tr>
				<td>${rent.get("bookNo")}</td>
				<td>${rent.get("bookName")}</td>
				<td>${rent.get("total")}</td>
				<td>${rent.get("cnt")}</td>		
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>