<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
	isELIgnored="false"
%>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>회원정보 출력창</title>
	</head>

	<body>
		<table border="1" align="center">
			<tr align="center" bgcolor="#99CCFF">
				<td width="20%">이름</td>
				<td width="20%">비밀번호</td>
				<td width="20%">이름</td>
				<td width="20%">이메일</td>
			</tr>
			
			<tr align="center">
				<td>${membersList[0].id}</td>
				<td>${membersList[0].pwd}</td>
				<td>${membersList[0].name}</td>
				<td>${membersList[0].email}</td>
			</tr>
			
			<tr align="center">
				<td>${requestScope.membersList[1].id}</td>
				<td>${requestScope.membersList[1].pwd}</td>
				<td>${requestScope.membersList[1].name}</td>
				<td>${requestScope.membersList[1].email}</td>
			</tr>
		</table>
	</body>
</html>