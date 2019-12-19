<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:requestEncoding value="UTF-8"/>
<c:set var="contextPath" value="<%= request.getContextPath() %>"/>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>JSON 테스트 페이지7</title>
	</head>

	<body>
		<a id="checkJson" style="cursor:pointer">JSON 데이터 출력하기</a>
		<div id="output"></div>
		
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			$(function() {
				$("#checkJson").click(function() {
					$.ajax({
						type: "POST",
						async: true,
						url: `${contextPath}/json3`,
						success: function(data, textStatus) {
							var jsonInfo = JSON.parse(data);
							
							var membersInfo = "회원정보<br/>";
							membersInfo += "=======<br/>";
							
							for(var i in jsonInfo.members) {
								membersInfo += "<br/>";
								membersInfo += "이름 : " + jsonInfo.members[i].name + "<br/>";
								membersInfo += "나이 : " + jsonInfo.members[i].age + "<br/>";
								membersInfo += "성별 : " + jsonInfo.members[i].gender + "<br/>";
								membersInfo += "닉네임 : " + jsonInfo.members[i].nickname + "<br/>";
							}
							
							var booksInfo = "도서정보<br/>";
							booksInfo += "=======<br/>";
							
							for(var i in jsonInfo.books) {
								booksInfo += "<br/>";
								booksInfo += "제목 : " + jsonInfo.books[i].title + "<br/>";
								booksInfo += "저자 : " + jsonInfo.books[i].writer + "<br/>";
								booksInfo += "가격 : " + jsonInfo.books[i].price + "<br/>";
								booksInfo += "장르 : " + jsonInfo.books[i].genre + "<br/>";
								
								var imageURL = jsonInfo.books[i].image;
								booksInfo += "<img src='" + imageURL + "' width='600'>";
							}
							
							$("#output").html(membersInfo + "<br/><br/><br/>" + booksInfo);
						},
						error: function(data, textStatus) {
							alert("에러발생 !!!");
						},
						complete: function(data, textStatus) { }
					});
				});
			});
		</script>
	</body>
</html>