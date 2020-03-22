package com.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UrlResolver extends MultiActionController {
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("/views/index");
	}
	
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("/views/loginForm");
	}
	
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("id", id);
		mav.addObject("pwd", pwd);
		mav.addObject("name", name);
		
		mav.setViewName("/views/login");
		
		return mav;
	}
}
