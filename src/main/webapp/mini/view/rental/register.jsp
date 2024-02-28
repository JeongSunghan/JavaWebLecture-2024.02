<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>렌탈 등록</title>
<script>
    function validateForm() {
        var startDate = new Date(document.getElementById("start_date").value);
        var endDate = new Date(document.getElementById("end_date").value);
        var totalPrice = document.getElementById("total_price").value;
        var paymentStatus = document.getElementById("payment_status").value;

        // 시작 날짜와 종료 날짜 사이의 차이 계산
        var differenceInDays = (endDate.getTime() - startDate.getTime()) / (1000 * 3600 * 24);

        // 시작 날짜와 종료 날짜 사이의 차이가 3일 이상인지 확인
        if (differenceInDays < 3) {
            alert("시작 날짜와 종료 날짜 사이의 차이는 최소 3일이어야 합니다.");
            return false;
        }

        // 총 가격이 5만원 미만이거나 50만원 이상인지 확인
        if (totalPrice < 50000 || totalPrice >= 500000) {
            alert("총 가격은 5만원 이상 50만원 미만이어야 합니다.");
            return false;
        }

        // 지불 가격이 5만원 미만이거나 총 가격보다 큰지 확인
        if (paymentStatus < 50000 || paymentStatus > totalPrice) {
            alert("지불 가격은 5만원 이상이어야 하며 총 가격보다 작아야 합니다.");
            return false;
        }

        return true;
    }
</script>
</head>
<body>
    <h1>새로운 렌탈 등록</h1>
    <form action="${pageContext.request.contextPath}/rental/register" method="post" onsubmit="return validateForm()">
        <label for="rental_id">렌탈 ID:</label>
        <input type="text" id="rental_id" name="rental_id" required><br>
        
        <label for="user_id">사용자 ID:</label>
        <input type="text" id="user_id" name="user_id" required><br>
        
        <label for="equipment_id">장비 ID:</label>
        <input type="text" id="equipment_id" name="equipment_id" required><br>
        
        <label for="start_date">시작 날짜:</label>
        <input type="datetime-local" id="start_date" name="start_date" required><br>
        
        <label for="end_date">종료 날짜:</label>
        <input type="datetime-local" id="end_date" name="end_date" required><br>
        
        <label for="total_price">총 가격:</label>
        <select id="total_price" name="total_price" required>
            <option value="50000">50,000원</option>
            <option value="100000">100,000원</option>
            <option value="150000">150,000원</option>
            <!-- 적절한 범위의 가격을 추가 -->
        </select><br>
        
        <label for="payment_status">지불 가격:</label>
        <select id="payment_status" name="payment_status" required>
            <option value="50000">50,000원</option>
            <option value="100000">100,000원</option>
            <option value="150000">150,000원</option>
            <!-- 총 가격과 같거나 적절한 범위의 가격을 추가 -->
        </select><br>
        
        <input type="submit" value="등록">
    </form>
    <br>
    <a href="${pageContext.request.contextPath}/rental/list">렌탈 목록으로 돌아가기</a>
</body>
</html>
