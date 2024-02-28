package mini.dao;

import mini.entity.SkiEquipment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class SkiEquipmentDao {
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

    public SkiEquipment getSkiEquipmentInfo(String equipment_id) {
        Connection conn = getConnection();
        String sql = "SELECT * FROM ski_equipment WHERE equipment_id = ?";
        SkiEquipment skiEquipment = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, equipment_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                skiEquipment = new SkiEquipment();
                skiEquipment.setEquipment_id(rs.getString("equipment_id"));
                skiEquipment.setUser_id(rs.getString("user_id"));
                skiEquipment.setEquipment_name(rs.getString("equipment_name"));
                skiEquipment.setDescription(rs.getString("description"));
                skiEquipment.setCondition(rs.getString("condition"));
                skiEquipment.setImage_url(rs.getString("image_url"));
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return skiEquipment;
    }

    public String getSkiEquipmentCondition(String equipment_id) {
        Connection conn = getConnection();
        String sql = "SELECT condition FROM ski_equipment WHERE equipment_id = ?";
        String condition = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, equipment_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                condition = rs.getString("condition");
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return condition;
    }

    public SkiEquipment getSelectedSkiEquipment(String equipment_id, String equipment_name) {
        Connection conn = getConnection();
        String sql = "SELECT * FROM ski_equipment WHERE equipment_id = ? AND equipment_name = ?";
        SkiEquipment skiEquipment = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, equipment_id);
            pstmt.setString(2, equipment_name);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                skiEquipment = new SkiEquipment();
                skiEquipment.setEquipment_id(rs.getString("equipment_id"));
                skiEquipment.setUser_id(rs.getString("user_id"));
                skiEquipment.setEquipment_name(rs.getString("equipment_name"));
                skiEquipment.setDescription(rs.getString("description"));
                skiEquipment.setCondition(rs.getString("condition"));
                skiEquipment.setImage_url(rs.getString("image_url"));
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return skiEquipment;
    }

    public List<SkiEquipment> getSkiRentalList() {
        Connection conn = getConnection();
        String sql = "SELECT * FROM ski_equipment WHERE user_id IS NOT NULL";
        List<SkiEquipment> rentalList = new ArrayList<>();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                SkiEquipment skiEquipment = new SkiEquipment();
                skiEquipment.setEquipment_id(rs.getString("equipment_id"));
                skiEquipment.setUser_id(rs.getString("user_id"));
                skiEquipment.setEquipment_name(rs.getString("equipment_name"));
                skiEquipment.setDescription(rs.getString("description"));
                skiEquipment.setCondition(rs.getString("condition"));
                skiEquipment.setImage_url(rs.getString("image_url"));
                rentalList.add(skiEquipment);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rentalList;
    }

    public List<SkiEquipment> getUserRentedSkiEquipment(String user_id) {
        Connection conn = getConnection();
        String sql = "SELECT * FROM ski_equipment WHERE user_id = ?";
        List<SkiEquipment> rentedEquipmentList = new ArrayList<>();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                SkiEquipment skiEquipment = new SkiEquipment();
                skiEquipment.setEquipment_id(rs.getString("equipment_id"));
                skiEquipment.setUser_id(rs.getString("user_id"));
                skiEquipment.setEquipment_name(rs.getString("equipment_name"));
                skiEquipment.setDescription(rs.getString("description"));
                skiEquipment.setCondition(rs.getString("condition"));
                skiEquipment.setImage_url(rs.getString("image_url"));
                rentedEquipmentList.add(skiEquipment);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rentedEquipmentList;
    }

    public boolean isSkiEquipmentAvailable(String equipment_id) {
        Connection conn = getConnection();
        String sql = "SELECT * FROM ski_equipment WHERE equipment_id = ? AND user_id IS NULL";
        boolean isAvailable = false;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, equipment_id);
            ResultSet rs = pstmt.executeQuery();
            isAvailable = rs.next(); // 해당 장비가 존재하면 대여 가능
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAvailable;
    }

    public void autoReturnExpiredSkiEquipment() {
        Connection conn = getConnection();
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addSkiEquipmentRental(String equipment_id, String user_id) {
        Connection conn = getConnection();
        String sql = "UPDATE ski_equipment SET user_id = ? WHERE equipment_id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user_id);
            pstmt.setString(2, equipment_id);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteSkiEquipmentRental(String equipment_id, String user_id) {
        Connection conn = getConnection();
        String sql = "UPDATE ski_equipment SET user_id = NULL WHERE equipment_id = ? AND user_id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, equipment_id);
            pstmt.setString(2, user_id);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<SkiEquipment> getRentedSkiEquipmentList() {
        Connection conn = getConnection();
        String sql = "SELECT * FROM ski_equipment WHERE user_id IS NOT NULL";
        List<SkiEquipment> rentedEquipmentList = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                SkiEquipment equipment = new SkiEquipment();
                equipment.setEquipment_id(rs.getString("equipment_id"));
                equipment.setUser_id(rs.getString("user_id"));
                equipment.setEquipment_name(rs.getString("equipment_name"));
                equipment.setDescription(rs.getString("description"));
                equipment.setCondition(rs.getString("condition"));
                equipment.setImage_url(rs.getString("image_url"));
                System.out.println(equipment);
                rentedEquipmentList.add(equipment);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rentedEquipmentList;
    }

    // 스키 장비 등록
    public void registerSkiEquipment(String equipment_id, String user_id, String equipment_name, String description,
                                     String condition, String image_url) {
        Connection conn = getConnection();
        String sql = "INSERT INTO ski_equipment (equipment_id, user_id, equipment_name, description, `condition`, image_url) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, equipment_id);
            pstmt.setString(2, user_id);
            pstmt.setString(3, equipment_name);
            pstmt.setString(4, description);
            pstmt.setString(5, condition);
            pstmt.setString(6, image_url);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateSkiEquipment(String equipment_id, String user_id, String equipment_name, String description,
                                    String condition, String image_url) {
        Connection conn = getConnection();
        String sql = "UPDATE ski_equipment SET user_id = ?, equipment_name = ?, description = ?, `condition` = ?, image_url = ? "
                + "WHERE equipment_id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user_id);
            pstmt.setString(2, equipment_name);
            pstmt.setString(3, description);
            pstmt.setString(4, condition);
            pstmt.setString(5, image_url);
            pstmt.setString(6, equipment_id);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteSkiEquipment(String equipment_id) {
        Connection conn = getConnection();
        String sql = "DELETE FROM ski_equipment WHERE equipment_id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, equipment_id);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
