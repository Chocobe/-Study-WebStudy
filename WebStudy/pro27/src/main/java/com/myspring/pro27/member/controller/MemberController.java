package com.myspring.pro27.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.pro27.member.vo.MemberVO;


public interface MemberController {
	abstract public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	abstract public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response, MemberVO memberVO) throws Exception;
	
	abstract public ModelAndView removeMember(HttpServletRequest request, HttpServletResponse response, String id) throws Exception;
	
	abstract public ModelAndView form(HttpServletRequest request, HttpServletResponse response, String result) throws Exception;
	
	abstract public ModelAndView login(HttpServletRequest request, HttpServletResponse response, RedirectAttributes rAttr, MemberVO memberVO) throws Exception;
	
	abstract public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
