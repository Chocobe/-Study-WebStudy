<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
	isELIgnored="false"
%>

<%
	session.setAttribute("addr", "수원시 팔달구");
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
				<td width="7%"><b>아이디</b></td>
				<td width="7%"><b>비밀번호</b></td>
				<td width="5%"><b>이름</b></td>
				<td width="5%"><b>이메일</b></td>
				<td width="5%"><b>주소</b></td>
			</tr>
			
			<tr align="center">
				<td>${id}</td>
				<td>${pwd}</td>
				<td>${name}</td>
				<td>${email}</td>
				<td>${addr}</td>
			</tr>
		</table>
	</body>
</html>