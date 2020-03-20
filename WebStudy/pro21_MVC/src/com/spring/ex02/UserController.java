package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController {
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userID = "";
		String password = "";
		
		String viewName = getMyViewName(request);
				
		ModelAndView mav = new ModelAndView();
		
		request.setCharacterEncoding("UTF-8");
		
		userID = request.getParameter("userID");
		password = request.getParameter("password");
		
		mav.addObject("userID", userID);
		mav.addObject("password", password);
		
		//mav.setViewName("result");
		mav.setViewName(viewName);
		System.out.println("ViewName : " + viewName);
		
		return mav;
	}
	
	
	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ModelAndView mav = new ModelAndView();
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		mav.addObject("id", id);
		mav.addObject("pwd", pwd);
		mav.addObject("name", name);
		mav.addObject("email", email);
		
		mav.setViewName("memberInfo");
		
		return mav;
	}
	
	
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getMyViewName(request);
		ModelAndView mav = new ModelAndView(viewName);
		
		return mav;
	}
	
	
	private String getMyViewName(HttpServletRequest request) throws Exception {
		String servletPath = request.getServletPath();
		String viewName = servletPath.replace(".do", "");
		
		int lastSlashIdx = viewName.lastIndexOf("/");
		viewName = viewName.substring(lastSlashIdx);
		
		return viewName;
	}
}
