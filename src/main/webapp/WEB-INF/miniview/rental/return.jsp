<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>장비 반납</title>
</head>
<body>
    <h1>장비 반납</h1>
    <form action="${pageContext.request.contextPath}/auction/rental/return" method="post">
        <label for="rentalId">대여 ID:</label>
        <input type="text" id="rentalId" name="rentalId"><br>
        <input type="submit" value="반납하기">
    </form>
</body>
</html>
