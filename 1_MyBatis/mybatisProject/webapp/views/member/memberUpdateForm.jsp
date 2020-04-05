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
	<h1 align="center">정보수정</h1>
	<form action="${ contextPath }/mupdate.me" method="post">
		<table align="center">
			<tr>
				<td>* 아이디</td>
				<td><input type="text" name="userId" 
				value="${ loginUser.userId }" readonly></td>
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
				<td><input type="text" name="userName" 
				value="${ loginUser.userName }" required></td>
			</tr>
			<tr>
				<td>* 이메일</td>
				<td><input type="email" name="email"
				value="${ loginUser.email }"></td>
			</tr>
			<tr>
				<td>* 전화번호</td>
				<td><input type="text" name="phone"
				value="${ loginUser.phone }"></td>
			</tr>
			<tr>
				<td>* 주소</td>
				<td><input type="text" name="address"
				value="${ loginUser.address }"></td>
			</tr>
			<tr>
				<td colspan="2">
					<div align="center">
						<br>
						<button type="reset">취소</button>
						<button type="submit">수정하기</button>
						<button type="button" onclick="deleteMember();">탈퇴하기</button>
					</div>
				</td>
			</tr>
		</table>
	</form>
	
	<script>
		function deleteMember(){
			if(confirm('정말로 탈퇴하시겠습니까?')){
				location.href='${contextPath}/mdelete.me';
			}
				
		}
	</script>
	
	
	
	
	
	
</body>
</html>