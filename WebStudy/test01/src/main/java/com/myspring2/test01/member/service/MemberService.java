package com.myspring2.test01.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring2.test01.member.vo.MemberVO;

public interface MemberService {
	abstract public List<MemberVO> membersList() throws DataAccessException;
	
	abstract public int addMember(MemberVO memberVO) throws DataAccessException;
	
	abstract public int removeMember(String id) throws DataAccessException;
}
