package com.spring.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.member.vo.MemberVO;

public interface MemberDAO {
	abstract List<MemberVO> selectAllMemberList() throws DataAccessException;
	abstract int insertMember(MemberVO memberVO) throws DataAccessException;
	abstract int deleteMember(String id) throws DataAccessException;
}
