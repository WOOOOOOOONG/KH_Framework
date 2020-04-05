<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYBATIS PAGE</title>

<style>
	.outer {
		width: 900px;
		height: auto;
		background: black;
		color: white;
		margin: auto;
		margin-top: 50px;
		margin-bottom: 50px;
		padding-bottom: 50px;
	}
	
	.outer table {
		border: 1px solid white;
		text-align: center;
	}	
	
	.tableArea {
		width: 800px;
		height: 350px;
		margin: auto;
	}
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/> 
	<div class="outer">
		<br>
		<h1 align="center">게시판 상세보기</h1>
		<table align="center" class="tableArea">
			<tr>
				<td width="100px">글번호</td>
				<td><b>${ b.bId }</b></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><b>${ b.bTitle }</b></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${ b.userName }</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${ b.bCount }</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td>${ b.bCreateDate }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td><p style="height:100px;">${ b.bContent }</p></td>
			</tr>
		</table>
		
		<!-- 댓글 등록 부분 -->
		<form id="replyInsert" action="${ contextPath }/rinsert.re"
			method="post">
			<table align="center">
				<tr>
					<td>
						<input type="hidden" name="bId" value="${ b.bId }">
						<textarea cols="80" rows="5" name="content"></textarea>
					</td>
					<td>
						<button>등록하기</button>
					</td>
				</tr>
				<tr>
					<c:set var="replyCount" value="${ fn:length(b.replyList) }"/>
					<td colspan="2"><b>댓글(${ replyCount })</b></td>
				</tr>
			</table>
		</form>
		
		<!-- 댓글 출력 부분 -->
		<c:if test="${ replyCount > 0 }">
			<table align="center">
				<c:forEach var="r" items="${ b.replyList }">
					<tr>
						<td width="100px">${ r.userName }</td>
						<td width="400px">${ r.rContent }</td>
						<td width="150px">${ r.rCreateDate }</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
	
	<!-- 댓글 등록 기능 작성하기
		InsertReplyServlet
		InsertReplyException
		댓글 등록 완료 후 boardDetail 페이지로 이동	
	 -->
</body>
</html>