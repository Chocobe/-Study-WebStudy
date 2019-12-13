package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/set")
public class SetAttribute extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String contextMessage = "context에 바인딩 됩니다";
		String sessionMessage = "session에 바인딩 됩니다";
		String requestMessage = "request에 바인딩 됩니다";
		
		ServletContext context = getServletContext();
		HttpSession session = request.getSession();
		
		context.setAttribute("contextMessage", contextMessage);
		session.setAttribute("sessionMessage", sessionMessage);
		request.setAttribute("requestMessage", requestMessage);
		
		out.print("바인딩을 수행 합니다");
		
		out.close();
	}
}
