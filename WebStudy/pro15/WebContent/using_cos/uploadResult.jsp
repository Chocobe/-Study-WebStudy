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
		<title></title>
	</head>

	<body>
		<h1>파일 업로드 결과</h1>
		<h3>ID : ${uploadID}</h3>
		<h3>File1 경로 : ${fileList[0]}</h3>
		<img src="${fileList[0]}" width="300"/>
		
		<br/>
		
		<h3>File2 경로 : ${fileList[1]}</h3>
		<img src="${fileList[1]}" width="400"/>
	</body>
</html>