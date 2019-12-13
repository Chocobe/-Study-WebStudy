#	pro10

>	요청주소에 대한 정보 - sec02.ex01

	```java
	String context = request.getContextPath();
	
	// context값은 에플리케이션의 경로값(매핑값)이 된다.
	// 예 : "/pro10"
	```
	
	```java
	String mapping = request.getServletPath();
	
	// mapping값은 요청한 서블릿의 경로값(매핑값)이 된다.
	// 예 : "/first/test"
	```
	
	```java
	String url = request.getRequestURL();
	
	// url값은 요청한 전체 주소값(URL)이 된다.
	// 예 : "http://127.0.0.1/8090/pro10/first/test"
	```
	
	```java
	String uri = request.getRequestURI();
	
	// uri값은 요청한 URI값이 된다.
	// 예 : "/pro10/first/test"
	
---

>	서블릿의 "url-pattern" 방식 - sec02.ex01

	1. 대상 지정
	``@WebServlet("/first/test")``
	
	1. 경로 지정
	``@WebServlet("/first/*")``
	
	1. 확장자 지정
	``@WebServlet("*.do")``
	
---

>	서블릿 필터 - sec03.ex01

	* ``HttpServletRequest``객체의 ``setCharacterEncoding("UTF-8");``를 사용하여 인코딩을 설정할 수 있다.
	
	* 요청에 대한 응답에 걸린 소요시간을 산출 할 수 있다.
	
	```java
	@WebFilter("/*")
	public class EncodingFilter implements Filter {
		@Override
		public void init(FilterConfig config) { }
		
		@Override
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
					throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			long beginTime = System.currentTimeMillis();
			
			chain.doFilter(request, response);
			
			long endTime = System.currentTimeMillis();
			System.out.println("경과시간 : " + (endTime - beginTime) + "ms");
		}
		
		@Override
		public void destroy() { }
	}
	```
	
---

>	서블릿 리스너 - sec04

	*	예제가 구림.. 참조하지 말 것