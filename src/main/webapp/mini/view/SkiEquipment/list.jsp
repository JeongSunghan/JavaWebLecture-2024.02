<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품 페이지</title>
</head>
<body>
	
    <h2>장비 목록</h2>
    <table border="1">
        <tr>
            <th>장비 ID</th>
            <th>사용자 ID</th>
            <th>장비 이름</th>
            <th>설명</th>
            <th>상태</th>
            <th>이미지 URL</th>
        </tr>
        <!-- 스키 장비 목록 데이터를 반복문 -->
        <c:forEach var="equipment" items="${equipmentList}">
            <tr>
                <td>${equipment.equipment_id}</td>
                <td>${equipment.user_id}</td>
                <td>${equipment.equipment_name}</td>
                <td>${equipment.description}</td>
                <td>${equipment.condition}</td>
                <td>${equipment.image_url}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="/jw/SkiEquipment/register">등록</a>
    <a href="/jw/SkiEquipment/update">수정</a>
    <a href="/jw/SkiEquipment/delete">삭제</a>
</body>
</html>
