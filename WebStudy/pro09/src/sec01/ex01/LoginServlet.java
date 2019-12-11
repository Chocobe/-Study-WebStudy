package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	public void init() {
		System.out.println("init 메서드 호출");
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_address = request.getParameter("user_address");
		String user_email = request.getParameter("user_email");
		String user_ph = request.getParameter("user_ph");
		
		String data = "<html><body>";
		
		data += "안녕하세요!!<br/>";
		data += "로그인 하셨습니다</br></br>";
		
		data += "아이디 : " + user_id + "<br/>";
		data += "패스워드 : " + user_pw + "<br/>";
		data += "주소 : " + user_address + "</br>";
		data += "이메일 : " + user_email + "<br/>";
		data += "휴대전화 : " + user_ph + "</br>";
		
		data += "</body></html>";
		
		out.print(data);
		
		out.close();
	}
	
	
	@Override
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}
}
