package mini.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import mini.entity.Rental;

public class RentalDao {

	public Connection getConnection() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/" + "jdbc/auction");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public Rental getRentalById(String rentalId) {
		Connection conn = getConnection();
		String sql = "SELECT * FROM rentals WHERE rental_id = ?";
		Rental rental = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rentalId);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				rental = new Rental(rs.getString(1), rs.getString(2), rs.getString(3),
						LocalDateTime.parse(rs.getString(4).replace(" ", "T")),
						LocalDateTime.parse(rs.getString(5).replace(" ", "T")), rs.getBigDecimal(6), rs.getBoolean(7));
			}

			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rental;
	}

	public List<Rental> getRentalList(int page) {
		Connection conn = getConnection();
		int offset = (page - 1) * 10;
		String sql = "SELECT * FROM rentals LIMIT 10 OFFSET ?";
		List<Rental> rentalList = new ArrayList<Rental>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, offset);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Rental rental = new Rental(rs.getString(1), rs.getString(2), rs.getString(3),
						LocalDateTime.parse(rs.getString(4).replace(" ", "T")),
						LocalDateTime.parse(rs.getString(5).replace(" ", "T")), 
						rs.getBigDecimal(6), rs.getBoolean(7));

				rentalList.add(rental);
			}

			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rentalList;
	}

	public int getRentalCount() {
		Connection conn = getConnection();
		String sql = "SELECT COUNT(*) FROM rentals";
		int count = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				count = rs.getInt(1);
			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public void rentItem(String userId, String equipmentId, LocalDateTime startDate, LocalDateTime endDate,
			BigDecimal totalPrice) {
		Connection conn = getConnection();
		String sql = "INSERT INTO rentals (user_id, equipment_id, start_date, end_date, total_price, payment_status) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, equipmentId);
			pstmt.setObject(3, startDate);
			pstmt.setObject(4, endDate);
			pstmt.setBigDecimal(5, totalPrice);
			pstmt.setBoolean(6, false);

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void returnItem(String rentalId) {
		Connection conn = getConnection();
		String sql = "UPDATE rentals SET payment_status = true WHERE rental_id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rentalId);

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void rentAndPay(String userId, String equipmentId, LocalDateTime startDate, LocalDateTime endDate, BigDecimal totalPrice) {
		// 대여 요청 처리
	}
	
        

	public void addRental(Rental rental) {
		// 필요하면 구현하기
	}

	public void updateRental(Rental rental) {
		// 필요하면 구현하기
	}

	public void deleteRental(String rentalId) {
		// 필요하면 구현하기
	}

	public void close() {
		// 필요하면 구현하기
	}
}
