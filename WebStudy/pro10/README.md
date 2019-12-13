#	pro10

>	요청주소에 대한 정보

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

>	서블릿의 "url-pattern" 방식

	1. 대상 지정
	``@WebServlet("/first/test")``
	
	1. 경로 지정
	``@WebServlet("/first/*")``
	
	1. 확장자 지정
	``@WebServlet("*.do")``