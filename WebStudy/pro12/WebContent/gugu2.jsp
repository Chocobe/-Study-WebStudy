<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
%>

<%
	request.setCharacterEncoding("UTF-8");
	int dan = Integer.parseInt(request.getParameter("dan"));
%>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>구구단 결과2</title>
	</head>

	<body>
		<table border="1">
			<tr align="center" bgcolor="#FFFF66">
				<td colspan="2"><%= dan %>단 출력</td>
			</tr>
			
			<%
				for(int i = 1; i < 10; i++) {
					if(i % 2 == 0) {
			%>
						<tr bgcolor="#CCFF66">
							<td width="400"><%= dan %> * <%= i %></td>
							<td width="400"><%= dan * i %></td>
						</tr>
			<%
					} else {
			%>
						<tr bgcolor="CCCCFF">
							<td width="400"><%= dan %> * <%= i %></td>
							<td width="400"><%= dan * i %></td>
						</tr>
			<%
					}
				}
			%>
		</table>
	</body>
</html>