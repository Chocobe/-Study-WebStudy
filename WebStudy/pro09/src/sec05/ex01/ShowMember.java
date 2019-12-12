package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/show")
public class ShowMember extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			boolean isLogon = (Boolean)session.getAttribute("isLogon");
			
			if(isLogon) {
				String id = (String)session.getAttribute("login.id");
				String pw = (String)session.getAttribute("login.pwd");
				
				out.print("<html>");
				out.print("<body>");
				out.print("아이디 : " + id + "<br/>");
				out.print("비밀번호 : " + pw + "<br/>");
				out.print("</body>");
				out.print("</html>");
				
			} else {
				response.sendRedirect("login3.html");
			}
			
		} else {
			response.sendRedirect("login3.html");
		}
	}
}
