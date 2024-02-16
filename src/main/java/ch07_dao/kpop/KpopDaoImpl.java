package ch07_dao.kpop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class KpopDaoImpl implements KpopDao {
	Connection conn = getConnection();
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/" + "jdbc/world");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	@Override
	public List<Kpop> getKpopList() {
		Connection conn = getConnection();
		String sql = "SELECT g.*, s.title, s.lyrics FROM girl_group g"
					+ "  JOIN song s ON g.hit_song_id=s.sid"
					+ "  ORDER BY gid desc";
		List<Kpop> list = new ArrayList<Kpop>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Kpop kpop = new Kpop(rs.getInt(1), rs.getString(2),
						LocalDate.parse(rs.getString(3)), rs.getInt(4),
						rs.getString(5), rs.getString(6));
				list.add(kpop);
			}
			rs.close(); stmt.close(); conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public Artist getArtist(int aid) {
		conn = getConnection();
		return null;
	}

	@Override
	public Song getSong(int sid) {
		conn = getConnection();
		return null;
	}

	@Override
	public void insertArtist(Artist artist) {
		conn = getConnection();		
	}

	@Override
	public void insertSong(Song song) {
		conn = getConnection();
	}
		

	@Override
	public void updateArtist(Artist artist) {
		conn = getConnection();	
	}

	@Override
	public void updateSong(Song song) {
		conn = getConnection();		
	} 

	@Override
	public void deleteArtist(int aid) {
		conn = getConnection();		
	}

	@Override
	public void deleteSong(int sid) {
		conn = getConnection();		

	}
}

