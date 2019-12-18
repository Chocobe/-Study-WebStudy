<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
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
		<h1>cos.jar를 이용한 파일 업로드</h1>
		
		<form method="POST" action="../fileUpload" encType="multipart/form-data">
			ID : <input type="text" name="id"><br/>
			File1 : <input type="file" name="file1"><br/>
			File2 : <input type="file" name="file2"><br/>
			<input type="submit" value="파일 업로드">
			<input type="reset" value="다시작성">
		</form>
	</body>
</html>