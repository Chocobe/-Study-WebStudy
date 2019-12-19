<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
%>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>JSON 테스트 페이지2</title>
	</head>

	<body>
		<a id="checkJson" style="cursor:pointer">출력</a>
		<div id="output"></div>
		
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			$(function() {
				$("#checkJson").click(function() {
					/* var jsonStr = '{"age": [22, 33, 44]}'; */
					/* var jsonStr = "{'age': [22, 33, 44]}"; */
					var jsonStr = `{"age": [22, 33, 44]}`;
					var jsonInfo = JSON.parse(jsonStr);
					
					var output = "회원나이<br/>";
					output += "=======<br/>";
					
					for(var i in jsonInfo.age) {
						output += jsonInfo.age[i] + "<br/>";
					}
					
					$("#output").html(output);
				});
			});
		</script>
	</body>
</html>