<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>스키 장비 대여</title>
</head>
<body>
    <h2>스키 장비 대여</h2>
    <form action="rent" method="post">
        <label for="equipment_id">대여할 장비 ID:</label><br>
        <input type="text" id="equipment_id" name="equipment_id"><br><br>
        <label for="user_id">대여자 ID:</label><br>
        <input type="text" id="user_id" name="user_id"><br><br>
        <input type="submit" value="대여">
    </form>
</body>
</html>
