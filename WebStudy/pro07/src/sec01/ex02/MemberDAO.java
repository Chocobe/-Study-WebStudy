package sec01.ex02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	private static final String DRIVER;
	private static final String ID;
	private static final String PWD;
	private static final String URL;
	
	static {
		DRIVER = "com.mysql.jdbc.Driver";
		ID = "root";
		PWD = "1111";
		URL = "jdbc:mysql://127.0.0.1:3306/SERVLET_PRACTICE";
	}
	
	
	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			connDB();
			
			String sql = "SELECT * FROM T_MEMBER";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
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
			Class.forName(DRIVER);
			System.out.println("MySQL 드라이버 로딩 완료");
			
			conn = DriverManager.getConnection(URL, ID, PWD);
			System.out.println("Connection 생성 성공");
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
