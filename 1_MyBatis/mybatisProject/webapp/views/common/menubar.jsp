<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYBATIS PAGE</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<style>
	.login-area{
		height:100px;
	}
	.btn-login{
		height:50px;
	}
	.nav-area{
		background:black;
		height:50px;
	}
	.menu{
		display:table-cell;
		width:250px;
		height:50px;
		text-align:center;
		vertical-align:middle;
		font-size:20px;
		background:black;
		color:white;
	}
	.menu:hover{
		background:orangered;
		cursor:pointer;
	}
	
</style>
</head>
<body>
	<c:if test="${ !empty msg }">
		<script>
			alert('${msg}');
		</script>
		<c:remove var="msg"/>
	</c:if>

	<h1 align="center">Welcome to Mybatis World!!</h1>
	<br>
	
	<!----------------1. 회원 관련 서비스 --------------------->
	<div class="login-area">
		<!-- 1_2. 로그인 처리 완료 후 session에 loginUser 여부 확인 -->
		<!-- 1_2_1. 로그인이 되어있지 않은 경우의 폼 -->
		<c:if test="${ empty sessionScope.loginUser }">
	
		<!-- 1_1. 로그인 관련 폼 만들기 -->
		<form action="${ contextPath }/login.me" method="post">
			<table align="center">
				<tr>
					<td>아이디 : </td>
					<td>
						<input type="text" name="userId">
					</td>
					<td rowspan="2">
						<button id="login-btn" class="btn-login">로그인</button>
					</td>
				</tr>
				<tr>
					<td>비밀번호 : </td>
					<td>
						<input type="password" name="userPwd">
					</td>
				</tr>
				
				<!-- 회원 가입을 위한 버튼 -->
				<tr>
					<td colspan="3">
						<a href="${ contextPath }/views/member/memberInsertForm.jsp">회원가입</a>
						<a href="#">아이디/비밀번호 찾기</a>
					</td>
				</tr>
				
				
			</table>
		
		</form>
		</c:if>
		
		<!-- 1_2_2. 로그인 되어 있는 경우의 폼 -->
		<c:if test="${ !empty sessionScope.loginUser }">
			<table align="center">
				<tr>
					<td colspan="2"><h3>${ loginUser.userName }님 환영합니다.</h3></td>
				</tr>
				<tr>
					<td>
						<button onclick="location.href='${ contextPath }/views/member/memberUpdateForm.jsp'">
						회원정보 수정</button>
					</td>
					<td>
						<button onclick="location.href='${ contextPath }/logout.me'">로그아웃</button>
					</td>
				</tr>
			</table>
		</c:if>
	</div>
	
	<!------------------- 2. 게시물 관련 서비스 ----------------------------->
	<div class="nav-area" align="center">
		<div class="menu" onclick="home()">HOME</div>
		<div class="menu">공지사항</div><!-- 기능 생략 -->
		<div class="menu" onclick="board()">게시판</div>
		<div class="menu">etc.</div>
	</div>
	
	<script>
		function home(){
			location.href="${ contextPath }";
		}
		
		function board(){
			location.href="selectList.bo";
		}
	</script>
	
</body>
</html>