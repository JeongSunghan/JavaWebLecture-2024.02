<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>스키 장비 목록</title>
</head>
<body>
    <h1>스키 장비 목록</h1>
    <table border="1">
        <thead>
            <tr>
                <th>장비 ID</th>
                <th>사용자 ID</th>
                <th>장비명</th>
                <th>설명</th>
                <th>상태</th>
                <th>이미지 URL</th>
                <th>작업</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${equipmentList}" var="equipmentList">
                <tr>
                    <td>${equipmentList.equipment_id}</td>
                    <td>${equipmentList.user_id}</td>
                    <td>${equipmentList.equipment_name}</td>
                    <td>${equipmentList.description}</td>
                    <td>${equipmentList.condition}</td>
                    <td>${equipmentList.image_url}</td>
                    <td>
                        <a href="auction_db/ski_equipment/list?action=delete&equipment_id=${equipmentList.equipment_id}">삭제</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <a href="auction_db/ski_equipment/list?action=register">새로운 스키 장비 등록</a>
</body>
</html>
