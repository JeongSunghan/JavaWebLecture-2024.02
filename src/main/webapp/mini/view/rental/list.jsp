<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대여 목록</title>
</head>
<body>
    <h2>대여 목록</h2>
    <table border="1">
        <thead>
            <tr>
                <th>대여 ID</th>
                <th>사용자 ID</th>
                <th>장비 ID</th>
                <th>시작 일시</th>
                <th>종료 일시</th>
                <th>총 가격</th>
                <th>결제 상태</th>
                <th>조치</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="rental" items="${rentalList}">
                <tr>
                    <td>${rental.rental_id}</td>
                    <td>${rental.user_id}</td>
                    <td>${rental.equipment_id}</td>
                    <td>${rental.start_date}</td>
                    <td>${rental.end_date}</td>
                    <td>${rental.total_price}</td>
                    <td>${rental.payment_status}</td>
                    <td>
                        <a href="/jw/rental/update?rental_id=${rental.rental_id}">수정</a>
                        <a href="/jw/rental/delete?rental_id=${rental.rental_id}">삭제</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="/jw/rental/register">새로운 대여 등록</a>
</body>
</html>
