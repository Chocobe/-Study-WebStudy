package sec01.ex01;

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
	
	
	public void addMember(MemberBean memberBean) {
		try {
			String sql = "INSERT INTO T_MEMBER(ID, PWD, NAME, EMAIL) VALUES(?, ?, ?, ?)";
			
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberBean.getId());
			pstmt.setString(2, memberBean.getPwd());
			pstmt.setString(3, memberBean.getName());
			pstmt.setString(4, memberBean.getEmail());
			
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(conn, pstmt);
		}
	}
	
	
	public List<MemberBean> listMembers() {
		List<MemberBean> list = new ArrayList<MemberBean>();
		
		try {
			String sql = "SELECT * FROM T_MEMBER";
			
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberBean curBean = new MemberBean();
				
				curBean.setId(rs.getString("ID"));
				curBean.setPwd(rs.getString("PWD"));
				curBean.setName(rs.getString("NAME"));
				curBean.setEmail(rs.getString("EMAIL"));
				curBean.setJoinDate(rs.getDate("JOIN_DATE"));
				
				list.add(curBean);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(conn, pstmt, rs);
		}
		
		return list;
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
