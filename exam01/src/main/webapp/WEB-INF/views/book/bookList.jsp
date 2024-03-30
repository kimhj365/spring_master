<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookList.jsp</title>
<style>
table {
	border: 1px solid black;
}
td, th {
	border: 1px solid black;
}
.bookImage {
	width: 100px;
	height : auto;
}
</style>
</head>
<body>
<h3>도서 조회/수정</h3>
	<table>
		<thead>
			<tr>
				<th>도서번호</th>
				<th>도서명</th>
				<th>표지</th>
				<th>출판일자</th>
				<th>금액</th>
				<th>출판사</th>
				<th>도서소개</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${bookList}" var="book">
			<tr>
				<td>${book.bookNo}</td>
				<td>${book.bookName}</td>
				<td><img class="bookImage" src="${pageContext.request.contextPath}/resources/images/${book.bookCoverimg}"></td>
				<td><fmt:formatDate value="${book.bookDate}" pattern="yyyy-mm-dd" /></td>
				<td><fmt:formatNumber value="${book.bookPrice}" pattern="#,###" /></td>
				<td>${book.bookPublisher}</td>
				<td>${book.bookInfo}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>