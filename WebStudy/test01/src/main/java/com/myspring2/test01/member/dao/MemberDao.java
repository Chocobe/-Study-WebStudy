package com.myspring2.test01.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring2.test01.member.vo.MemberVO;

public interface MemberDao {
	
	abstract public List<MemberVO> selectAllMemberList() throws DataAccessException;
	
	abstract public int insertMember(MemberVO memberVO) throws DataAccessException;
	
	abstract public int deleteMember(String id) throws DataAccessException;
}
