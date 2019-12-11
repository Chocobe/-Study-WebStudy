package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		
		out.print("<html>");
		out.print("<body>");
		out.print("sendRedirect를 이용한 redirect 실습 입니다<br/>");
		out.print("GET 방식의 질의문자열 - name : " + name);
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}
}
