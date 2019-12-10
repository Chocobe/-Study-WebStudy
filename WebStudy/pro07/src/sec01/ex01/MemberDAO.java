package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MemberDAO {
	private Connection conn;
	private Statement ps;
	private ResultSet rs;
	
	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			connDB();
			
			String sql = "SELECT * FROM T_MEMBER";
			System.out.println("SQL : " + sql);
			
			ps = conn.createStatement();
			rs = ps.executeQuery(sql);
			
			while(rs.next()) {
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				String email = rs.getString("EMAIL");
				Date joinDate = rs.getDate("JOIN_DATE");
				
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				
				list.add(vo);
			}
			
			rs.close();
			ps.close();
			conn.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	private void connDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("MySQL 드라이버 로딩 완료");
			
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/SERVLET_PRACTICE", "root", "1111");
			System.out.println("Connection 생성 성공");
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
