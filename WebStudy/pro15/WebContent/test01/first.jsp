<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:requestEncoding value="UTF-8"/>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>

	<body>
		<form method="POST" action="result.jsp">
			<input type="hidden" name="param1" value="background_1.jpg">
			<input type="hidden" name="param2" value="background_1.jpg">
			<input type="submit" value="이미지 다운로드">
		</form>
	</body>
</html>