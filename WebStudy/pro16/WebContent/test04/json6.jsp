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
		<title>JSON 테스트 페이지6</title>
	</head>

	<body>
		<a id="checkJson" style="cursor:pointer">출력하기</a>
		<div id="output"></div>
		
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			$(function() {
				$("#checkJson").click(function() {
					$.ajax({
						type: "POST",
						async: false,
						url: `${contextPath}/json2`,
						success: function(data, textStatus) {
							var jsonInfo = JSON.parse(data);
							
							var memberInfo = "회원정보<br/>";
							memberInfo += "=======<br/>";
							
							for(var i in jsonInfo.members) {
								memberInfo += "<br/>";
								memberInfo += "이름 : " + jsonInfo.members[i].name + "<br/>";
								memberInfo += "나이 : " + jsonInfo.members[i].age + "<br/>";
								memberInfo += "성별 : " + jsonInfo.members[i].gender + "<br/>";
								memberInfo += "닉네임 : " + jsonInfo.members[i].nickname + "<br/>";
							}
							
							$("#output").html(memberInfo);
						},
						error: function(data, textStatus) {
							alert("에러발생!");
						},
						complete: function(data, textStatus) { }
					});
				});
			});
		</script>
	</body>
</html>