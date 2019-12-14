#	pro12

>	hello.jsp - 선언문(JSP 스크립트 요소)

*	```jsp
	<%! 
		String name = "Duke";
		
		public String getName() {
			return name;
		}
	%>
	```

*	스크립트 선언문을 사용한 변수는, 이 JSP가 변환된 Servlet 클래스의 맴버변수로 생성된다.

*	스크립트 선언문을 사용한 메서드 역시 이 JSP가 변환된 Servlet 클래스의 메서드로 생성된다.

---

>	hello2.jsp - 표현식(JSP 스크립트릿)

*	```java
	<%
		String age = "11";
	%>
	```
	
*	표현식으로 만든 변수는 JSP가 Servlet으로 변환된 ``_jspService_()``메서드의 지역변수로 생성된다.

*	표현식 내부에서 연산이 가능하고, 세미콜론(;)은 사용하지 않는다.