package com.myspring2.test01.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.myspring2.test01.member.dao.MemberDao;
import com.myspring2.test01.member.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired MemberDao memberDao;
	
	
	@Override
	public List<MemberVO> membersList() throws DataAccessException {
		return memberDao.selectAllMemberList();
	}
	
	
	@Override
	public int addMember(MemberVO memberVO) throws DataAccessException {
		return memberDao.insertMember(memberVO);
	}
	
	
	@Override
	public int removeMember(String id) throws DataAccessException {
		return memberDao.deleteMember(id);
	}
}
