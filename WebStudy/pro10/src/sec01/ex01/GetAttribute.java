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

@WebServlet("/get")
public class GetAttribute extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext();
		HttpSession session = request.getSession();
		
		String contextMessage = (String)context.getAttribute("contextMessage");
		String sessionMessage = (String)session.getAttribute("sessionMessage");
		String requestMessage = (String)request.getAttribute("requestMessage");
		
		out.print("ServletContext message : " + contextMessage + "<br/>");
		out.print("HttpSession message : " + sessionMessage + "<br/>");
		out.print("Request Message : " + requestMessage + "<br/>");
		
		out.close();
	}
}
