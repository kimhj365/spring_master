<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.firstRow {  color : yellowgreen; }
	.oddRow {  color : cyan; }
	.backColor { background-color: #eeeeee}
</style>
<script th:inline="javascript">
	let emplist = [[${empList}]]
	
	function gopage(p){
		frmSearch.page.value = p;
		frmSearch.submit();
		//location.href= 'empList?page=' + p
	}
	function init(){
		frmSearch.departmentId.value=""
		frmSearch.firstName.value=""
		frmSearch.managerId.value=""
	}
	function move(empId){
		frmSearch.action = '/info/' + empId
		frmSearch.submit();
	}
</script>
</head>
<body>
 <div layout:fragment="content">
    사원수<span th:text="${#lists.size(empList)}">10</span>명
    회사명<span th:utext="${companyName}" >...</span>
    
    <!--  검색 폼 시작 -->
	<form name="frmSearch" th:object="${empVO}" action="empList">
		<input type="hidden" name="page">
		<select name="departmentId" th:value="*{departmentId}">
			<option value="">선택
			<option value="10" th:selected="*{departmentId}=='10'">Administration
			<option value="20" th:selected="*{departmentId}=='20'">	Marketing
			<option value="50" th:selected="*{departmentId}=='50'">	Shipping
			<option value="60" th:selected="*{departmentId}=='60'">	IT
			<option value="80" th:selected="*{departmentId}=='80'">	Sales
			<option value="90" th:selected="*{departmentId}=='90'">	Executive
			<option value="110" th:selected="*{departmentId}=='100'">Accounting
		</select>	
		firstName<input name="firstName" th:value="*{firstName}">
		ManagerId<input name="managerId" th:value="*{managerId}">
		<button type="button" onclick="gopage(1)">검색</button>
		<button type="button" onclick="init()">초기화</button>
	</form>
    
    <!--  검색 폼 끝 -->
    
    
	<table >
		<tr>
			<th>No</th>
			<th>employee_id</th>
			<th>NAME</th>
			<th>hire_date</th>
			<th>salary</th>
			<th>보너스</th> 
			<th>수정/삭제</th> 
		</tr>
		<tr th:each="emp,stat : ${empList}"  >
			<td th:text="${ stat.count  }" class="backColor" th:classappend="${stat.first? 'firstRow' : stat.odd ? 'oddRow' : _ }" >1</td>
			<td th:text="${emp.employeeId}">100</td>
			
			<td th:text="${emp.firstName} + ' ' + ${emp.lastName}">길동</td>
		<!--/* <td th:text="|${emp.firstName}  ${emp.lastName}|">길동</td>
			<td> [[ ${emp.firstName} ]]  [[ ${emp.lastName} ]] </td>  */-->
	
			<td th:text="${#dates.format(emp.hireDate,'yyyy-MM-dd')}">2020-01-01</td>
			<td th:text="${emp.salary}">2,000</td>
			<td> <button th:if="${emp.salary < 10000}">신청</button>
			     <button th:unless="${emp.salary < 10000}">미신청</button>
			</td>
			<td> <!-- localhost:8081/update/100 -->
				<!-- <a th:href="@{/update/{id}(id=${emp.employeeId})}">수정</a> -->
				<button type="button" th:onclick="move([[${emp.employeeId}]])">조회</button>
				<!-- localhost:8081/delete?employeeId=100&name=xxx -->
				<a th:href="@{/delete(employeeId=${emp.employeeId},name=${emp.firstName})}">삭제</a>
			</td>
		</tr>
	</table>
	
    <!-- 페이징 시작 -->
	<nav aria-label="...">
	  <ul class="pagination">
	    <li class="page-item" th:if="${paging.startPage} > 1 ">
	        <a class="page-link" th:href="|javascript:gopage(${paging.startPage-1})|">Previous</a></li>

	    <li th:each="num : *{#numbers.sequence(paging.startPage, paging.endPage)}" 
	        class="page-item" 
	        th:addclass="${num} == ${paging.page} ? active">
	        <a class="page-link" th:href="|javascript:gopage(${num})|"  th:text="${num}">2</a></li>
	    
	    <li class="page-item" th:classappend="${paging.endPage} <= ${paging.lastPage} ? disabled">
	        <a class="page-link" th:href="|javascript:gopage(${paging.endPage+1})|">Next</a></li>
	  </ul>
	</nav>
	<!-- 페이징 종료 -->
	
	<div class="footerSector" th:replace="~{footer :: addr}"> 여기에 삽입 </div>
	[[${paging}]]

	</div>	
</body>
</html>