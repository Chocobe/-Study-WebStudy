package com.spring.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.member.dao.MemberDAO;
import com.spring.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO;
	
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	
	public List<MemberVO> listMembers() throws DataAccessException {
		return memberDAO.selectAllMembers();
	}
}
