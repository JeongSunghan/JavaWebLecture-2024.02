package ch07_dao.kpop;

import java.util.List;

public interface KpopDao {
	//sql 연결

	List<Kpop> getKpopList();

	Artist getArtist(int aid);
	
	Song getSong(int sid);

	void insertArtist(Artist artist);

	void insertSong(Song song);

	void updateArtist(Artist artist);

	void updateSong(Song song);

	void deleteArtist(int aid);

	void deleteSong(int sid);
}
