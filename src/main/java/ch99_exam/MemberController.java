package ch99_exam;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/exam/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//뉴욕, 시카고, 런던, 한국 
		Member m1 = new Member(1, "정성한", 25, "한국");
		Member m2 = new Member(2, "말왕", 32, "한국");
		Member m3 = new Member(3, "사케", 14, "일본");
		Member m4 = new Member(4, "사라", 19, "미국");
		Member m5 = new Member(5, "칭따오", 21, "중국");
		Member m6 = new Member(6, "트런들", 81, "미국");
		Member m7 = new Member(7, "페이커", 30, "한국");
		
	
		
		Member[] members = {m1, m2, m3, m4, m5 ,m6, m7};
		request.setAttribute("members", members);

		RequestDispatcher rd = request.getRequestDispatcher("/examview/mList.jsp");
		rd.forward(request, response);
	}
}
