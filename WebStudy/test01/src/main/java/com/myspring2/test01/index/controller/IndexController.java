package com.myspring2.test01.index.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface IndexController {
	
	abstract public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
