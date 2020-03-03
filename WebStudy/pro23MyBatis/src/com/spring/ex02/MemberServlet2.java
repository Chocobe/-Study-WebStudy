package com.spring.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mem2")
public class MemberServlet2 extends HttpServlet {
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
		
		MemberDAO2 dao = new MemberDAO2();
		String name = dao.selectName();
		String pwd = dao.selectPwd();
		
		PrintWriter out = response.getWriter();
		
		out.print("<script>");
		out.print("alert('이름 : " + name + ", 비밀번호 : " + pwd + "');");
		out.print("</script>");
	}
}
