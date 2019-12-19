<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="<%= request.getContextPath() %>"/>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>JSON 테스트 페이지5</title>
	</head>

	<body>
		<a id="checkJson" style="cursor:pointer">콘솔출력</a>
		
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			$(function() {
				$("#checkJson").click(function() {
					var jsonInfo = `{"name": "박지성", "age": "25", "gender": "남자", "nickname": "날센돌이"}`;
					
					$.ajax({
						type: "post",
						async: false,
						url: `${contextPath}/json`,
						data: {"jsonInfo": jsonInfo},
						dataType:"TEXT",
						success: function(data, textStatus) {
							alert(data);
						},
						error: function(data, textStatus) {
							alert("에러가 발생 하였습니다");
						},
						complete: function(data, textStatus) { }
					});
				});
			});
		</script>
	</body>
</html>