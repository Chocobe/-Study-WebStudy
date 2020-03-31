package com.myspring.pro27.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.pro27.member.service.MemberService;
import com.myspring.pro27.member.vo.MemberVO;


@Controller("memberController")
public class MemberControllerImpl implements MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberControllerImpl.class);
	
	@Autowired private MemberService memberService;
	@Autowired private MemberVO memberVO;
	
	
	@Override
	@RequestMapping(value= "/member/listMembers.do", method= RequestMethod.GET)
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		logger.info("info 레벨 : viewName = " + viewName);
		logger.debug("debug 레벨 : viewName = " + viewName);
		
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
