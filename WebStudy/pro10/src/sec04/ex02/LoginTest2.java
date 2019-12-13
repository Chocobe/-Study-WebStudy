package sec04.ex02;

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
import javax.servlet.http.HttpSession;

@WebServlet("/login3")
public class LoginTest2 extends HttpServlet {
	private ServletContext context;
	List<String> userList = new ArrayList<String>();
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		context = getServletContext();
		HttpSession session = request.getSession();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		LoginImpl loginUser = new LoginImpl(user_id, user_pw);
		
		if(session.isNew()) {
			session.setAttribute("loginUser", loginUser);
			userList.add(user_id);
			
			if(context.getAttribute("userList") != null) {
				System.out.println("(이전)userList 개수 : " + ((List<String>)context.getAttribute("userList")).size());
			}
			context.setAttribute("userList", userList);
			System.out.println("(이후)userList 개수 : " + ((List<String>)context.getAttribute("userList")).size());
		}
		
		out.print("<html>");
		out.print("<body>");
		out.print("아이디는 : " + user_id + "<br/><br/>");
		out.print("현재 접속 아이디 : <br/>");
		
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>)context.getAttribute("userList");
		System.out.println("userList의 데이터 개수 : " + list.size());
		
		for(int i = 0; i < list.size(); i++) {
			out.print(list.get(i) + "<br/>");
		}
		
		out.print("<a href='logout3?user_id=" + user_id + "'>로그아웃</a>");
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}
}
