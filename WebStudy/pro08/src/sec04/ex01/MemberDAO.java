package sec04.ex01;

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
	
	
	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			String sql = "SELECT * FROM T_MEMBER";
			
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				
				vo.setId(rs.getString("ID"));
				vo.setPwd(rs.getString("PWD"));
				vo.setName(rs.getString("NAME"));
				vo.setEmail(rs.getString("EMAIL"));
				vo.setJoinDate(rs.getDate("JOIN_DATE"));
				
				list.add(vo);
			}
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public void addMember(MemberVO memberVO) {
		try {
			String sql = "INSERT INTO T_MEMBER(ID, PWD, NAME, EMAIL)" +
						 "VALUES(?, ?, ?, ?)";
			
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPwd());
			pstmt.setString(3, memberVO.getName());
			pstmt.setString(4, memberVO.getEmail());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void delMember(String id) {
		try {
			String sql = "DELETE FROM T_MEMBER WHERE ID=?";
			
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
