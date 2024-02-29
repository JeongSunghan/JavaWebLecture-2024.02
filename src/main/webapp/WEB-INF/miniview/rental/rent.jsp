<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>장비 대여</title>
</head>
<body>
    <h1>장비 대여</h1>
    <form action="${pageContext.request.contextPath}/auction/rental/rent" method="post">
        사용자 ID: <input type="text" name="userId"><br>
        장비 ID: <input type="text" name="equipmentId"><br>
        대여 종료 날짜: <input type="date" name="endDate"><br>
        대여 종료 시간: <input type="time" name="endTime"><br>
        총 가격: <input type="text" name="totalPrice"><br>
        <input type="submit" value="대여하기">
    </form>
</body>
</html>
