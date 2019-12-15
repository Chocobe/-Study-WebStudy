<%@page import="sec01.ex01.MemberBean"%>
<%@page import="java.util.List"%>
<%@page import="sec01.ex01.MemberDAO"%>
<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
%>

<%
	request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="memberBean" class="sec01.ex01.MemberBean" scope="page"/>
<jsp:setProperty name="memberBean" property="*"/>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>

	<body>
		<table align="center" width="100%">
			<tr align="center" bgcolor="#99CCFF">
				<td width="7%">아이디</td>
				<td width="7%">비밀번호</td>
				<td width="5%">이름</td>
				<td width="11%">이메일</td>
			</tr>
			
			<tr align="center">
				<td><jsp:getProperty name="memberBean" property="id"/></td>
				<td><jsp:getProperty name="memberBean" property="pwd"/></td>
				<td><jsp:getProperty name="memberBean" property="name"/></td>
				<td><jsp:getProperty name="memberBean" property="email"/></td>
			</tr>
			
			<tr height="1" bgcolor="#99CCFF">
				<td colspan="5"></td>
			</tr>
		</table>
	</body>
</html>