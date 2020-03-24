package com.spring.ex02;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO2 {
	private static SqlSessionFactory sqlMapper = null;
	
	
	public SqlSessionFactory getInstance() {
		if(sqlMapper == null) {
			Reader reader = null;
			
			try {
				String resource = "/mybatis/SqlMapConfig.xml";
				reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				
				reader.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return sqlMapper;
	}
	
	
	public String selectName() {
		sqlMapper = getInstance();
		SqlSession sqlSession = sqlMapper.openSession();
		
		return sqlSession.selectOne("mapper.member.selectName");
	}
	
	
	public String selectPwd() {
		sqlMapper = getInstance();
		SqlSession sqlSession = sqlMapper.openSession();
		
		return sqlSession.selectOne("mapper.member.selectPwd");
	}
}
