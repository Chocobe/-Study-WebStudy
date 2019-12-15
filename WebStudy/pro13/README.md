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
	
---
			
>	``<jsp:forward page="페이지" flush="true">`` - 포워드 액션 태그

	* ``RequestDispatcher`` 객체의 ``forward()``와 동일한 기능
	
	* ``<jsp:param name="변수명" value="변수값"/>``을 이용하여, 메개변수를 전달할 수 있다.
	
---
	
>	``<jsp:useBean id="변수명(빈이름)" class="패키지명 포함 클래스" scope="범위값">``

	* 빈 객체를 생성하기 위해 자바코드가 아닌, 액션 태그로 생성하는 방법이다.
	
---

>	``<jsp:setProperty name="객체명" property="저장할 속성명" value="저장할 값"/>``

	* ``name``의 객체에 ``property``속성에 ``value``값을 저장한다.

>	``<jsp:setProperty name="객체명" property="저장할 속성명" param="가져올 파라메터명"/>``

	* 위와 동일한 기능이며, 저장할 값이 ``request.getParameter()``, 즉 해당 파라메터명으로 접근하여 저장하는 방법이다.
	
	```jsp
	// value 속성을 사용하여 직접 값을 넣는 방법	
	<jsp:setProperty name="객체명" property="data_1" value="<%= request.getParameter("val_1") %>"/>
	
	// param 속성을 사용하여 전달받을 파라메터명을 명시하는 방법
	<jsp:setProperty name="객체명" property="data_1" param="val_1"/>
	
	// value, param을 생략하고, property 속성명과 동일한 파라메터값을 넣는 방법
	<jsp:setProperty name="객체명" property="data_1"/>
	
	// property 속성값에 "*"를 입력할 경우, 빈즈의 속성명과 파라메터의 속성명이 같은 모든 속성을 자동으로 저장해 준다.
	<jsp:setProperty name="객체명" property="*"/>
	```
	
---

>	``<jsp:getProperty name="객체명" property="가져올 속성명"/>``

	* 해당 객체의 속성값을 가져온다.