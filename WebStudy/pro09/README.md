#	팝업창 띄우기

>	popUpTest.html
>
>	popUp.html

*	**팝업창 띄우기**와 **팝업띄우지 않기** 설정하기

---

>	sec02 - Cookie

*	Cookie는 클라이언트 PC에 저장된다.

*	``setMaxAge(양수);``로 설정할 경우, 해당시간동안 유지된다. (파일형태로 저장)

*	``setMaxAge(음수);`` 또는 ``생략``할 경우, 브라우저를 종료할 때 까지 유지된다. (브라우저 메모리에 저장)

---

#	URLEncoder / URLDecoder

>	URLEncoder

*	지정한 타입으로 인코딩 한다.

	```java
	String value = "Hello";
	Cookie cookie = new Cookie("value", URLEncoder.encode(value, "UTF-8"));
	response.addCookie(cookie);
	```
	
---

>	URLDecoder

*	지정한 타입으로 디코딩 한다. (인코딩된 값은 디코딩이 필수이다)

	```java
	Cookie[] cookies = request.getCookies();
	String value = URLDecoder.decode(cookies[0].getValue(), "UTF-8");
	```