package ch10_filter;

import jakarta.servlet.Filter;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@WebFilter("")
public class LoginCheckFilter extends HttpFilter implements Filter {
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();
        String sessUid = (String) session.getAttribute("sessUid");
        
        //로그인을 하지 않았으면
        if (sessUid == null || sessUid.equals("")) {
            // 응답이 커밋되지 않았는지 확인
            if (!httpResponse.isCommitted()) {
                // forward 를 수행하기 위해 RequestDispatcher를 사용
                RequestDispatcher rd = request.getRequestDispatcher("/ch09/user/login");
                rd.forward(request, response);
                return; 
                // forward 를 했으므로 다음 필터로 넘어가지 않도록 리턴
                
            } else {
                // 응답이 이미 커밋된 경우에는 더 이상 수정할 수 없으므로 예외 처리 등을 수행
                throw new ServletException("응답이 이미 커밋되었습니다. forward를 수행할 수 없습니다.");
            }
        }
        
        chain.doFilter(request, response);
    }
}
