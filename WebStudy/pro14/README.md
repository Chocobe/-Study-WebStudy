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
	
---

>	JSTL - CORE

*	JSTL은 표준 액션태그 라고 한다.
	
*	**변수 지원**, **제어문**, **반복문**, **URL처리**를 위한 JSTL이다.

	```jsp
	<!-- 변수 생성하기 -->
	<c:set var="변수명" value="값" scope="스코프값"/>
	
	<!-- 변수 삭제하기 -->
	<c:remove var="변수명" scope="스코프값"/>
	
	<!-- 단일 조건문(if) -->
	<c:if test="조건" var="결과값을 저장할 변수명">
	</c:if>
	
	<!-- switch또는 if else 조건문 -->
	<c:choose>
		<c:when test="조건">
		</c:when>
		
		<c:otherwise>
		</c:otherwise>
	</c:choose>
	
	<!-- 반복문 -->
	<c:forEach var="변수" items="반복할 배열 또는 Collections객체" begin="시작인덱스" end="끝인덱스" step="반복문의 스텝값" varStatus="반복문 상태변수">
	</c:forEach>
	
	<!-- 반복문(토큰 - 문자열 잘라내기 기능을 가진 반복문) -->
	<c:forTokens var="변수" items="반복할 문자열" delims="문자열을 나눌 문자">
	</c:forTokens>
	
	<!-- url처리 -->
	<c:url var="변수명" value="url값">
		<c:param name="파라메터명" value="값"/>
	</c:url>
	<a href="${변수명}">이동</a>
	<!-- 해당 URL로 설정한 파라메터까지 함께 이동한다 -->
	
	<!-- redirect -->
	<c:redirect url="url값">
		<c:param name="변수명" value="값"/>
	</c:redirect>
	<!-- request.sendRedirect() 메서드와 동일한 동작을 한다 -->
	
	<!-- out -->
	<c:out value="출력할 값" default="값이 없을경우 출력할 기본값" escapeXml="true"/>
	<!-- escapeXml의 값은 특수문자 출력을 위한 escape문자 변환 여부를 설정한다. - 기본값:true(escape문자 사용함) -->	
	```