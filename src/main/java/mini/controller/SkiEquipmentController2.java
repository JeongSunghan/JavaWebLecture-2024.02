package mini.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import mini.entity.SkiEquipment;
import mini.service.SkiEquipmentService;
import mini.service.SkiEquipmentServiceImpl;

@WebServlet("/auction_db/ski_equipment/list")
public class SkiEquipmentController2 extends HttpServlet {
	private SkiEquipmentService skiEquipmentService;
	

	public void init() throws ServletException {
		skiEquipmentService = new SkiEquipmentServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action == null) {
			action = "list"; // 기본 액션
		}

		switch (action) {
		case "list":
			listSkiEquipment(request, response);
			break;
		case "register":
			registerSkiEquipment(request, response);
			break;
		case "delete":
			deleteSkiEquipment(request, response);
			break;
		// 다른 액션에 대한 추가 케이스 작성!!
		default:
			listSkiEquipment(request, response);
		}
	}

	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // 폼 데이터 가져오기
	        String equipment_id = request.getParameter("equipment_id");
	        String user_id = request.getParameter("user_id");
	        String equipment_name = request.getParameter("equipment_name");
	        String description = request.getParameter("description");
	        String condition = request.getParameter("condition");
	        String image_url = request.getParameter("image_url");

	        // 장비 ID가 null이 아닌 경우에만 등록 수행
	        if (equipment_id != null && !equipment_id.isEmpty()) {
	            // 스키 장비 등록 서비스 호출
	            SkiEquipmentService skiEquipmentService = new SkiEquipmentServiceImpl();
	            skiEquipmentService.registerSkiEquipment(equipment_id, user_id, equipment_name, description, condition, image_url);

	            // 등록 후 목록 페이지로 리다이렉트
	            response.sendRedirect(request.getContextPath() + "/SkiEquipment/list");
	        } else {
	            // 장비 ID가 null일 경우 
	            response.setContentType("text/html");
	            PrintWriter out = response.getWriter();
	            out.println("<html><head><title>Error</title></head><body>");
	            out.println("<h2>장비 ID를 입력하세요.</h2>");
	            out.println("</body></html>");
	        }
	    }

	private void listSkiEquipment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<SkiEquipment> equipmentList = skiEquipmentService.getRentedSkiEquipmentList();
		request.setAttribute("equipmentList", equipmentList);
		request.getRequestDispatcher("/WEB-INF/view/SkiEquipment/list.jsp").forward(request, response);
	}

	private void deleteSkiEquipment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String equipment_id = request.getParameter("equipment_id");
		skiEquipmentService.deleteSkiEquipment(equipment_id);
		response.sendRedirect(request.getContextPath() + "/SkiEquipmentController?action=list");
	}

	private void registerSkiEquipment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String equipment_id = request.getParameter("equipment_id");
		String user_id = request.getParameter("user_id");
		String equipment_name = request.getParameter("equipment_name");
		String description = request.getParameter("description");
		String condition = request.getParameter("condition");
		String image_url = request.getParameter("image_url");
		skiEquipmentService.registerSkiEquipment(equipment_id, user_id, equipment_name, description, condition,
				image_url);
		
		response.sendRedirect(request.getContextPath() + "/SkiEquipmentController?action=list");
	}
}
