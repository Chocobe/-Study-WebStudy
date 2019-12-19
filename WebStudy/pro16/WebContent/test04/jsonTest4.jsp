<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
%>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>JSON 테스트 페이지4</title>
	</head>

	<body>
		<a id="checkJson" style="cursor:pointer">출력</a>
		<div id="output"></div>
		
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			$(function() {
				$("#checkJson").click(function() {
					var jsonStr = `{"member": [{"name": "박지성",
												"age": "25",
												"gender": "남성",
												"nickname": "날센돌이"},
											   {"name": "손흥민",
												"age": "30",
												"gender": "남성",
												"nickname": "탱크"}]}`;
					var jsonInfo = JSON.parse(jsonStr);
					
					var output = "회원정보<br/>";
					output += "=======<br/>";
					
					for(var i in jsonInfo.member) {
						output += "<br/>"
						output += "이름 : " + jsonInfo.member[i].name + "<br/>";
						output += "나이 : " + jsonInfo.member[i].age + "<br/>";
						output += "성별 : " + jsonInfo.member[i].gender + "<br/>";
						output += "닉네임 : " + jsonInfo.member[i].nickname + "<br/>";
					}
					
					$("#output").html(output);
				});
			});
		</script>
	</body>
</html>