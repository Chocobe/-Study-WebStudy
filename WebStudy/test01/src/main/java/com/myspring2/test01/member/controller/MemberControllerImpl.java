package com.myspring2.test01.member.controller;

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

import com.myspring2.test01.ControllerUtils;
import com.myspring2.test01.member.service.MemberService;
import com.myspring2.test01.member.vo.MemberVO;

@Controller("memberController")
public class MemberControllerImpl implements MemberController {
	private static Logger logger = LoggerFactory.getLogger(MemberControllerImpl.class);
	
	@Autowired private MemberService memberService;
	
	
	@Override
	@RequestMapping(value= "/member/membersList.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView membersList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = ControllerUtils.getViewName(request);
		List<MemberVO> membersList = memberService.membersList();
		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("membersList", membersList);

		logger.info("viewName : " + viewName);
		
		return mav;
	}
	
	
	@Override
	@RequestMapping(value="/member/addMember.do", method= RequestMethod.POST)
	public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response, 
								  @ModelAttribute MemberVO memberVO) throws Exception {
		String viewName = "redirect:/member/membersList.do";
		memberService.addMember(memberVO);
		
		logger.info("viewName : " + viewName);
		
		return new ModelAndView(viewName);
	}
	
	
	@Override
	@RequestMapping(value= "/member/removeMember.do", method= RequestMethod.GET)
	public ModelAndView removeMember(HttpServletRequest request, HttpServletResponse response, 
									 @RequestParam String id) throws Exception {
		String viewName = "redirect:/member/membersList.do";
		memberService.removeMember(id);
		
		logger.info("viewName : " + viewName);
		
		return new ModelAndView(viewName);
	}
	
	
	@Override
	@RequestMapping(value= "/member/memberJoinForm.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String memberJoinForm(HttpServletRequest request) throws Exception {
		return ControllerUtils.getViewName(request);
	}
}
