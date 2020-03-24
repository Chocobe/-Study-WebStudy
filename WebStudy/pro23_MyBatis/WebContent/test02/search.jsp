<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="<%= application.getContextPath() %>"/>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>

	<body>
		<form method="POST" action="${contextPath}/mem3.do">
			입력 : <input type="text" name="value"/>
			
			<select name="action">
				<option value="listMembers">전체</option>
				<option value="selectMemberById">아이디</option>
				<option value="selectMemberByPwd">비밀번호</option>
			</select>
			
			<br/>
			
			<input type="submit" value="검색"/>
		</form>
	</body>
</html>