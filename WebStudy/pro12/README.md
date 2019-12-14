#	hello.jsp - 선언문(JSP 스크립트 요소)

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