<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>스키 장비 반납</title>
</head>
<body>
    <h2>스키 장비 반납</h2>
    <form action="return" method="post">
        <label for="equipment_id">반납할 장비 ID:</label><br>
        <input type="text" id="equipment_id" name="equipment_id"><br><br>
        <label for="user_id">대여자 ID:</label><br>
        <input type="text" id="user_id" name="user_id"><br><br>
        <input type="submit" value="반납">
    </form>
</body>
</html>
