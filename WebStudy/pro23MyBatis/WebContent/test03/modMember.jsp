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
		<form action="${pageContext.request.contextPath}/mem4.do?action=updateMember" method="POST">
			<h1 class="text_center">회원정보 수정창</h1>
			
			<table align="center">
				<tr>
					<td width="200">
						<p align="right">사용자 아이디
					</td>
					
					<td width="400">
						<input type="text" name="id">
					</td>
				</tr>
				
				<tr>
					<td width="200">
						<p align="right">비밀번호</p>
					</td>
					
					<td width="400">
						<input type="text" name="pwd">
					</td>
				</tr>
				
				<tr>
					<td width="200">
						<p align="right">이름</p>
					</td>
					
					<td width="400">
						<input type="text" name="name">
					</td>
				</tr>
				
				<tr>
					<td width="200">
						<p align="right">E-mail</p>
					</td>
					
					<td width="400">
						<input type="text" name="email">
					</td>
				</tr>
				
				<tr>
					<td colspan="2">
						<input type="submit" value="수정하기">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>