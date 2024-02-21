<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import ="java.util.*" %>

<c:set var ="price" value = "123456000"></c:set>
<c:set var ="now" value = "<%= new Date() %>"></c:set>




<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSTL</title>
	<style>
		td, th { padding: 3px; }
	</style>
</head>
<body style="margin: 50px">
	<h1>JSP Standard Tag Library(JSTL) - Fmt</h1>
	<c:set var="cid2" value="코어 변수2"></c:set>
	<hr>
	<table border="1">
		<tr><th>표현방법</th><th>결과</th></tr>
			<tr><th colspan="2">숫자</th></tr>
				<tr><td>일반 숫자</td><td>${price}</td></tr>
				<tr><td>천단위 구분기호</td><td><fmt:formatNumber type="number" value="${price}"></fmt:formatNumber></td></tr>
				<tr><td>천단위 구분기호(Type 생략가능)</td><td><fmt:formatNumber value="${price}"></fmt:formatNumber></td></tr>
				<tr><td>통화(KRW)</td>
					<td><fmt:formatNumber type="currency" currencySymbol="KRW" value="${price}"></fmt:formatNumber></td></tr>
				<tr><td>통화(USD)</td>
					<td><fmt:formatNumber type="currency" currencySymbol="USD" value="${price}"></fmt:formatNumber></td></tr>
				<tr><td>퍼센트</td><td><fmt:formatNumber type="percent" value="${price /1000000000}"></fmt:formatNumber></td></tr>
				
		<tr><th colspan="2">날짜</th></tr>
			<tr><td>일반 날짜</td><td>${now}</td></tr>
			<tr><td>Full Date</td>
				<td><fmt:formatDate type="date" dateStyle="full" value="${now}"/></td></tr>
			<tr><td>Short Date</td>
				<td><fmt:formatDate type="date" dateStyle="short" value="${now}"/></td></tr>
			<tr><td>Time</td>
				<td><fmt:formatDate type="time" value="${now}"/></td></tr>
			<tr><td>Pattern("YYYY-MM-dd HH:mm:ss")</td>
				<td><fmt:formatDate pattern="YYYY-MM-dd HH:mm:ss" value="${now}"/></td></tr>
			<tr><td>Pattern("YYYY-MM-dd HH:mm")</td>
				<td><fmt:formatDate pattern="YYYY-MM-dd HH:mm" value="${now}"/></td></tr>
	</table>
</body>
</html>