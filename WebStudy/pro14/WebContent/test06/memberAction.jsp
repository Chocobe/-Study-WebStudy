<%@page import="sec02.ex01.MemberBean"%>
<%@page import="java.util.List"%>
<%@page import="sec02.ex01.MemberDAO"%>
<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
	isELIgnored="false"
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:requestEncoding value="UTF-8"/>

<jsp:useBean id="m" class="sec02.ex01.MemberBean" scope="page"/>
<jsp:setProperty name="m" property="*"/>

<%
	MemberDAO dao = new MemberDAO();
	
	dao.addMember(m);
	List<MemberBean> membersList = dao.membersList();
	
	request.setAttribute("membersList", membersList);
%>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>

	<body>
		<jsp:forward page="./memberList.jsp"/>
	</body>
</html>