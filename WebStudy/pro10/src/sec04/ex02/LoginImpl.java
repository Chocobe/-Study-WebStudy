package sec04.ex02;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class LoginImpl implements HttpSessionListener {
	private String user_id;
	private String user_pw;
	private static int totalUser = 0;
	
	public LoginImpl() { }
	
	public LoginImpl(String user_id, String user_pw) {
		this.user_id = user_id;
		this.user_pw = user_pw;
	}
	
	
	public static int getTotalUser() {
		return totalUser;
	}
	
	
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("세션 생성");
		totalUser++;
	}
	
	
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("세션 소멸");
		totalUser--;
	}
}
