package mini.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mini.entity.Rentals;
import mini.service.RentalService;
import mini.service.RentalServiceImpl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet({"/rental/list", "/rental/register", "/rental/update", "/rental/delete"})
public class RentalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RentalService rentalService;

	public RentalController() {
		super();
		rentalService = new RentalServiceImpl();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] uri = request.getRequestURI().split("/");
		String action = uri[uri.length - 1];
		String method = request.getMethod();
		request.getSession();
		RequestDispatcher rd = null;
		String rental_id = "", user_id = "", equipment_id = "";
		LocalDateTime start_date, end_date;
		int total_price, payment_status;

		switch (action) {
		case "list":
			List<Rentals> rentalList = rentalService.getRentalList();
			request.setAttribute("rentalList", rentalList);
			rd = request.getRequestDispatcher("/mini/view/rental/list.jsp");
			rd.forward(request, response);
			break;

		// register => insert 와 비슷합니다
		case "register":
			if (method.equals("GET")) {
				rd = request.getRequestDispatcher("/mini/view/rental/register.jsp");
				rd.forward(request, response);
			} else {
				rental_id = request.getParameter("rental_id");
				user_id = request.getParameter("user_id");
				equipment_id = request.getParameter("equipment_id");
				start_date = LocalDateTime.parse(request.getParameter("start_date"));
				end_date = LocalDateTime.parse(request.getParameter("end_date"));
				total_price = Integer.parseInt(request.getParameter("total_price"));
				payment_status = Integer.parseInt(request.getParameter("payment_status"));
				rentalService.registerRental(rental_id, user_id, equipment_id, start_date, end_date, total_price,
						payment_status);
				response.sendRedirect(request.getContextPath() + "/rental/list");
			}
			break;

		case "update":
			if (method.equals("GET")) {
				rental_id = request.getParameter("rental_id");
				Rentals rental = rentalService.getRentalList(rental_id);
				request.setAttribute("rental", rental);
				rd = request.getRequestDispatcher("/mini/view/rental/update.jsp");
				rd.forward(request, response);
			} else {
				rental_id = request.getParameter("rental_id");
				user_id = request.getParameter("user_id");
				equipment_id = request.getParameter("equipment_id");
				start_date = LocalDateTime.parse(request.getParameter("start_date"));
				end_date = LocalDateTime.parse(request.getParameter("end_date"));
				total_price = Integer.parseInt(request.getParameter("total_price"));
				payment_status = Integer.parseInt(request.getParameter("payment_status"));
				rentalService.updateRental(rental_id, user_id, equipment_id, start_date, end_date, total_price,
						payment_status);
				response.sendRedirect(request.getContextPath() + "/rental/list");
			}
			break;

		case "delete":
			rental_id = request.getParameter("rental_id");
			rentalService.deleteRental(rental_id);
			response.sendRedirect(request.getContextPath() + "/rental/list");
			break;
		}
	}
}