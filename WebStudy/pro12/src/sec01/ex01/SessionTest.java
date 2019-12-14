package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sess")
public class SessionTest extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		session.setAttribute("name", "이순신");
		
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>세션에 이름을 바인딩 합니다</h1>");
		out.print("<a href='/pro12/test01/session1.jsp'>첫 번째 페이지로 이동하기</a>");
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}
}
