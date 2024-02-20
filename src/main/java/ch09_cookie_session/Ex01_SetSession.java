package ch09_cookie_session;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ch09/setSession")
/* Session 이란?
> 웹 페이지들 사이의 공유정보를 서버 메모리에 저장 후 사용하는 방법

-특징은?
1. 정보가 서버의 메모리에 저장
2. 브라우저 세션 연동은 세션 쿠키 이용
3. 쿠키보다 보안에 유리
4. 서버에 부하를 줌
5. 브라우저(사용자)한 개의 세션(세션 id)가 생성된다.
6. 세선은 유효시간을 가지며 기본은 30분이며, 마지막으로 엑세스한 시점이다.
7. 로그인 상태 유지기능이나 쇼핑몰의 장바구니 담기 기능에 주로이용		  
*/
public class Ex01_SetSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//session 구하는법
		HttpSession session = request.getSession();
		
//		PrintWriter out = response.getWriter();
//		response.setContentType("text/html; charset=utf-8");
//		out.print("<h1>isNew: " + session.isNew());
		
		//값 세팅
		//모든게 다 들어가는것 => object 타입
		session.setAttribute("price", 12500);
		session.setAttribute("uid", "james");
		String[] fruits = {"apple", "banana", "cherry"};
		session.setAttribute("fruits", fruits);
		
		session.setMaxInactiveInterval(24 * 60 * 60);	//24h
		
//		session.invalidate();
		
//		response.getWriter().append("served at: ").append(request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher("/ch09/session.jsp");
		rd.forward(request, response);
	}
}
