package com.spring.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.member.vo.MemberVO;

public interface MemberDAO {
	abstract public List<MemberVO> selectAllMemberList() throws DataAccessException;
	
	abstract public int insertMember(MemberVO memberVO) throws DataAccessException;
	
	abstract public int deleteMember(String id) throws DataAccessException;
}
