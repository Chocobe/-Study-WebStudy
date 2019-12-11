package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/set")
public class SetCookieValue extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Date date = new Date();
		
		Cookie cookie = new Cookie("cookieTest", URLEncoder.encode("JSP 프로그래밍 입니다", "UTF-8"));
		cookie.setMaxAge(60 * 60 * 24);
		
		response.addCookie(cookie);
		
		out.print("현재시간 : " + date + "<br/>");
		out.print("현재시간을 Cookie로 저장 합니다");
		
		out.close();
	}
}
