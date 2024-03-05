<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>memberList</title>
	<style>
		td, th { padding: 3px; }
		td, th { background-color: silver}
	</style>
</head>
<body style="margin: 50px">
	<h1>Exam - memberList</h1>
	<hr>
	<table border="1">
		<tr><th>mid</th><th>name</th><th>age</th><th>country</th></tr>
		
	<c:forEach var="member" items="${members}" varStatus="loop">
		<tr>
			<td>
				<!-- 아이디 -->
				<c:if test="${member.mid % 2 == 1}">
					<span style="color: blue;">${member.mid }</span>
				</c:if>
				<c:if test="${member.mid % 2 == 0}">
					<span style="color: red;">${member.mid }</span>
				</c:if>
			</td>
			<td>
				<!-- 이름 -->
				<c:if test="${loop.first}">
					<span style="background: yellow;">${member.name }</span>
				</c:if>
				<c:if test="${loop.last}">
					<span style="background: cyan;">${member.name }</span>
				</c:if>
				<c:if test="${not (loop.first or loop.last)}">
					<span style="background: beige;">${member.name }</span>
				</c:if>
			</td>
			<td>
				<!-- 나이 -->
				<c:if test="${member.age lt 20}">
					<span style="color: blue;">${member.age }</span>
				</c:if>
				<c:if test="${member.age gt 20}">
					<span style="color: red;">${member.age }</span>
				</c:if>
			</td>
			<td>
				<!-- 나라 -->
				<c:if test="${member.country eq '한국' }">
					<span style="background: orange;">${member.country }</span>
				</c:if>
				<c:if test="${member.country eq '미국' }">
					<span style="background: skyblue;">${member.country }</span>
				</c:if>
				<c:if test="${member.country ne '한국' and member.country ne '미국' }">
					<span style="background: beige;">${member.country}</span>
				</c:if>
			</td>
		</tr>
	</c:forEach>
	</table>
	<br>
	<br>
</body>
</html>