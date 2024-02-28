<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대여 정보 수정</title>
</head>
<body>
    <h2>대여 정보 수정</h2>
    <form action="rental/update" method="post">
        대여 ID: <input type="text" name="rental_id" value="${rental.rental_id}" readonly><br>
        사용자 ID: <input type="text" name="user_id" value="${rental.user_id}"><br>
        장비 ID: <input type="text" name="equipment_id" value="${rental.equipment_id}"><br>
        시작 일시: <input type="text" name="start_date" value="${rental.start_date}"><br>
        종료 일시: <input type="text" name="end_date" value="${rental.end_date}"><br>
        총 가격: <input type="text" name="total_price" value="${rental.total_price}"><br>
        결제 상태: <input type="text" name="payment_status" value="${rental.payment_status}"><br>
        <input type="submit" value="수정">
    </form>
</body>
</html>
