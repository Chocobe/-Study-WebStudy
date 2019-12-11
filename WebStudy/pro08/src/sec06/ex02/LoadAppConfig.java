package sec06.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		name="loadConfig", urlPatterns= { "/loadConfig" }, loadOnStartup=1
		)
public class LoadAppConfig extends HttpServlet {
	private ServletContext context;

	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LoadAppConfig의 init 메서드 호출");
		
		context = config.getServletContext();
		
		String menu_member = context.getInitParameter("menu_member");
		String menu_order = context.getInitParameter("menu_order");
		String menu_goods = context.getInitParameter("menu_goods");
		
		context.setAttribute("menu_member", menu_member);
		context.setAttribute("menu_order", menu_order);
		context.setAttribute("menu_goods", menu_goods);
	}

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String menu_member = (String)context.getAttribute("menu_member");
		String menu_order = (String)context.getAttribute("menu_order");
		String menu_goods = (String)context.getAttribute("menu_goods");
		
		out.print("<html>");
		out.print("<body>");
		out.print("<table border='1' cellspacing='0'>");
		
		out.print("<tr>");
		out.print("<td>메뉴이름</td>");
		out.print("</tr>");
		
		out.print("<tr>");
		out.print("<td>" + menu_member + "</td>");
		out.print("<td>" + menu_order + "</td>");
		out.print("<td>" + menu_goods + "</td>");
		out.print("</tr>");
		
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}
}
