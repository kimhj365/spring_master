<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
<head>
<meta charset="UTF-8">
<title>header.jsp</title>
</head>
<body>
	<div class="header">
		<div>
			<h3>도서대여관리</h3>
		</div>
		<div>
			<ul>
				<li>도서등록</li>
				<li>도서목록조회/수정</li>
				<li>대여현황조회</li>
				<li>홈으로</li>
			</ul>
		</div>
	</div>

	<div layout:fragment="content"></div>
	
	<div class="footer">
		HRDKOREA Copyright
	</div>
</body>
</html>