package ch07_dao.kpop;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class KpopTest
 */

@WebServlet({"/ch07/Kpop/list", "/ch07/kpop/insertArtist", "/ch07/kpop/insertSong", 
	"/ch07/kpop/updateArtist", "/ch07/kpop/updateSong", "/ch07/kpop/deleteArtist", "/ch07/kpop/deleteSong"})
public class KpopTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KpopDao kDao = new KpopDaoImpl();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestUri = request.getRequestURI();
		String[] uri = requestUri.split("/");
		String action = uri[uri.length - 1];
		String method = request.getMethod();
		RequestDispatcher rd = null;
		Artist artist = null;
		Song song = null;
		int aid = 0, sid = 0;
		String name = null, debut = null, title = null, lyrics = null;
		
		switch(action) {
		case "list" :
			List<Kpop> list = kDao.getKpopList();
			rd = request.getRequestDispatcher("/ch07/kpop/list.jsp");
			request.setAttribute("list", list);
			rd.forward(request, response);
			break;
		}
	}

}
