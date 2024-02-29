<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>스키 장비 추가</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 500px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 20px;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        label {
            margin-bottom: 5px;
        }
        input[type="text"],
        textarea {
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
        }
        button[type="submit"] {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        button[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>스키 장비 추가</h1>
        <form action="/jw/auction/ski_equipment/add" method="post">
            <label for="equipmentId">장비 ID:</label>
            <input type="text" id="equipmentId" name="equipmentId">
            <label for="userId">사용자 ID:</label>
            <input type="text" id="userId" name="userId">
            <label for="equipmentName">장비명:</label>
            <input type="text" id="equipmentName" name="equipmentName">
            <label for="description">설명:</label>
            <textarea id="description" name="description"></textarea>
            <label for="condition">상태:</label>
            <input type="text" id="condition" name="condition">
            <label for="imageUrl">이미지 URL:</label>
            <input type="text" id="imageUrl" name="imageUrl">
            <button type="submit">장비 추가</button>
        </form>
    </div>
</body>
</html>
