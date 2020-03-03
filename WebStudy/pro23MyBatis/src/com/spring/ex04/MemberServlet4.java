package com.spring.ex04;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.spring.ex01.MemberVO;

@WebServlet("/mem4.do")
public class MemberServlet4 extends HttpServlet {
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
		
		String action = request.getParameter("action");
		String nextPage = "";
		
		MemberDAO4 dao = new MemberDAO4();
		
		if(action == null || action.equals("listMembers")) {
			List<MemberVO> membersList = dao.selectAllMemberList();
			request.setAttribute("membersList", membersList);
			
			nextPage = "test01/listMembers.jsp";
			
		} else if(action.equals("selectMemberById")) {
			String id = request.getParameter("value");
			MemberVO memberVO = dao.selectMemberById(id);
			request.setAttribute("member", memberVO);
			
			nextPage = "test02/memberInfo.jsp";
			
		} else if(action.equals("selectMemberByPwd")) {
			String pwd = request.getParameter("value");
			List<MemberVO> membersList = dao.selectMemberByPwd(pwd);
			request.setAttribute("membersList", membersList);
			
			nextPage = "test01/listMembers.jsp";
			
		} else if(action.equals("insertMember")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			MemberVO memberVO = new MemberVO();
			memberVO.setId(id);
			memberVO.setPwd(pwd);
			memberVO.setName(name);
			memberVO.setEmail(email);
			
			dao.insertMember(memberVO);
			
			nextPage = "/mem4.do?action=listMembers";
			
		} else if(action.equals("insertMember2")) {
			Map<String, String> memberMap = new HashMap<String, String>();
			memberMap.put("id", request.getParameter("id"));
			memberMap.put("pwd", request.getParameter("pwd"));
			memberMap.put("name", request.getParameter("name"));
			memberMap.put("email", request.getParameter("email"));
			
			dao.insertMember2(memberMap);
			
			nextPage = "/mem4.do?action=listMembers";
			
		} else if(action.equals("updateMember")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			MemberVO memberVO = new MemberVO();
			memberVO.setId(id);
			memberVO.setPwd(pwd);
			memberVO.setName(name);
			memberVO.setEmail(email);
			
			dao.updateMember(memberVO);
			
			nextPage = "/mem4.do?action=listMembers";
			
		} else if(action.equals("deleteMember")) {
			String id = request.getParameter("id");
			dao.deleteMember(id);
			
			nextPage = "/mem4.do?action=listMembers";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}
}
