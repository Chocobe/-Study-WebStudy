# sec01 - Redirect 방식의 포워딩

*	```java
	// 주소값의 앞에 "/"를 사용하지 않을 경우, 상대경로
	// 주소값의 앞에 "/"를 사용할 경우, 절대경로
	response.sendRedirect("second");
	```
	
*	```java
	// 주소값의 앞에 "/"를 사용하지 않을 경우, 상대경로
	// 주소값의 앞에 "/"를 사용할 경우, 절대경로
	// 1초 뒤, 해당 url로 포워딩한다.
	response.addHeader("Refresh", "1;url=second");
	```
	
*	```java
	// javascript를 이용한 포워딩
	PrintWriter out = response.getWriter();
	out.print("<script type='text/javascript'>");
	out.print("location.href='second';");
	out.print("</script>");
	```
	
*	위의 3가지 포워딩 방법은 모두 ``Redirect``방식의 포워딩이다.

*	지정한 url값에 값을 전달할 수 있다.

	``response.sendRedirect("second?name=값");``
	
	``response.addHeader("Refresh", "1;url=second?name=값");``
	
	``out.print("location.href='second?name=값");``