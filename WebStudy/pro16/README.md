#	pro16 - HTML5와 jQuery

##	HTML5

###	시멘틱 태그

>	<header></header>

*	헤더 시멘틱 태그

>	<section></section>

*	제목별로 나누는 시멘틱 태그
	
>	 <article></article>

*	개별 컨텐츠를 나타내는 시멘틱 태그
	
>	<aside></aside>

*	사이드바 시멘틱 태그
	
>	<nav></nav>

*	메뉴를 나타내는 시멘틱 태그
	
>	<footer></footer>

*	푸터 시멘틱 태그
		
---

##	jQuery

>	$("선택자") : 요소 선택

>	$("선택자(html 요소만 가능)").html() : 선택한 요소의 body값을 가져온다.

>	$("선택자(html 요소만 가능)").html("값") : 선택한 요소의 body에 값을 넣는다.

>	$("선택자(html 또는 xml 요소 가능)").text() : 선택한 요소의 body값을 가져온다.

>	$("선택자(html 또는 xml 요소 가능)").text() : 선택한 요소의 body값을 가져온다.

>	$("Form 요소의 태그 선택자(input등)").val() : input태그(Form태그의 하위 태그)의 입력창에 입력한 값을 가져온다.

>	$("Form 요소의 태그 선택자(input등)").val("값") : input태그(Form태그의 하위 태그)의 입력창에 값을 넣는다.

---

##	AJAX
	
*	Ajax를 사용하지 않고, <input type="button">을 이용하여 서블릿을 요청할 경우, 서블릿으로 페이지 이동이 발생한다.
	
*	Ajax를 사용할 경우, 현재 페이지에서 서블릿으로 요청정보만 전달하고, 서블릿에서 결과를 원래 페이지로 전송할 수 있게 된다. 결과적으로 페이지 이동이 없어진다.
	
*	Ajax를 사용하는 이유는, **페이지 이동 없이 요청** 수행과 결과 출력을 하기 위함이다.

	```javascript
	$.ajax({
		url: "요청할 URL",
		type: "POST" 또는 "GET",
		async: "true(비동기)" 또는 "false(동기)",
		dataType: "서버에서 전송받을 데이터 형식(text, xml, html, json 등)",
		data: {서버로 전송할 데이터(파라메터)},
		success: function(data, textStatus) {
			// 정상 요청, 응답 시 처리
		},
		error: function(xhr, status, error) {
			// 오류 발생 시 처리
		},
		complete: function(data, textStatus) {
			// 작업 완료 후 처리
		}
	});
	
*	``success(첫번째인자, textStatus)``, ``error(첫번째인자, textStatus)``, ``complete(첫번째인자, textStatus)``의 **첫번째인자**는?

	*	Ajax가 요청한 서블릿에서 ``request.getWriter().print("값");``의 ``값``이 ``첫번째인자``로 들어간다.
	```
	
---

##	AJAX - XML로 처리결과 가져오기 (test03.ajax2.html / sec01.ex01.AjaxTest2)

*	XML에서는 ``<임의의 태그명></임의의 태그명>``형식으로 태그를 만들어 사용한다.

*	Ajax가 요청한 서블릿에서 처리 결과를 XML형식의 문자열로 만들고, ``request.getWriter().print("결과");``의 형식으로 반환한다.

	```xml
	<main>
		<book>
			<title></title>
			<writer></writer>
			<image></image>
		</book>
	</main>
	```

*	반환된 값은 요청한 페이지(Ajax로 요청했던 페이지)의 해당 ``$.ajax({})``의 ``success:function("첫번째인자", textStatus) { }``에서 **첫번째 인자**로 가져올 수 있다.

*	XML로 작성된 태그의 몸체값을 얻기 위해서는 ``var title = $("첫번째인자").find("title");``형태로 가져온다.

*	가져온 인자는 다음 예와 같이 선택자로 값을 가져올 수 있다.

	```javascript
	$.ajax({
		type: "POST",
		async: false,
		url: "http://localhost:8090/pro16/ajaxTest2",
		dataType: "XML",
		success: function(info, textStatus) {
			$(info).find("book").each(function() {
				var title = $(this).find("title");
				var writer = $(this).find("writer");
				var image = $(this).find("image");
				
				$("#target").append("<p>title : " + title + "</p>");
				$("#target").append("<p>writer : " + writer + "</p>");
				$("#target").append("<img src='" + image + "'>");
			});
		}
	});
	```
	
*	Ajax의 ``error``가 호출된다면, Ajax속성 중 ``dataType``을 확인하자. (타입이 잘못된 경우 에러가 발생한다)

*	Ajax의 ``dataType``기본값은 ``TEXT``이다.
	
---

##	JSON - Javascript Object Notation

*	JSON은 **javascript객체 표기법** 이다.

*	JSON은 ``{"키": "값", "키": "값" }`` 의 형식이다.

>	``var parsedData = JSON.parse(대상);`` : "대상"을 Javascript객체로 변환해 준다. (javascript로 사용하기 위해 형변환을 해줘야 한다)

>	``var stringData = JSON.stringify(대상);`` : "대상"을 문자열로 이루어진 객체로 반환해 준다.

>	JSON객체를 만들 떄, "" 또는 '', `` 사용법

	```javascript
	// 외부를 묶는 기호는 벡틱(``) 또는 작은따옴표('')를 사용해야 한다.
	// 내부의 속성명에는 ""를 사용해야 한다.
	var value = '{"age": [11, 22, 33]}';
	```
	
*	전달할 데이터가 많을 경우, JSON을 배열로 만들어서 사용하면 된다.

---

##	Servlet & Ajax & JSON

*	Servlet에서 JSON을 사용하기 위해서는 **json-simple-XXX.jar**가 필요하다.

*	Servlet에서 JSON객체 생성

	*	``JSONObject`` : JSON 객체 클래스
	
	```java
	JSONObject jsonData = new JSONObject();
	jsonData.put("키", "값");
	```
	
	*	``JSONArray`` : JSON 객체들을 가지는 배열 객체
	
	```java
	JSONArray jsonArray = new JSONArray();
	
	JSONObject jsonData1 = new JSONObject();
	JSONObject jsonData2 = new JSONObject();
	
	jsonArray.add(jsonData1);
	jsonArray.add(jsonData2);
	```
	
*	Ajax로 서블릿에 JSON객체를 보낼떄는 **문자열**로 된 JSON객체를 보내자. (dataType="text")

	```javascript
	$.ajax({
		dataType: "text"
	});
	```

*	서블릿에서 Ajax로 응답할 때 역시 **문자열**로 된 JSON객체를 보내야 한다.

	```java
	JSONObject jsonData = new JSONObject();
	String jsonStr = jsonData.toJSONString();
	
	PrintWriter out = response.getWriter();
	out.print(jsonStr);
	```
	
*	서블릿에서 JSON배열을 전송할 때는 ``JSONArray``객체를 ``JSONObject``객체에 넣어서 보내야 한다.

	```java
	JSONObject data1 = new JSONObject();
	JSONObject data2 = new JSONObject();
	
	JSONArray jsonArray = new JSONArray();
	jsonArray.add(data1);
	jsonArray.add(data2);
	
	JSONObject resultJsonData = new JSONObject();
	resultJsonData.put("키", jsonArray);
	
	PrintWriter out = response.getWriter();
	out.print(resultJsonData);
	```