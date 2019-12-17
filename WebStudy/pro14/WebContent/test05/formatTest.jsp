<%@page import="java.util.Date"%>
<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
	isELIgnored="false"
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:requestEncoding value="UTF-8"/>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>포매팅 태그 라이브러리 예제</title>
	</head>

	<body>
		<h2>fmt의 number 태그를 이용한 숫자 포매팅 예제.</h2>
		<c:set var="price" value="100000000"/>
		<fmt:formatNumber var="formatNumber" value="${price}" type="number"/>
		
		통화로 표현시 :
		<fmt:formatNumber type="currency" currencySymbol="\\" value="${price}" groupingUsed="true"/><br/>
		
		퍼센트로 표현시 :
		<fmt:formatNumber type="percent" value="${price}" groupingUsed="false"/><br/>
		
		일반 숫자로 표현 시 :
		${formatNumber}
		
		<br/><br/>
		
		<h2>formatDate 예제</h2>
		<c:set var="now" value="<%= new Date() %>"/>
		<fmt:formatDate value="${now}" type="date" dateStyle="full"/><br/>
		<fmt:formatDate value="${now}" type="date" dateStyle="short"/><br/>
		<fmt:formatDate value="${now}" type="time"/><br/>
		<fmt:formatDate value="${now}" type="time" timeStyle="short"/><br/>
		<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/><br/>
		<fmt:formatDate value="${now}" pattern="yyyy-mm-dd :hh:mm:ss"/><br/>
		
		<br/><br/>
		
		현재 한국시간 : <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/>
		
		<br/><br/>
		
		<fmt:timeZone value="Ameria/New York">
			현재 뉴욕시간 : <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/>
			<br/>
		</fmt:timeZone>
	</body>
</html>