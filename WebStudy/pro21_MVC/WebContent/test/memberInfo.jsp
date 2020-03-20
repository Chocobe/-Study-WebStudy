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
		<table border="1" align="center" width="100%">
			<tr align="center" bgcolor="lightgreen">
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>이메일</th>
			</tr>
			
			<tr align="center">
				<td>${id}</td>
				<td>${pwd}</td>
				<td>${name}</td>
				<td>${email}</td>
			</tr>
		</table>
	</body>
</html>