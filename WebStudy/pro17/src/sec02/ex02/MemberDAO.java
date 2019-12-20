package sec02.ex02;

import java.sql.Connection;
import java.sql.Date;
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
		List<MemberVO> membersList = new ArrayList<MemberVO>();
		
		try {
			String sql = "SELECT * FROM T_MEMBER ORDER BY JOIN_DATE DESC";
			
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				String email = rs.getString("EMAIL");
				Date joinDate = rs.getDate("JOIN_DATE");
				
				MemberVO memberVO = new MemberVO(id, pwd, name, email, joinDate);
				
				membersList.add(memberVO);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(conn, pstmt, rs);
		}
		
		return membersList;
	}
	
	
	public void addMember(MemberVO memberVO) {
		try {
			String sql = "INSERT INTO T_MEMBER(ID, PWD, NAME, EMAIL) VALUES(?, ?, ?, ?)";
			
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPwd());
			pstmt.setString(3, memberVO.getName());
			pstmt.setString(4, memberVO.getEmail());
			
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(conn, pstmt);
		}
	}
	
	
	public MemberVO findMember(String inputID) {
		MemberVO memInfo = null;
		
		try {
			String sql = "SELECT * FROM T_MEMBER WHERE ID=?";
			
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inputID);
			
			System.out.println(sql);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String name = rs.getString("NAME");
			String email = rs.getString("EMAIL");
			Date joinDate = rs.getDate("JOIN_DATE");
			
			memInfo = new MemberVO(id, pwd, name, email, joinDate);
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(conn, pstmt, rs);
		}
		
		return memInfo;
	}
	
	
	public void modMember(MemberVO memberVO) {
		try {
			String sql = "UPDATE T_MEMBER SET PWD=?, NAME=?, EMAIL=? WHERE ID=?";
			
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberVO.getPwd());
			pstmt.setString(2, memberVO.getName());
			pstmt.setString(3, memberVO.getEmail());
			pstmt.setString(4, memberVO.getId());
			
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(conn, pstmt, rs);
		}
	}
	
	
	public void delMember(String id) {
		try {
			String sql = "DELETE FROM T_MEMBER WHERE ID=?";
			
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(conn, pstmt);
		}
	}
	
	
	private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
			
			close(conn, pstmt);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void close(Connection conn, PreparedStatement pstmt) {
		try {
			if(pstmt != null) {
				pstmt.close();
			}
			
			close(conn);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void close(Connection conn) {
		try {
			if(conn != null) {
				conn.close();
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}