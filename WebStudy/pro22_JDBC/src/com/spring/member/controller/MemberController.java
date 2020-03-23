package com.spring.member.controller;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public interface MemberController {
	abstract public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
