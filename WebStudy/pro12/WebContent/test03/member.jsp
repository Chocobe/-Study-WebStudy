<%@page import="java.sql.Date"%>
<%@page import="java.util.List"%>
<%@page import="sec02.ex01.MemberDAO"%>
<%@page import="sec02.ex01.MemberVO"%>
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
		<h1>회원정보 출력</h1>
		
		<%
			request.setCharacterEncoding("UTF-8");
			String name = request.getParameter("name");
			
			MemberVO memberVO = new MemberVO();
			memberVO.setName(name);
			
			MemberDAO dao = new MemberDAO();
			
			List<MemberVO> membersList = dao.listMembers(memberVO);
		%>
		
		<table border="1">
			<tr align="center" bgcolor="#FFFF66">
				<td>아이디</td>
				<td>비밀번호</td>
				<td>이름</td>
				<td>이메일</td>
				<td>가입일자</td>
			</tr>
			
			<%
				for(int i = 0; i < membersList.size(); i++) {
					MemberVO vo = membersList.get(i);
					
					String curId = vo.getId();
					String curPwd = vo.getPwd();
					String curName = vo.getName();
					String curEmail = vo.getEmail();
					Date curJoinDate = vo.getJoinDate();
			%>
					<tr align="center">
						<td><%= curId %></td>
						<td><%= curPwd %></td>
						<td><%= curName %></td>
						<td><%= curEmail %></td>
						<td><%= curJoinDate %></td>
					</tr>
			<%
				}
			%>
		</table>
	</body>
</html>