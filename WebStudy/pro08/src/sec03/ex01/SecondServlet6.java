package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second6")
public class SecondServlet6 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String address = (String)request.getAttribute("address");
		
		out.print("<html>");
		out.print("<body>");
		out.print("주소 : " + address + "<br/>");
		out.print("redirect를 이용한 바인딩 실습 입니다");
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}
}
