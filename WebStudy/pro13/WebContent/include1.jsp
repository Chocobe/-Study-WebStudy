<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
%>

<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>

	<body>
		안녕하세요. 쇼핑몰 중심 JSP 시작 입니다!!
		<br/>
		<jsp:include page="dukeImage.jsp" flush="true">
			<jsp:param name="name" value="듀크"/>
			<jsp:param name="imgName" value="persona-4-marie-skirt-zettai-ryouiki-anime-style-games.jpg"/>
		</jsp:include>
		<br/>
		안녕하세요. 쇼핑몰 중심 JSP 끝 입니다!!
	</body>
</html>