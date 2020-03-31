package com.myspring.pro27.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.pro27.member.vo.MemberVO;


public interface MemberService {
	abstract public List<MemberVO> listMembers() throws DataAccessException;
	
	abstract public int addMember(MemberVO memberVO) throws DataAccessException;
	
	abstract public int removeMember(String id) throws DataAccessException;
	
	abstract public MemberVO login(MemberVO memberVO) throws DataAccessException;
}
