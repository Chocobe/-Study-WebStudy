package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cget")
public class GetServletContext extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext();
		
		@SuppressWarnings("unchecked")
		List<String> member = (ArrayList<String>)context.getAttribute("member");
		String name = member.get(0);
		String age = member.get(1);
		
		out.print("<html>");
		out.print("<body>");
		out.print("이름 : " + name + "<br/>");
		out.print("나이 : " + age + "<br/>");
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}
}
