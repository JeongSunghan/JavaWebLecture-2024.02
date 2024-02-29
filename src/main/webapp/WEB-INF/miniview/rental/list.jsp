<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>대여 목록</title>
</head>
<body>
    <h1>대여 목록</h1>
    <table border="1">
        <thead>
            <tr>
                <th>대여 ID</th>
                <th>사용자 ID</th>
                <th>장비 ID</th>
                <th>대여 시작일</th>
                <th>대여 종료일</th>
                <th>총 가격</th>
                <th>결제 상태</th>
                <th>작업</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="rental" items="${rentalList}">
                <tr>
                    <td>${rental.getRentalId()}</td>
                    <td>${rental.getUserId()}</td>
                    <td>${rental.getEquipmentId()}</td>
                    <td>${rental.getStartDate()}</td>
                    <td>${rental.getEndDate()}</td>
                    <td>${rental.getTotalPrice()}</td>
                    <td>${rental.isPaymentStatus() ? "결제 완료" : "미결제"}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/auction/rental/rent" method="post">
   							 <input type="hidden" name="equipmentId" value="${rental.getEquipmentId()}">
    						<input type="hidden" name="endDate" value="${rental.getEndDate()}">
    						<input type="hidden" name="totalPrice" value="${rental.getTotalPrice()}">
    						<input type="submit" value="대여하기">
						</form>

                        <form action="${pageContext.request.contextPath}/auction/rental/return" method="post">
                            <input type="hidden" name="rentalId" value="${rental.getRentalId()}">
                            <input type="submit" value="반납하기">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <div>
        <c:forEach var="page" items="${pageList}">
            <a href="${pageContext.request.contextPath}/auction/rental/list?page=${page}">${page}</a>&nbsp;
        </c:forEach>
    </div>
</body>
</html>
