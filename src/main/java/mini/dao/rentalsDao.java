package mini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import mini.entity.Rentals;

public class RentalsDao {
	public Connection getConnection() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/" + "jdbc/auction_db");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public String registerRental(String rental_id, String user_id, String equipment_id, LocalDateTime start_date,
			LocalDateTime end_date, int total_price, int payment_status) {
		Connection conn = getConnection();
		String registerAlert = "";
		String sql = "INSERT INTO rentals (rental_id, user_id, equipment_id, start_date, end_date, total_price, payment_status) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rental_id);
			pstmt.setString(2, user_id);
			pstmt.setString(3, equipment_id);
			pstmt.setObject(4, start_date);
			pstmt.setObject(5, end_date);
			pstmt.setInt(6, total_price);
			pstmt.setInt(7, payment_status);
			int rowsUpdated = pstmt.executeUpdate();
			if (rowsUpdated > 0) {
				registerAlert = "렌탈 등록이 완료되었습니다.";
			} else {
				registerAlert = "렌탈 등록에 실패하였습니다.";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "렌탈 등록 중 오류가 발생했습니다";
		}
		return registerAlert;
	}

	public void printRentalInfo(String rental_id, String user_id, String equipment_id) {
		Connection conn = getConnection();
		String sql = "SELECT * FROM rentals WHERE rental_id = ? AND user_id = ? AND equipment_id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rental_id);
			pstmt.setString(2, user_id);
			pstmt.setString(3, equipment_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void printRentalPeriod(LocalDateTime end_date, int total_price) {
		Connection conn = getConnection();
		String sql = "SELECT end_date, total_price FROM rentals WHERE end_date = ? AND total_price = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, end_date);
			pstmt.setInt(2, total_price);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void printRentalPrice(String rental_id) {
		Connection conn = getConnection();
		String sql = "SELECT total_price FROM rentals WHERE rental_id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rental_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void printRentalStatus(String rental_id) {
		Connection conn = getConnection();
		String sql = "SELECT payment_status FROM rentals WHERE rental_id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rental_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Rentals> getRentalsList() {
		Connection conn = getConnection();
		String sql = "SELECT * FROM rentals";
		List<Rentals> rentalsList = new ArrayList<Rentals>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rentalsList;
	}

	public void printRentalList() {
		Connection conn = getConnection();
		String sql = "SELECT * FROM rentals";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateRental(String rental_id, String user_id, String equipment_id, LocalDateTime start_date,
			LocalDateTime end_date, int total_price, int payment_status) {
		Connection conn = getConnection();
		String sql = "UPDATE rentals SET user_id = ?, equipment_id = ?, start_date = ?, end_date = ?, total_price = ?, payment_status = ? WHERE rental_id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setString(2, equipment_id);
			pstmt.setObject(3, start_date);
			pstmt.setObject(4, end_date);
			pstmt.setInt(5, total_price);
			pstmt.setInt(6, payment_status);
			pstmt.setString(7, rental_id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteRental(String rental_id) {
		Connection conn = getConnection();
		String sql = "DELETE FROM rentals WHERE rental_id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rental_id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Rentals getRentalList(String rental_id) {
		Connection conn = getConnection();
		String sql = "SELECT * FROM rentals WHERE rental_id = ?";
		Rentals rental = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rental_id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				rental = new Rentals(rs.getString("rental_id"), rs.getString("user_id"), rs.getString("equipment_id"),
						rs.getTimestamp("start_date").toLocalDateTime(), rs.getTimestamp("end_date").toLocalDateTime(),
						rs.getInt("total_price"), rs.getInt("payment_status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rental;
	}

}
