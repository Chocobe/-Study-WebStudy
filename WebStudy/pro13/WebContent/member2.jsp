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

<jsp:useBean id="m" class="sec01.ex01.MemberBean" scope="page"/>

<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	
	m.setId(id);
	m.setPwd(pwd);
	m.setName(name);
	m.setEmail(email);
	
	MemberDAO dao = new MemberDAO();
	dao.addMember(m);
	List<MemberBean> membersList = dao.listMembers();
%>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>

	<body>
		<table width="100%">
			<tr align="center" bgcolor="#99CCFF">
				<td width="7%">아이디</td>
				<td width="7%">비밀번호</td>
				<td width="5%">이름</td>
				<td width="11%">이메일</td>
				<td width="5%">가입일</td>
			</tr>
			
			<%
				if(membersList.size() == 0) {
			%>
					<tr>
						<td colspan="5">
							<p align="center"><b>
								<span style="font-size:9pt;">등록된 회원이 없습니다.</span>
							</b></p>
						</td>
					</tr>
			<%
				} else {
					for(int i = 0; i < membersList.size(); i++) {
						MemberBean curBean = membersList.get(i);
			%>
						<tr align="center">
							<td><%= curBean.getId() %>
							<td><%= curBean.getPwd() %>
							<td><%= curBean.getName() %>
							<td><%= curBean.getEmail() %>
							<td><%= curBean.getJoinDate() %>
						</tr>
			<%
					}
				}
			%>
			
			<tr height="1" bgcolor="#99CCFF">
				<td colspan="5"></td>
			</tr>
			
		</table>
	</body>
</html>