package com.spring.ex04;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.spring.ex01.MemberVO;

public class MemberDAO4 {
	private static SqlSessionFactory sqlSessionFactory;
	
	
	private SqlSessionFactory getInstance() {
		if(sqlSessionFactory == null) {
			Reader reader = null;
			
			try {
				String resource = "/mybatis/SqlMapConfig.xml";
				reader = Resources.getResourceAsReader(resource);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
				
				reader.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return sqlSessionFactory;
	}
	
	
	public List<MemberVO> selectAllMemberList() {
		sqlSessionFactory = getInstance();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		return sqlSession.selectList("mapper.member.selectAllMemberList");
	}
	
	
	public MemberVO selectMemberById(String id) {
		sqlSessionFactory = getInstance();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		return sqlSession.selectOne("mapper.member.selectMemberById", id);
	}
	
	
	public List<MemberVO> selectMemberByPwd(String pwd) {
		sqlSessionFactory = getInstance();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		return sqlSession.selectList("mapper.member.selectMemberByPwd", pwd);
	}
	
	
	public int insertMember(MemberVO memberVO) {
		sqlSessionFactory = getInstance();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int result = sqlSession.insert("mapper.member.insertMember", memberVO);
		sqlSession.commit();
		
		return result;
	}
	
	
	public int insertMember2(Map<String, String> memberMap) {
		sqlSessionFactory = getInstance();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int result = sqlSession.insert("mapper.member.insertMember2", memberMap);
		sqlSession.commit();
		
		return result;
	}
	
	
	public int updateMember(MemberVO memberVO) {
		sqlSessionFactory = getInstance();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int result = sqlSession.update("mapper.member.updateMember", memberVO);
		sqlSession.commit();
		
		return result;
	}
	
	
	public int deleteMember(String id) {
		sqlSessionFactory = getInstance();
		SqlSession session = sqlSessionFactory.openSession();
		
		int result = session.delete("mapper.member.deleteMember", id);
		session.commit();
		
		return result;
	}
	
	
	public List<MemberVO> searchMember(MemberVO memberVO) {
		sqlSessionFactory = getInstance();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		return sqlSession.selectList("mapper.member.searchMember2", memberVO);
	}
	
	
	public List<MemberVO> foreachSelect(List<String> nameList) {
		sqlSessionFactory = getInstance();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		return sqlSession.selectList("mapper.member.foreachSelect", nameList);
	}
}
