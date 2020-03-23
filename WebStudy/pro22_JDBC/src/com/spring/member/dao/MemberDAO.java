package com.spring.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.member.vo.MemberVO;

public interface MemberDAO {
	abstract public List<MemberVO> selectAllMembers() throws DataAccessException;
	abstract public int addMember(MemberVO memberVO) throws DataAccessException;
}
