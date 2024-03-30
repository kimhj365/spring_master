<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert.jsp</title>
<style>
table {
	border: 1px solid black;
}
td, label {
	border: 1px solid black;
}
label {
	display: inline-block;;
	width: 100px;
}

</style>

</head>
<body>
	<h3>도서등록</h3>
	<form name="frmInsert" action="insertBook" method="post">
		<div>
			<label>도서번호</label>
			<input type="text" name="bookNo" value="${bookNo}">
		</div>
		<div>
			<label>도서명</label>
			<input type="text" name="bookName">
		</div>
		<div>
			<label>도서표지</label>
			<input type="text" name="bookCoverimg">
		</div>
		<div>
			<label>출판일자</label>
			<input type="text" name="bookDate">
		</div>
		<div>
			<label>금액</label>
			<input type="text" name="bookPrice">
		</div>
		<div>
			<label>출판사</label>
			<input type="text" name="bookPublisher">
		</div>
		<div>
			<label>도서소개</label>
			<textarea name="bookInfo"></textarea>
		</div>
		<div>
			<button id="saveBtn" type="button">등록</button>
			<button id="info" type="button">조회</button>
		</div>
	</form>
<script>

saveBtn.addEventListener("click", () => {
	if(frmInsert.bookName.value == ""){
		alert("도서명이 입력되지 않았습니다.");
		return
	};
	if(frmInsert.bookPublisher.value == ""){
		alert("출판사가 입력되지 않았습니다.");
		return
	};
	alert("도서 등록이 완료되었습니다.")
	frmInsert.submit();	// 폼 제출
})

</script>
</body>
</html>