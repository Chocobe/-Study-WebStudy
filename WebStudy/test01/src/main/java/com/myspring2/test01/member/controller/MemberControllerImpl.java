package com.myspring2.test01.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring2.test01.member.service.MemberService;
import com.myspring2.test01.member.vo.MemberVO;

@Controller("memberController")
public class MemberControllerImpl implements MemberController {
	@Autowired private MemberService memberService;
	
	
	@Override
	@RequestMapping(value= "/member/membersList.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView membersList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		setEncoding(request);
		
		String viewName = getViewName(request);
		List<MemberVO> membersList = memberService.membersList();
		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("membersList", membersList);
		
		return mav;
	}
	
	
	@Override
	@RequestMapping(value= "/member/*Form.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String form(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		String viewName = getViewName(request);
		return viewName;
	}
	
	
	@Override
	@RequestMapping(value="/member/addMember.do", method= RequestMethod.POST)
	public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response,
								  @ModelAttribute("memberVO") MemberVO memberVO) throws Exception {
		setEncoding(request);
		
		String viewName = "redirect:/member/membersList.do";
		memberService.addMember(memberVO);
		
		return new ModelAndView(viewName);
	}
	
	
	@Override
	@RequestMapping(value= "/member/removeMember.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView removeMember(HttpServletRequest request, HttpServletResponse response, 
									 @RequestParam String id) throws Exception {
		setEncoding(request);
		
		String viewName = "redirect:/member/membersList.do";
		memberService.removeMember(id);
		
		return new ModelAndView(viewName);
	}
	
	
	private String getViewName(HttpServletRequest request) {
		String viewName = request.getServletPath();
		return viewName.replace(".do", "");
	}
	
	
	private void setEncoding(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
	}
}
