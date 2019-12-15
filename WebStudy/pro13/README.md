#	pro13 - JSP 액션 태그 <jsp: >

>	``<jsp:include page="페이지">`` - 인클루드 액션 태그

	* JSP 디렉티브 태그인 ``<%@ include file="파일명" %>``과 유사한 동작 (결과가 동일하다)
	
	* 같은점
	
		* JSP 파일을 모듈로써 추가한다.
		
	* 차이점
	
		* ``<jsp:include page="페이지"></jsp:include>`` - 인클루드 액션 태그
		
			```jsp
			<jsp:include page="페이지">
				<jsp:param name="변수명" value="변수값"/>
			</jsp:include>
			```
			
			* ``<jsp:param>``태그로 파라메터를 동적으로 처리 가능

		* ``<%@ include file="파일">`` - 인클루드 디렉티브 태그
		
			```jsp
			<%@ include file="파일">
			```
			
			* 정적인 처리만 가능
			
>	``<jsp:forward page="페이지" flush="true">`` - 포워드 액션 태그

	* ``RequestDispatcher`` 객체의 ``forward()``와 동일한 기능
	
	* ``<jsp:param name="변수명" value="변수값"/>``을 이용하여, 메개변수를 전달할 수 있다.