<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
	isELIgnored="false"
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:requestEncoding value="UTF-8"/>
<c:set var="contextPath" value="<%= request.getContextPath() %>"/>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>전체 회원정보 출력창</title>
		
		<style>
			.cls1 {
				font-size: 40px;
				text-align: center;
			}
			
			.cls2 {
				font-size: 20px;
				text-align: center;
			}
		</style>
	</head>

	<body>
		<p class="cls1">회원정보</p>
		
		<table border="1" align="center">
			<tr align="center" bgcolor="lightgreen">
				<td width="7%"><b>아이디</b></td>
				<td width="7%"><b>비밀번호</b></td>
				<td width="7%"><b>이름</b></td>
				<td width="7%"><b>이메일</b></td>
				<td width="7%"><b>가입일</b></td>
				<td width="7%"><b>수정</b></td>
				<td width="7%"><b>삭제</b></td>
			</tr>
			
			<c:choose>
				<c:when test="${membersList == null}">
					<tr align="center">
						<td colspan="5"><b>등록된 회원이 없습니다</b></td>
					</tr>
				</c:when>
				
				<c:otherwise>
					<c:forEach var="membersList" items="${membersList}">
						<tr align="center">
							<td>${membersList.id}</td>
							<td>${membersList.pwd}</td>
							<td>${membersList.name}</td>
							<td>${membersList.email}</td>
							<td>${membersList.joinDate}</td>
							<td>
								<a href='${contextPath}/member2/modMemberForm.do?id=${membersList.id}'>수정</a>
							</td>
							<td>
								<a href='${contextPath}/member2/delMember.do?id=${membersList.id}'>삭제</a>
							</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
		
		<p class="cls2">
			<a href="${contextPath}/member2/memberForm.do">회원가입 하기</a>
		</p>
		
		
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<c:choose>
			<c:when test='${msg == "addMember"}'>
				<script type="text/javascript">
					window.onload = function() {
						alert("회원을 등록 하였습니다");
					}
				</script>
			</c:when>
			
			<c:when test='${msg == "modified"}'>
				<script type="text/javascript">
					window.onload = function() {
						alert("회원정보를 수정 하였습니다");
					}
				</script>	
			</c:when>
			
			<c:when test='${msg == "deleted"}'>
				<script type="text/javascript">
					window.onload = function() {
						alert("회원정보를 삭제 하였습니다");
					}
				</script>
			</c:when>
		</c:choose>
	</body>
</html>