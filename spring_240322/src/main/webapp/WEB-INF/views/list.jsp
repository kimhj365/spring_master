<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>list.html</title>
</head>
<body>
	<h2>사원목록</h2>
	<table>
		<tr>
			<th>employee_id</th>
			<th>first_name</th>
			<th>last_name</th>
			<th>hire_date</th>
			<th>photo</th>
		</tr>
		<c:forEach items="${empList}" var="emp">
			<tr>
				<td>${emp.employeeId}</td>
				<td>${emp.firstName}</td>
				<td>${emp.lastName}</td>
				<td>${emp.hireDate}</td>
				<td>${emp.photo}</td>
			</tr>
		</c:foreach>
	</table>
</body>
</html>