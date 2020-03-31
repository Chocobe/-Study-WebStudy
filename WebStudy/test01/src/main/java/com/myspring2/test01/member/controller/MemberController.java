package com.myspring2.test01.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.myspring2.test01.member.vo.MemberVO;

public interface MemberController {
	
	abstract public ModelAndView membersList(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	abstract public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response, MemberVO memberVO) throws Exception;
	
	abstract public ModelAndView removeMember(HttpServletRequest request, HttpServletResponse response, String id) throws Exception;
	
	abstract public String memberJoinForm(HttpServletRequest request) throws Exception;
}
