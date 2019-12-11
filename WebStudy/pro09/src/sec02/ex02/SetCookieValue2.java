package sec02.ex02;

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

@WebServlet("/set2")
public class SetCookieValue2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Cookie cookie = new Cookie("cookieTest", URLEncoder.encode("Cookie 테스트 프로그램 입니다", "UTF-8"));
		cookie.setMaxAge(-1);
		response.addCookie(cookie);
		
		Date date = new Date();
		out.print("쿠키 저장시간 : " + date);
	}
}
