<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
%>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>이미지 리스트 출력 예제</title>
	</head>

	<body>
		<ul class="listType">
			<li>
				<span style="margin-left:50px;">이미지</span>
				<span>이미지 이름</span>
				<span>선택하기</span>
			</li>
			
			<%
				for(int i = 0; i < 10; i++) {
			%>
					<li>
						<a href="#" style="margin-left:50px;">
							<img src="image/background_1.jpg" width="90" alt="그림">
						</a>
						<a href="#"><strong>이미지 이름: 듀크<%= i %></strong></a>
						<a href="#"><input type="checkbox" name="check<%= i %>"></a>
					</li>
			<%
				}
			%>
		</ul>
	</body>
</html>