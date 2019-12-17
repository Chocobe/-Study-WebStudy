<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
%>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>

	<body>
		<h1>시험점수를 입력해 주세요</h1>
		<form method="GET" action="./scoreResult2.jsp">
			시험점수 : <input type="text" name="score">
			<input type="submit" value="학점변환">
		</form>
	</body>
</html>