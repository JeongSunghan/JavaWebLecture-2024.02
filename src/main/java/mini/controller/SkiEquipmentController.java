package mini.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mini.entity.SkiEquipment;
import mini.service.SkiEquipmentService;
import mini.service.SkiEquipmentServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet({ "/SkiEquipment/list", "/SkiEquipment/register", "/SkiEquipment/update", "/SkiEquipment/delete",
		"/SkiEquipment/rent", "/SkiEquipment/return" })
public class SkiEquipmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SkiEquipmentService skiEquipmentService;

	public SkiEquipmentController() {
		skiEquipmentService = new SkiEquipmentServiceImpl();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] uri = request.getRequestURI().split("/");
		String action = uri[uri.length - 1];
		String method = request.getMethod();
		RequestDispatcher rd = null;

		switch (action) {
		case "list":
			// 스키 장비 리스트 페이지로 이동하는 기능 구현
			List<SkiEquipment> equipmentList = skiEquipmentService.getRentedSkiEquipmentList();
			request.setAttribute("equipmentList", equipmentList);
			rd = request.getRequestDispatcher("/mini/view/SkiEquipment/list.jsp");
			rd.forward(request, response);
			break;

		case "register":
			if (method.equals("GET")) {
				rd = request.getRequestDispatcher("/mini/view/SkiEquipment/register.jsp");
				rd.forward(request, response);
			} else {
				String equipment_id = request.getParameter("equipment_id");
				String user_id = request.getParameter("user_id");
				String equipment_name = request.getParameter("equipment_name");
				String description = request.getParameter("description");
				String condition = request.getParameter("condition");
				String image_url = request.getParameter("image_url");
				skiEquipmentService.registerSkiEquipment(equipment_id, user_id, equipment_name, description, condition,
						image_url);
				response.sendRedirect(request.getContextPath() + "/SkiEquipment/list");
			}
			break;

		case "update":
			if (method.equals("GET")) {
				// 수정할 스키 장비 정보를 가져와서 수정 페이지로 이동하는 기능 구현
				String equipment_id = request.getParameter("equipment_id");
				SkiEquipment skiEquipment = skiEquipmentService.getSkiEquipmentInfo(equipment_id);
				request.setAttribute("skiEquipment", skiEquipment);
				rd = request.getRequestDispatcher("/mini/view/SkiEquipment/update.jsp");
				rd.forward(request, response);
			} else {
				// 수정된 스키 장비 정보를 DB에 업데이트하는 기능 구현
				String equipment_id = request.getParameter("equipment_id");
				String user_id = request.getParameter("user_id");
				String equipment_name = request.getParameter("equipment_name");
				String description = request.getParameter("description");
				String condition = request.getParameter("condition");
				String image_url = request.getParameter("image_url");
				skiEquipmentService.updateSkiEquipment(equipment_id, user_id, equipment_name, description, condition,
						image_url);
				response.sendRedirect(request.getContextPath() + "/SkiEquipment/list");
			}
			break;
			
		case "delete":
			// 스키 장비 삭제 기능 구현
			String equipment_id = request.getParameter("equipment_id");
			skiEquipmentService.deleteSkiEquipment(equipment_id);
			response.sendRedirect(request.getContextPath() + "/SkiEquipment/list");
			break;

		case "rent":
			if (method.equals("POST")) {
				String equipment_id1 = request.getParameter("equipment_id");
				String user_id = request.getParameter("user_id");
				skiEquipmentService.addSkiEquipmentRental(equipment_id1, user_id);
				response.sendRedirect(request.getContextPath() + "/SkiEquipment/list");
			}
			break;

		case "return":
			if (method.equals("POST")) {
				String equipment_id1 = request.getParameter("equipment_id");
				String user_id = request.getParameter("user_id");
				skiEquipmentService.deleteSkiEquipmentRental(equipment_id1, user_id);
				response.sendRedirect(request.getContextPath() + "/SkiEquipment/list");
			}
			break;
		}
	}
}
