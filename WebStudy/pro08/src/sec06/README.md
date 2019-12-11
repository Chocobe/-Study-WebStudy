#	sec06 - ServletConfig의 초기 파라메터 지정하기

>	어노테이션으로 초기 파라메터 지정하기

	```java
	@WebServlet(
		urlPatterns = {
			"/sInit",
			"/sInit2"
		},
		
		initParams = {
			@WebInitParam(name="email", value="admin@jweb.com"),
			@WebInitParam(name="tel", value="010-1111-2222")
		}
	)
	public class InitParamServlet {}
	```
	
---

>	``web.xml``에서 초기 파라메터 지정하기

	```xml
	<servlet>
		<servlet-name>sInit</servlet-name>
		<servlet-class>sec06.ex01.InitParamServlet</servlet-class>
		
		<init-param>
			<param-name>email</param-name>
			<param-value>admin@jweb.com</param-value>
		</init-param>
		
		<init-param>
			<param-name>tel</param-name>
			<param-value>010-1111-2222</param-value>
		</init-param>
	</servlet>
	
	<servlet-mapping>
		<servlet-name>sInit</servlet-name>
		<url-pattern>/sInit</url-pattern>
	</servlet-mapping>
	
	<servlet-mapping>
		<servlet-name>sInit</servlet-name>
		<url-pattern>/sInit2</url-pattern>
	</servlet-mapping>
	```