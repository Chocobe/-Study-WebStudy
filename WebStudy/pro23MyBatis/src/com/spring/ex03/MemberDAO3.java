package com.spring.ex03;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.spring.ex01.MemberVO;

public class MemberDAO3 {
	private static SqlSessionFactory sqlMapper = null;
	
	
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
				if(reader != null) { try { reader.close(); } catch(Exception e) {} }
			}
		}
		
		return sqlMapper;
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
}
