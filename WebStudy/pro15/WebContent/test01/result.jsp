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

<c:set var="file1" value="${param.param1}"/>
<c:set var="file2" value="${param.param2}"/>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>이미지 파일 출력하기</title>
	</head>

	<body>
		매개변수1 : <c:out value="${file1}"/>
		매개변수2 : <c:out value="${file2}"/>
		
		<c:if test="${not empty file}">
			<img src="${contextPath}/download.do?fileName=${file1}" width="300"/>
		</c:if>
		
		<br/>
		
		<c:if test="${not empty file2}">
			<img src="${contextPath}/download.do?fileName=${file2}" width="300"/>
		</c:if>
		
		<br/>
		
		파일 내려받기 : <br/>
		<a href="${contextPath}/download.do?fileName=${file2}">파일 내려받기</a>
	</body>
</html>