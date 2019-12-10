package sec04.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/guguTest2")
public class GuguTest2 extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("init 메서드 호출");
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int dan = Integer.parseInt(request.getParameter("dan"));
		
		out.print("<table border='1' width='800' align='center'>");
		out.print("<tr align='center' bgcolor='#FFFF66'>");
		out.print("<td colspan='2'>" + dan + " 단 출력</td>");
		out.print("</tr>");
		
		for(int i = 1; i < 10; i++) {
			if(i % 2 == 0) {
				out.print("<tr align='center' bgcolor='#ACFA58'>");
				
			} else {
				out.print("<tr align='center' bgcolor='#81BEF7'>");
			}
			
			out.print("<td width='400'>");
			out.print(dan + " * " + i);
			out.print("</td>");
			
			out.print("<td width='400'>");
			out.print(dan * i);
			out.print("</td>");
			
			out.print("</tr>");
		}
		
		out.print("</table>");
		out.close();
	}
	
	
	@Override
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}
}
