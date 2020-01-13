<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.wrap {
		width: 50%;
		margin: auto;
	}
	
	#noticeTable {
		width: 100%;
		border: solid 1px white;
	}
	
	#noticeTable th, #noticeTable td {
		border: solid 1px white;
		text-align: center;
	}
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<br>
	
	<h1 align="center">공지글 목록 보기</h1>
	<br><br>
	
	<div class="wrap">
		<c:if test="${ loginUser.id eq 'admin' }">
			<div align="right">
				<button onclick="location.href='nWriterView.do'">글쓰기</button>
			</div>
		</c:if>
		<table id="noticeTable">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>첨부파일</th>
			</tr>
			<c:forEach var="n" items="${ list }">
				<tr>
					<td>${ n.nId }</td>
					<td>
					<!-- 로그인 된 경우만 상세 페이지로 이동할 수 있도록 처리 -->
						<c:if test="${ !empty loginUser }">
							<c:url var="ndetail" value="ndetail.do">
								<c:param name="nId" value="${ n.nId }"/>
							</c:url>
							<a href="${ ndetail }">${ n.nTitle }</a>
						</c:if>
						<c:if test="${ empty loginUser }">
							${ n.nTitle }
						</c:if>
					</td>
					<td>${ n.nWriter }</td>
					<td>${ n.nCreateDate }</td>
					<td>
						<c:if test="${ !empty n.filePath }">
							◎
						</c:if>
						<c:if test="${ empty n.filePath }">
							X
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>