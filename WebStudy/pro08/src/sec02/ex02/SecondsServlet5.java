package sec02.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second5")
public class SecondsServlet5 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		
		out.print("<html>");
		out.print("<body>");
		out.print("dispatch를 이용하여 GET방식의 질의문자열 forward 실습 입니다<br/>");
		out.print("name : " + name);
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}
}
