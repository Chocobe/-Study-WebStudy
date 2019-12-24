package board01;

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

public class BoardDAO {
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
	
	public BoardDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup(RESOURCE_DIR);
			dataSource = (DataSource)envContext.lookup(RESOURCE_NAME);
			
		} catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<ArticleVO> selectAllArticles() {
		List<ArticleVO> articlesList = new ArrayList<ArticleVO>();
		
		try {
			String sql = "SELECT articleNO, parentNO, title, content, id, writeDate " +
							"FROM t_board " +
							"ORDER BY articleNO DESC";
			
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			resultSet = pstmt.executeQuery();
			
			while(resultSet.next()) {
				ArticleVO article = new ArticleVO();
				article.setArticleNO(resultSet.getInt("articleNO"));
				article.setParentNO(resultSet.getInt("parentNO"));
				article.setTitle(resultSet.getString("title"));
				article.setContent(resultSet.getString("content"));
				article.setId(resultSet.getString("id"));
				article.setWriteDate(resultSet.getDate("writeDate"));
				
				articlesList.add(article);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(conn, pstmt, resultSet);
		}
		
		return articlesList;
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
























