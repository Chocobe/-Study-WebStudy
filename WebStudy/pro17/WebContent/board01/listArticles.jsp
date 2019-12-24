<%@ page
	language="java"
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"
	isELIgnored="false"
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:requestEncoding value="UTF-8"/>
<c:set var="contentPath" value="<%= request.getContextPath() %>"/>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title></title>
		
		<style>
			.cls1 {
				text-decoration: none;
			}
			
			.cls2 {
				text-align: center;
				font-size: 30px;
			}
		</style>
	</head>

	<body>
		<table border="1" align="center" width="80%">
			<tr height="10" align="center" bgcolor="#lightgreen">
				<td>글번호</td>
				<td>작성자</td>
				<td>제목</td>
				<td>작성일</td>
			</tr>
			
			<c:choose>
				<c:when test="${articlesList == null}">
					<tr height="10">
						<td colspan="4">
							<p align="center">
								<b><span style="font-size:9pt;">등록된 글이 없습니다</span></b>
							</p>
						</td>
					</tr>
				</c:when>
				
				<c:otherwise>
					<c:forEach var="article" items="${articlesList}" varStatus="articleNum">
						<tr align="center">
							<td width="5%">${articleNum.count}</td>
							
							<td width="10%">${article.id}</td>
							
							<td align="left" width="35%">
								<span style="padding-right: 30px"></span>
								<a class="cls1" href="${contentPath}/board/viewArtiel.do?articleNO=${article.articleNO}">
									${article.title}
								</a>
							</td>
							
							<td width="10%">
								<fmt:formatDate value="${article.writeDate}"/>
							</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
		
		<p class="cls2">
			<a class="cls1" href="#">글쓰기</a>
		</p>
	</body>
</html>