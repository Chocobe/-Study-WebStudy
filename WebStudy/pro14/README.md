#	pro14 - EL과 JSTL

##	elTest : EL예제

*	``${empty 변수}`` : ``null``이거나 ``""(빈 문자열)``일 경우 ``true``반환
	
*	``${not empty 변수}`` : ``${empty}``의 반대
	
*	``${empty 변수}``의 변수에 ``ArrayList``객체가 들어갈 경우, 저장된 요소가 없으면 ``true``를 반환한다.
	
---

##	EL 내장객체

*	질의문자열 내장객체 (param)
	
	```jsp
	<!-- 아래 두 문장은 동일한 동작을 한다. -->
	
	<% request.getParameter("myParam"); %>
		
	${param.myParam}
	```
	
---

##	JSTL - CORE

*	JSTL은 표준 액션태그 라고 한다.
	
*	**변수 지원**, **제어문**, **반복문**, **URL처리**를 위한 JSTL이다.

	>	변수 생성하기
	```jsp
	<c:set var="변수명" value="값" scope="스코프값"/>
	```
	
	>	변수 삭제하기
	```jsp
	<c:remove var="변수명" scope="스코프값"/>
	```
	
	>	단일 조건문(if)
	```jsp
	<c:if test="조건" var="결과값을 저장할 변수명">
	</c:if>
	```

	>	switch또는 if else 조건문	
	```jsp
	<c:choose>
		<c:when test="조건">
		</c:when>
		
		<c:otherwise>
		</c:otherwise>
	</c:choose>
	```
	
	>	반복문
	```jsp
	<c:forEach var="변수" items="반복할 배열 또는 Collections객체" begin="시작인덱스" end="끝인덱스" step="반복문의 스텝값" varStatus="반복문 상태변수">
	</c:forEach>
	```
	
	>	반복문(토큰 - 문자열 잘라내기 기능을 가진 반복문)
	```jsp
	<c:forTokens var="변수" items="반복할 문자열" delims="문자열을 나눌 문자">
	</c:forTokens>
	```
	
	>	url처리
	```jsp
	<c:url var="변수명" value="url값">
		<c:param name="파라메터명" value="값"/>
	</c:url>
	<a href="${변수명}">이동</a>
	<!-- 해당 URL로 설정한 파라메터까지 함께 이동한다 -->
	```
	
	>	redirect
	```jsp
	<c:redirect url="url값">
		<c:param name="변수명" value="값"/>
	</c:redirect>
	<!-- request.sendRedirect() 메서드와 동일한 동작을 한다 -->
	```

	>	out	
	```jsp
	<c:out value="출력할 값" default="값이 없을경우 출력할 기본값" escapeXml="true"/>
	<!-- escapeXml의 값은 특수문자 출력을 위한 escape문자 변환 여부를 설정한다. - 기본값:true(escape문자 사용함) -->	
	<!-- EL과 같은 동작을 하지만, default를 이용하여 값이 없을 경우의 기본값을 설정할 수 있다는 장점이 있다. -->
	```
	
---

##	JSTL - Formatting

*	**지역설정(다국어)**, **메시지 형식**, **숫자 및 날짜 형식**

	>	requestCharacterEncoding 설정하기
	```jsp
	<fmt:requestEncoding value="UTF-8"/>
	```
	
	>	지역(문자) 설정하기
	```jsp
	<fmt:setLocale value="언어코드(ko, en)"/>
	```
	
	>	리소스 번들(=properties 파일)을 로드한다.
	```jsp
	<fmt:setBundle basename="페키지명.파일명(확장자인 .properties는 적지 않는다)"/>
	```
	
	>	리소스 번들(=properties 파일)을 이 태그 바디에만 로드한다.
	```jsp
	<fmt:bundle basename="페키지명.파일명(확장자인 .properties는 적지 않는다)"/>
	```
	
	>	리소스 번들(.properties파일)의 값에 접근할 때 사용한다.
	```jsp
	<fmt:message key="key값"/>
	```
	
	>	숫자를 단위별로 구분하여 출력하기
	```jsp
	<fmt:formatNumber value="값" type="number" groupingUsed="true"/>
	// var 속성을 사용할 경우, 출력하지 않고 var에 지정한 변수명에 저장된다.
	```
	
	>	숫자를 화폐로 출력하기
	```jsp
	<fmt:formatNumber value="값" type="currency" groupingUsed="true" currencySymbol="\\"/>
	// var 속성을 사용할 경우, 출력하지 않고 var에 지정한 변수명에 저장된다.
	
	>	숫자를 퍼센트로 출력하기
	<fmt:formatNumber value="값" type="percent" groupingUsed="false"/>
	// var 속성을 사용할 경우, 출력하지 않고 var에 지정한 변수명에 저장된다.
	```