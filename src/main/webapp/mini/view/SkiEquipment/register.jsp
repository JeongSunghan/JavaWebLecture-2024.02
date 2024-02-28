<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>스키 장비 등록</title>
</head>
<body>
    <h2>스키 장비 등록</h2>
    <form action="register" method="post">
        <label for="equipment_id">장비 ID:</label><br>
        <input type="text" id="equipment_id" name="equipment_id"><br><br>
        
        <label for="user_id">사용자 ID:</label><br>
        <input type="text" id="user_id" name="user_id"><br><br>
        
        <label for="equipment_name">장비 이름:</label><br>
        <input type="text" id="equipment_name" name="equipment_name"><br><br>
        
        <label for="description">설명:</label><br>
        <textarea id="description" name="description"></textarea><br><br>
        
        <label for="condition">상태:</label><br>
        <input type="text" id="condition" name="condition"><br><br>
        
        <label for="image_url">이미지 URL:</label><br>
        <input type="text" id="image_url" name="image_url"><br><br>
        
        <input type="submit" value="등록">
    </form>
</body>
</html>
