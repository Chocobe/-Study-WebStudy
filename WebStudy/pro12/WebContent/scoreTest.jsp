<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
%>

<%
	request.setCharacterEncoding("UTF-8");
	int score = Integer.parseInt(request.getParameter("score"));
%>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>시험 점수 변환결과</title>
	</head>

	<body>
		<h1>시험점수 <%= score %>점</h1>
		
		<%
			if(score > 100 || score < 0) {
		%>
				<h1>잘못된 입력 입니다. (점수범위 : 0 ~ 100)</h1>
		<%
			} else if(score >= 90) {
		%>
				<h1>A학점 입니다. (점수 : <%= score %>점)</h1>
		<% 
			} else if(score >= 80 && score < 90) { 
		%>
				<h1>B학점 입니다. (점수 : <%= score %>점)</h1>
		<%
			} else if(score >= 70 && score < 80) {
		%>
				<h1>C학점 입니다. (점수 : <%= score %>점)</h1>
		<%
			} else if(score >= 60 && score < 70) {
		%>
				<h1>D학점 입니다. (점수 : <%= score %>점)</h1>
		<%
			} else {
		%>
				<h1>F학점 입니다. (점수 : <%= score %>점)</h1>
		<%
			}
		%>
		<br/>
		
		<a href="scoreTest.html">시험점수 입력</a>
	</body>
</html>