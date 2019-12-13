<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
	session="true"
	buffer="8kb"
	autoFlush="true"
	isErrorPage="false"
	errorPage=""
	isThreadSafe="true"
	info="include 테스트"
%>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>인클루드 디렉티브</title>
	</head>

	<body>
		<h1>안녕하세요. 쇼핑몰 중심 JSP 시작 입니다!</h1>
		<%@ include file="./dukeImage.jsp" %>
		<h1>안녕하세요. 쇼핑몰 중심 JSP 끝 부분 입니다</h1>
	</body>
</html>