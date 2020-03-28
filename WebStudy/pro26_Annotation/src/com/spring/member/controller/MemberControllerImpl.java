package com.spring.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.member.service.MemberService;
import com.spring.member.vo.MemberVO;

@Controller("memberController")
public class MemberControllerImpl implements MemberController {
	@Autowired private MemberService memberService;
	@Autowired private MemberVO memberVO;
	
	
	@Override
	@RequestMapping(value= "/member/listMembers.do", method= RequestMethod.GET)
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		List<MemberVO> membersList = memberService.listMembers();
		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("membersList", membersList);
		
		return mav;
	}
	
	
	@Override
	@RequestMapping(value= "/member/addMember.do", method= RequestMethod.POST)
	public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response, 
								  @ModelAttribute("member") MemberVO memberVO) throws Exception {
		memberService.addMember(memberVO);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		
		return mav;
	}
	
	
	@Override
	@RequestMapping(value= "/member/removeMember.do", method= RequestMethod.GET)
	public ModelAndView removeMember(HttpServletRequest request, HttpServletResponse response, 
									 @RequestParam("id") String id) throws Exception {
		memberService.removeMember(id);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		
		return mav;
	}
	
	
	@Override
	@RequestMapping(value= "/member/*Form.do", method= RequestMethod.GET)
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView(viewName);
		
		return mav;
	}
	
	
	private String getViewName(HttpServletRequest request) {
		String viewName = request.getServletPath();
		return viewName.replace(".do", "");		
	}
}
