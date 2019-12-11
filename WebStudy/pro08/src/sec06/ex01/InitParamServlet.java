package sec06.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = { 
				"/sInit", 
				"/sInit2"
		}, 
		initParams = { 
				@WebInitParam(name = "email", value = "admin@jweb.com"), 
				@WebInitParam(name = "tel", value = "010-1111-2222")
		})
public class InitParamServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String email = getServletConfig().getInitParameter("email");
		String tel = getServletConfig().getInitParameter("tel");
		
		out.print("<html>");
		out.print("<body>");
		out.print("<table>");
		
		out.print("<tr>");
		out.print("<td>email : " + email + "</td>");
		out.print("</tr>");
		
		out.print("<tr>");
		out.print("<td>휴대전화 : " + tel + "</td>");
		out.print("</tr>");
		
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}
}
