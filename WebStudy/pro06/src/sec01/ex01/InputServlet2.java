package sec01.ex01;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/input2")
public class InputServlet2 extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("init 메서드 호출");
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Enumeration<String> names = request.getParameterNames();
		
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			String[] values = request.getParameterValues(name);
			
			for(String value : values) {
				System.out.println("name : " + name + ", value : " + value);
			}
		}
	}
	
	
	@Override
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}
}