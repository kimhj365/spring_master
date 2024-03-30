<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<style>
.title {
	width: 100%;
	height: 100px;
	text-align : center;
	color: white;
	background-color: gray;
	text-align: center;
	line-height: 100px;
}

.menu {
	color: white;
	background: black;
}

.nav {
	list-style: none;
	margin: 0;
}

.nav li {
	display: inline-block;
	color: white;
	padding: 10px;
}

ol {
	margin: 0;
}


.footer {
	color: white;
	background-color: gray;
	text-align: center;
	margin: 0;
}

.content {
	background-color: green;
	margin: 0;
	padding: 10px;
}

.subtitle {
	text-align: center;
}

</style>
</head>
<body>

	<div class="title">
		<h3>도서대여관리</h3>
	</div>
	<div class="menu">
		<ul class="nav">
			<li><a href="/mb/insertBookForm">도서등록</a></li>
			<li><a href="/mb/bookList">도서목록조회/수정</a></li>
			<li><a href="/mb/rentList">대여현황조회</a></li>
			<li><a href="/mb/index">홈으로</a></li>
		</ul>
	</div>


	<div class="content">
		<div class="subtitle">
			<b>도서대여관리 프로그램</b><br>
		</div>
		<p>
			국제 대여점의 도서등록, 대여정보 데이터베이스를 구축하고 도서DVD 대여관리를 위한 프로그램이다.<br>프로그램
			작성 순서
		</p>
		<ol>
			<li>도서정보 테이블을 생성한다.</li>
			<li>대여정보 테이블을 생성한다.</li>
			<li>도서정보, 대여정보 테이블에 제시된 문제지의 참조데이터를 추가 생성한다.</li>
			<li>도서정보 입력 화면프로그램을 작성한다.</li>
			<li>도서정보 조회 프로그램을 작성한다.</li>
			<li>대여 정보 조회 프로그램을 작성한다.</li>
		</ol>
	</div>

	<div class="footer">HRDKOREA Copyright</div>
</body>
</html>