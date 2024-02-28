<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대여 삭제</title>
</head>
<body>
    <h2>대여 삭제</h2>
    <form action="rental/delete" method="post">
        대여 ID: <input type="text" name="rental_id"><br>
        <input type="submit" value="삭제">
    </form>
</body>
</html>
