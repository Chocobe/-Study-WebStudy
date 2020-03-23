package com.spring.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.member.service.MemberService;
import com.spring.member.vo.MemberVO;

public class MemberControllerImpl extends MultiActionController implements MemberController {
	private MemberService memberService;
	
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
	@Override
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView(viewName);
		
		List<MemberVO> membersList = memberService.listMembers();
		mav.addObject("membersList", membersList);
		
		return mav;
	}
	
	
	private String getViewName(HttpServletRequest request) throws Exception {
		String servletPath = request.getServletPath();
		return servletPath.replace(".do", "");
	}
}
