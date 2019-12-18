package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajaxTest2")
public class AjaxTest2 extends HttpServlet {
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
		
		String result = "";
		result = "<main>" +
				 "<book>" +
				 "<title><![CDATA[초보자를 위한 자바 프로그래밍]]></title>" +
				 "<writer><![CDATA[인포북스 저 | 이병승]]></writer>" +
				 "<image><![CDATA[http://localhost:8090/pro16/image/image1.jpg]]></image>" +
				 "</book>" +
				 "<book>" +
				 "<title><![CDATA[모두의 파이썬]]></title>" +
				 "<writer><![CDATA[길벗 저 | 이승찬]]></writer>" +
				 "<image><![CDATA[http://localhost:8090/pro16/image/image2.jpg]]></image>" +
				 "</book>" +
				 "</main>";
		
		System.out.println("result : " + result);
		out.print(result);
		
		out.close();
	}
}
