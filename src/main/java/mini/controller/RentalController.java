package mini.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mini.entity.Rental;
import mini.service.RentalService;
import mini.service.RentalServiceImpl;

@WebServlet({"/auction/rental/list", "/auction/rental/rent", "/auction/rental/return"})
public class RentalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RentalService rSvc = new RentalServiceImpl();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] uri = request.getRequestURI().split("/");
		String action = uri[uri.length - 1];
		String method = request.getMethod();
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
		String userId; // 유저 아이디
		String equipmentId; // 장비 아이디
		String rentalId; // 대여 아이디
		String msg; // 메시지
		String url; // 리다이렉트할 URL

		switch (action) {
		case "list":
			// 대여 목록 조회
			int page;
			String pageParam = request.getParameter("page");
			if (pageParam != null && !pageParam.isEmpty()) {
				page = Integer.parseInt(pageParam);
			} else {
				// 페이지 매개변수가 없는 경우 기본 페이지 번호를 사용
				page = 1;
			}
			List<Rental> rentalList = rSvc.getRentalList(page);
			request.setAttribute("rentalList", rentalList);
			// for pagination
			int totalRentals = rSvc.getRentalCount();
			int totalPages = (int) Math.ceil(totalRentals * 1.0 / rSvc.COUNT_PER_PAGE);
			List<String> pageList = new ArrayList<String>();
			for (int i = 1; i <= totalPages; i++) {
				pageList.add(String.valueOf(i));
			}
			request.setAttribute("pageList", pageList);

			rd = request.getRequestDispatcher("/WEB-INF/miniview/rental/list.jsp");
			rd.forward(request, response);
			break;

		case "rent":
			if (method.equals("GET")) {
				// 대여 페이지로 이동
				rd = request.getRequestDispatcher("/WEB-INF/miniview/rental/rent.jsp");
				rd.forward(request, response);
			} else {
				// 대여 요청 처리
				userId = (String) session.getAttribute("sessUid");
				equipmentId = request.getParameter("equipmentId");
				LocalDateTime startDate = LocalDateTime.now(); // 대여 시작 시간
				LocalDateTime endDate = LocalDateTime.parse(request.getParameter("endDate")); // 대여 종료 시간
				BigDecimal totalPrice = new BigDecimal(request.getParameter("totalPrice")); // 총 가격
				rSvc.rentItem(userId, equipmentId, startDate, endDate, totalPrice);
				msg = "장비를 대여하였습니다.";
				url = "/auction/rental/list?page=1";
				rd = request.getRequestDispatcher("/WEB-INF/miniview/common/alertMsg.jsp");
				request.setAttribute("msg", msg);
				request.setAttribute("url", url);
				rd.forward(request, response);
			}
			break;

		case "return":
			if (method.equals("GET")) {
				// 반납 페이지로 이동
				rd = request.getRequestDispatcher("/WEB-INF/miniview/rental/return.jsp");
				rd.forward(request, response);
			} else {
				// 반납 요청 처리
				rentalId = request.getParameter("rentalId");
				rSvc.returnItem(rentalId);
				msg = "장비를 반납하였습니다.";
				url = "/auction/rental/list?page=1";
				rd = request.getRequestDispatcher("/WEB-INF/miniview/common/alertMsg.jsp");
				request.setAttribute("msg", msg);
				request.setAttribute("url", url);
				rd.forward(request, response);
			}
			break;
		}
	}
}
