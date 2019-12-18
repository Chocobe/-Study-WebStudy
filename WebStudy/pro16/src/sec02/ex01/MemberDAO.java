package sec02.ex01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	public boolean overlappedID(String id) {
		boolean result = true;
		
		try {
			String sql = "SELECT COUNT(*) AS RESULT FROM T_MEMBER WHERE ID=?";
			
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			if(rs.getString("RESULT").equals("0")) {
				result = false;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	
	private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			
				close(conn, pstmt);
			}
			
		}	catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	private void close(Connection conn, PreparedStatement pstmt) {
		try {
			if(pstmt != null) {
				pstmt.close();
				
				close(conn);
			}
			
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
