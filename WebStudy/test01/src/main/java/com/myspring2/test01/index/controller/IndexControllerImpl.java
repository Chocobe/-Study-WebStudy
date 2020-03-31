package com.myspring2.test01.index.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("indexController")
public class IndexControllerImpl implements IndexController {
	@Override
	@RequestMapping(value= "/index.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = "/index";
		return new ModelAndView(viewName);
	}
}
