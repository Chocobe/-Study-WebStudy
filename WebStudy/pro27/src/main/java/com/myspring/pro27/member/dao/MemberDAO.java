package com.myspring.pro27.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.pro27.member.vo.MemberVO;


public interface MemberDAO {
	abstract public List<MemberVO> selectAllMemberList() throws DataAccessException;
	
	abstract public int insertMember(MemberVO memberVO) throws DataAccessException;
	
	abstract public int deleteMember(String id) throws DataAccessException;
	
	abstract public MemberVO loginById(MemberVO memberVO) throws DataAccessException;
}
