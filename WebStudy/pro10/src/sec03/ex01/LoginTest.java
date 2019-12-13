package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginTest extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String user_name = request.getParameter("user_name");
		String user_pw = request.getParameter("user_pw");
		
		out.print("<html>");
		out.print("<body>");
		out.print("이름는 : " + user_name + "<br/>");
		out.print("비밀번호는 : " + user_pw + "<br/>");
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}
}
