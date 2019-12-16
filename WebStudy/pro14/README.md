#	pro14 - EL과 JSTL

>	elTest : EL예제

*	``${empty 변수}`` : ``null``이거나 ``""(빈 문자열)``일 경우 ``true``반환
	
*	``${not empty 변수}`` : ``${empty}``의 반대
	
*	``${empty 변수}``의 변수에 ``ArrayList``객체가 들어갈 경우, 저장된 요소가 없으면 ``true``를 반환한다.
	
---

>	EL 내장객체

*	질의문자열 내장객체 (param)
	
	```jsp
	<!-- 아래 두 문장은 동일한 동작을 한다. -->
	
	<% request.getParameter("myParam"); %>
		
	${param.myParam}
	```