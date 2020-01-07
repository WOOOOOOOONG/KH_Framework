<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
	
	td {
		border: 1px solid white;
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
	
	<!-- 0_1. 로그인 한 회원만 게시글 보기를 위한 조건 추가 -->
	<c:if test="${ !empty loginUser }">
		<div class="outer">
			<br>
			<h1 align="center">게시판</h1>
			<!-- 1. 게시글 리스트 보기 -->
			<table id="boardArea" align="center">
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr>
				<!-- forEach를 통해 request에 담겨있는 list에 하나씩 접근하여 출력 -->
				<c:forEach var="b" items="${ list }">
					<tr>
						<td>${ b.bId }</td>
						<td>${ b.bTitle }</td>
						<td>${ b.bContent }</td>
						<td>${ b.bCount }</td>
						<td>${ b.bCreateDate }</td>
					</tr>
				</c:forEach>
			</table>
			
			<!-- 1_2. 게시물 리스트 페이징 부분 -->
			<div class="pagingArea" align="center">
				<!-- [이전] -->
				<c:if test="${ pi.currentPage <= 1 }">
					<!-- 현재 페이지가 1페이지인 경우 이전 페이지가 없으므로 [이전] a태그 
					비활성화(그냥 문자열로  출력) -->
					[이전] &nbsp;
				</c:if>
				<c:if test="${ pi.currentPage > 1 }">
					<c:url var="blistBack" value="/selectList.bo">
						<c:param name="currentPage" value="${ pi.currentPage - 1 }"/>
					</c:url>
					<a href="${ blistBack }">[이전]</a>
				</c:if>
				
				<!-- [이전], [다음] 사이의 번호 -->
				<c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
					<!-- 현재 페이지와 같은 페이지 번호 스타일 변경 -->
					<c:if test="${ p eq pi.currentPage }">
						<font color="red" size="4"><b>[${p}]</b></font>
					</c:if>
					<!-- 현재 페이지가 아닌 페이지 -->
					<c:if test="${ p ne pi.currentPage }">
						<c:url var="blistCheck" value="/selectList.bo">
							<c:param name="currentPage" value="${ p }"/>
						</c:url>
						<a href="${ blistCheck }">[${p}]</a>
					</c:if>
				</c:forEach>
				
				<!-- [다음] -->
				<c:if test="${ pi.currentPage >= pi.maxPage }">
					<!-- 현재 페이지와 최대 페이지가 같다면 [다음] 버튼 비활성화 -->
					[다음]
				</c:if>
				<c:if test="${ pi.currentPage < pi.maxPage }">
					<c:url var="blistEnd" value="selectList.bo">
						<c:param name="currentPage" value="${ pi.currentPage + 1 }"/>
					</c:url>
					<a href="${ blistEnd }">[다음]</a>
				</c:if>				
			</div>
		</div>
	</c:if>

	<!-- 2. 상세보기 -->
	<script>
		$(function() {
			$("#boardArea").find("td").mouseenter(function() {
				$(this).parents("tr").css({"background":"orangered", "cursor":"pointer"});
			}).mouseout(function() {
				$(this).parents("tr").css({"background":"black"});
			}).click(function() {
				var bId = $(this).parents().children("td").eq(0).text();
				location.href = "selectOne.bo?bId="+bId;
			});
		});
	</script>
	
	<!-- 0_2. 로그인 하지 않은 경우 -->
	<c:if test="${ empty loginUser }">
		<c:set var="message" value="로그인이 필요한 서비스입니다." scope="request"/>
		<jsp:forward page="../common/errorPage.jsp"/>
	</c:if>
</body>
</html>