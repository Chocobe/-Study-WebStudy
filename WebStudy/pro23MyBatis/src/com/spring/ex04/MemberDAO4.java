package com.spring.ex04;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.spring.ex01.MemberVO;

public class MemberDAO4 {
	private static SqlSessionFactory sqlMapper;
	
	public static SqlSessionFactory getInstance() {
		if(sqlMapper == null) {
			Reader reader = null;
			
			try {
				String resource = "mybatis/SqlMapConfig.xml";
				reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				
			} catch(Exception e) {
				e.printStackTrace();
				
			} finally {
				if(reader != null) { try { reader.close(); } catch(IOException e) {} }
			}
		}
		
		return sqlMapper;
	}
	
	
	public List<MemberVO> searchMember(MemberVO memberVO) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<MemberVO> list = session.selectList("mapper.member.searchMember", memberVO);
		
		return list;
	}
	
	
	public List<MemberVO> selectAllMemberList() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		return session.selectList("mapper.member.selectAllMemberList");
	}
	
	
	public MemberVO selectMemberById(String id) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		return session.selectOne("mapper.member.selectMemberById", id);
	}
	
	
	public List<MemberVO> selectMemberByPwd(String pwd) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		return session.selectList("mapper.member.selectMemberByPwd", pwd);
	}
	
	
	public int insertMember(MemberVO memberVO) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		int result = session.insert("mapper.member.insertMember", memberVO);
		session.commit();
		
		return result;
	}
	
	
	public int insertMember2(Map<String, String> memberMap) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		int result = session.insert("mapper.member.insertMember2", memberMap);
		session.commit();
		
		return result; 
	}
	
	
	public int updateMember(MemberVO memberVO) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		int result = session.update("mapper.member.updateMember", memberVO);
		session.commit();
		
		return result;
	}
	
	
	public int deleteMember(String id) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		int result = session.delete("mapper.member.deleteMember", id);
		session.commit();
		
		return result;
	}
	
	
	public List<MemberVO> foreachSelect(List<String> nameList) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		return session.selectList("mapper.member.foreachSelect", nameList);
	}
}
