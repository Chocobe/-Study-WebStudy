<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
	isELIgnored="false"
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	List<String> dataList = new ArrayList<String>();
	dataList.add("hello");
	dataList.add("world");
	dataList.add("안녕하세요!");
%>

<c:set var="list" value="<%= dataList %>" scope="page"/>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>반복문 실습</title>
	</head>

	<body>
		<c:forEach var="i" begin="1" end="10" step="1" varStatus="loop">
			i = ${i} &nbsp;&nbsp; 반복횟수 : ${loop.count}<br/>
		</c:forEach>
		
		<br/>
		
		<c:forEach var="i" begin="1" end="10" step="2">
			5 * ${i} = ${5 * i}<br/>
		</c:forEach>
		
		<br/>
		
		<c:forEach var="data" items="${list}">
			${data}<br/>
		</c:forEach>
		
		<br/>
		
		<c:set var="fruits" value="사과, 파인애플, 바나나, 망고, 귤"/>
		<c:forTokens var="token" items="${fruits}" delims=",">
			${token}<br/>
		</c:forTokens>
	</body>
</html>