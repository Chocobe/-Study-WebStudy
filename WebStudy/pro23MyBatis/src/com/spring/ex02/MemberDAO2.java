package com.spring.ex02;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO2 {
	private static SqlSessionFactory sqlMapper = null;
	
	public static SqlSessionFactory getInstance() {
		Reader reader = null;
		
		if(sqlMapper == null) {
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
	
	
	public String selectName() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		return session.selectOne("mapper.member.selectName");
	}
	
	
	public String selectPwd() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		return session.selectOne("mapper.member.selectPwd");
	}
}
