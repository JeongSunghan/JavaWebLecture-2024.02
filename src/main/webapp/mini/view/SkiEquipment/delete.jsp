<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>스키 장비 삭제</title>
</head>
<body>
    <h2>스키 장비 삭제</h2>
    <form action="delete" method="post">
        <label for="equipment_id">삭제할 장비 ID:</label><br>
        <input type="text" id="equipment_id" name="equipment_id"><br><br>
        <input type="submit" value="삭제">
    </form>
</body>
</html>
