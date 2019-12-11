package sec02.ex02;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first5")
public class FirstServlet5 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("second5?name=Hello");
		
		dispatcher.forward(request, response);
	}
}
