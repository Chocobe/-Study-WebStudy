package sec02.ex01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {
	private DataSource dataSource;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static final String RESOURCE_DIR;
	private static final String RESOURCE_NAME;
	
	static {
		RESOURCE_DIR = "java:/comp/env";
		RESOURCE_NAME = "jdbc/study/mysql";
	}
	
	
	public MemberDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup(RESOURCE_DIR);
			dataSource = (DataSource)envContext.lookup(RESOURCE_NAME);
			
		} catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<MemberVO> listMembers(MemberVO memberVO) {
		List<MemberVO> list = new ArrayList<MemberVO>();
		String requestName = memberVO.getName();
		
		try {
			String sql = "SELECT * FROM T_MEMBER";
			conn = dataSource.getConnection();
			
			if(requestName != null && requestName.length() != 0) {
				sql += " WHERE NAME=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memberVO.getName());
				
			} else {
				pstmt = conn.prepareStatement(sql);
			}
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO curMemberVO = new MemberVO();
				
				curMemberVO.setId(rs.getString("ID"));
				curMemberVO.setPwd(rs.getString("PWD"));
				curMemberVO.setName(rs.getString("NAME"));
				curMemberVO.setEmail(rs.getString("EMAIL"));
				curMemberVO.setJoinDate(rs.getDate("JOIN_DATE"));
				
				list.add(curMemberVO);
			}
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
