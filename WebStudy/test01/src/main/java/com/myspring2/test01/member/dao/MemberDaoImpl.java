package com.myspring2.test01.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring2.test01.member.vo.MemberVO;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {
	@Autowired private SqlSession sqlSession;
	
	
	@Override
	public List<MemberVO> selectAllMemberList() throws DataAccessException {
		return sqlSession.selectList("mapper.member.selectAllMemberList");
	}
	
	
	@Override
	public int insertMember(MemberVO memberVO) throws DataAccessException {
		return sqlSession.insert("mapper.member.insertMember", memberVO);
	}
	
	
	@Override
	public int deleteMember(String id) throws DataAccessException {
		return sqlSession.delete("mapper.member.deleteMember", id);
	}
}
