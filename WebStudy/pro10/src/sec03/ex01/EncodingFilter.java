package sec03.ex01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class EncodingFilter implements Filter {
	private ServletContext context;
	
	
	@Override
	public void init(FilterConfig config) {
		System.out.println("UTF-8 인코딩 ...");
		context = config.getServletContext();
	}
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
					throws ServletException, IOException {
		System.out.println("doFilter 메서드 호출");
		request.setCharacterEncoding("UTF-8");
		
		String context = ((HttpServletRequest)request).getContextPath();
		String pathInfo = ((HttpServletRequest)request).getRequestURI();
		String realPath = ((HttpServletRequest)request).getServletContext().getRealPath(pathInfo);
		
		String message = "Context 정보 : " + context + "\n" +
						 "URI 정보 : " + pathInfo + "\n" +
						 "물리적 경로 : " + realPath;
		System.out.println(message);
		
		long beginTime = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("작업시간 : " + (endTime - beginTime) + "ms");
	}
	
	
	@Override
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}
}
