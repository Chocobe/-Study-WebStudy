package com.spring.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface MemberController {
	abstract public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception;
	abstract public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response) throws Exception;
	abstract public ModelAndView removeMember(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
