<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYBATIS PAGE</title>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<h1 align="center">회원가입</h1>
	<form action="${ contextPath }/minsert.me" method="post">
		<table align="center">
			<tr>
				<td>* 아이디</td>
				<td><input type="text" name="userId" required></td>
			</tr>
			<tr>
				<td>* 비밀번호</td>
				<td><input type="password" name="userPwd" required></td>
			</tr>
			<tr>
				<td>* 비밀번호 확인</td>
				<td><input type="password" name="userPwd2" required></td>
			</tr>
			<tr>
				<td>* 이름</td>
				<td><input type="text" name="userName" required></td>
			</tr>
			<tr>
				<td>* 이메일</td>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<td>* 주민등록번호</td>
				<td><input type="text" name="birthDay" size="5" maxlength="6">-
				<input type="text" name="gender" size="1" maxlength="1">******</td>
			</tr>
			<tr>
				<td>* 전화번호</td>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td>* 주소</td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td colspan="2">
					<div align="center">
						<br>
						<button type="reset">취소</button>
						<button type="submit">가입하기</button>
					</div>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>