package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	@Override
	public void init() {
		System.out.println("init 메서드 호출");
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_address = request.getParameter("user_address");
		
		out.print("<html><body>");
		
		if(user_id != null && user_id.length() != 0) {
			out.print("이미 로그인 상태입니다!!<br/><br/>");
			out.print("첫 번째 서블릿에서 넘겨준 아이디 : " + user_id + "<br/>");
			out.print("첫 번째 서블릿에서 넘겨준 비밀번호 : " + user_pw + "<br/>");
			out.print("첫 번째 서블릿에서 넘겨준 주소 : " + user_address + "<br/>");
			
		} else {
			out.print("로그인 하지 않았습니다<br/><br/>");
			out.print("다시 로그인 하세요!!<br/>");
			out.print("<a href='/pro09/login.html'>로그인 창으로 이동하기</a>");
		}
		
		out.print("</body></html>");
		
		out.close();
	}
	
	
	@Override
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}
}
