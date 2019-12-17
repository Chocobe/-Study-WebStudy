<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
	isELIgnored="false"
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>

	<body>
		<ul>
			<li>
				<span stype="margin-left:50px">이미지</span>
				<span>이미지 이름</span>
				<span>선택하기</span>
			</li>
			
			<c:forEach var="i" begin="1" end="9" step="1">
				<li>
					<a href="#" style="margin-left:50px">
						<img src="../image/background_1.jpg" width="90">
					</a>
					<a href="#"><strong>이미지 이름 : 듀크${i}</strong></a>
					<a href="#"><input type="checkbox" name="check${i}"></a>
				</li>
			</c:forEach>
		</ul>
	</body>
</html>