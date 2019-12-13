package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout3")
public class LogoutTest extends HttpServlet {
	private ServletContext context;
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		doHandle(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		doHandle(request, response);
	}
	
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		context = getServletContext();
		HttpSession session = request.getSession();
		
		String user_id = request.getParameter("user_id");
		session.invalidate();
		
		@SuppressWarnings("unchecked")
		List<String> userList = (List<String>)context.getAttribute("userList");
		
		userList.remove(user_id);
		context.removeAttribute("userList");
		context.setAttribute("userList", userList);
		
		out.print("<br/>로그아웃 되었습니다");
	}
}
