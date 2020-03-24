package com.spring.ex03;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.spring.ex01.MemberVO;

public class MemberDAO3 {
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
}
