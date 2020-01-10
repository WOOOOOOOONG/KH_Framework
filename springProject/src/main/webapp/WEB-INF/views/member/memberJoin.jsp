<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<h1 align="center">회원가입</h1>
	<div align="center">
		<form action="minsert.do" method="post" id="joinForm">
			<table width="500" cellspacing="5">
				<tr>
					<td width="150">* 아이디</td>
					<td width="450">
						<input type="text" name="id" id="userId">
					</td>
				</tr>
				<tr>
					<td>* 이름</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>* 비밀번호</td>
					<td><input type="password" name="pwd"></td>
				</tr>
				<tr>
					<td>* 비밀번호 확인</td>
					<td><input type="password" name="pwd2"></td>
				</tr>
				<tr>
					<td>* 성별</td>
					<td><input type="radio" name="gender" value="M">남
					<input type="radio" name="gender" value="F">여</td>
				</tr>
				<tr>
					<td>* 나이</td>
					<td><input type="number" name="age" min="20" max="100"></td>
				</tr>
				<tr>
					<td>* 이메일</td>
					<td><input type="email" name="email"></td>
				</tr>
				<tr>
					<td>* 전화번호</td>
					<td><input type="tel" name="phone"></td>
				</tr>
				<!-- 주소는 도로명주소 API : postcodify를 이용해서 작성 -->
				<tr>
					<td>우편번호</td>
					<td>
						<input type="text" name="post" class="postcodify_postcode5" size="6" />
						<button type="button" id="postcodify_search_button">검색</button><br />
					</td>
				</tr>
				<tr>
					<td>도로명주소</td>
					<td>
						<input type="text" name="address1" class="postcodify_address" value="" /><br />
					</td>
				</tr>
				<tr>
					<td>상세주소</td>
					<td>
						<input type="text" name="address2" class="postcodify_extra_info" value="" /><br />
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button>가입하기</button>
						&nbsp;
						<input type="reset" value="작성취소">
					</td>
				</tr>
			</table>
		</form>
		<br>
		<br>
		<div align="center">
			<a href="home.do">시작 페이지로 이동</a>
		</div>
	</div>
	
	<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
	<script> $(function() { $("#postcodify_search_button").postcodifyPopUp(); }); </script>
</body>
</html>