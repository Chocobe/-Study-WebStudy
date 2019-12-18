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

	>	**$("선택자")** : 요소 선택
	
	>	**$("선택자").html() : 선택한 요소의 body값을 가져온다.
	
	>	**$("선택자").html("값") : 선택한 요소의 body에 값을 넣는다.
	
	>	**$("input태그 선택자").val() : input태그의 입력창에 입력한 값을 가져온다.
	
	>	**$("input태그 선택자").val("값") : input태그의 입력창에 값을 넣는다.
	
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
		dataType: "서버에서 전송받을 데이터 형식",
		data: {서버로 전송할 데이터},
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
	```