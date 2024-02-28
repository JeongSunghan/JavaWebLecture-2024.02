<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 가입</title>
</head>
<body>
	<h2>회원 가입</h2>
	<form action="#" method="post">
		 <label for="username">ID:</label>
        <input type="text" name="username" required><br>
        
        <label for="password">비밀번호:</label>
        <input type="password" name="password" required><br>
        
        <label for="password2">비밀번호 확인:</label>
        <input type="password" name="password2" required><br>
        
        
        <label for="email">이메일:</label>
        <input type="email" name="email" required><br>
        
        <label for="phone_number">전화번호:</label>
        <input type="text" name="phone_number" required><br>
        
        <input type="submit" value="가입하기">
	</form>
</body>
</html>