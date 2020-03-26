package com.spring.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.member.vo.MemberVO;

public interface MemberService {
	abstract public List<MemberVO> listMembers() throws DataAccessException;
	abstract public int addMember(MemberVO memberVO) throws DataAccessException;
	abstract public int removeMember(String id) throws DataAccessException;
}
