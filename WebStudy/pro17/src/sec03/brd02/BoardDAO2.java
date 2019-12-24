package sec03.brd02;

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


public class BoardDAO2 {
	private DataSource dataSource;
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet resultSet;
	
	private static final String RESOURCE_DIR;
	private static final String RESOURCE_NAME;
	
	static {
		RESOURCE_DIR = "java:/comp/env";
		RESOURCE_NAME = "jdbc/study/mysql";
	}
	
	
	public BoardDAO2() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup(RESOURCE_DIR);
			dataSource = (DataSource)envContext.lookup(RESOURCE_NAME);
			
		} catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	public void insertNewArticle(ArticleVO2 article) {
		try {
			int articleNO = getNewArticleNO();
			int parentNO = article.getParentNO();
			String title = article.getTitle();
			String content = article.getContent();
			String id = article.getId();
			String imageFileName = article.getImageFileName();
			
			String sql = "INSERT INTO t_board(articleNO, parentNO, title, content, id, imageFileName) " +
						 "VALUES(?, ?, ?, ?, ?, ?)";
			
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, articleNO);
			pstmt.setInt(2, parentNO);
			pstmt.setString(3, title);
			pstmt.setString(4, content);
			pstmt.setString(5, id);
			pstmt.setString(6, imageFileName);
			
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(conn, pstmt);
		}
	}
	
	
	private int getNewArticleNO() {
		int result = 1;
		
		try {
			String sql = "SELECT COUNT(*) FROM t_board";
			
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			resultSet = pstmt.executeQuery();
			
			if(resultSet.next()) {
				result += resultSet.getInt(1);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(conn, pstmt, resultSet);
		}
		
		return result;
	}
	
	
	private void close(Connection conn, PreparedStatement pstmt, ResultSet resultSet) {
		try {
			if(resultSet != null) {
				resultSet.close();
				close(conn, pstmt);
			}
			
		} catch(SQLException e) {
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




























