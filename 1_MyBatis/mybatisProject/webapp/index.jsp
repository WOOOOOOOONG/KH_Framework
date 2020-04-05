<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 환경 설정
		1. workspace 세팅 => JSP/Servlet에서 했던 작업
		2. jstl, ojdbc 라이브러리 추가
		3. 마이바티스를 사용하기 위해 mybatis 라이브러리 추가
		4. 프로젝트 최상단에 new - Source Folder 추가 : resources
		5. 생성한 resources 폴더 안에 mybatis-config.xml 생성
		
		>> mybatis-config.xml 설정 파일 생성 시 DTD 설정을 해두면,
		   mybatis 관련 xml 파일을 설정할 때 재사용 할 수 있음.
		>> DTD(Document Type Definition) 설정하기
			1) Window - Preference - XML - XML Catalog -
			User Specified Entries - Add
			
			- Config
			Location : http://mybatis.org/dtd/mybatis-3-config.dtd
			Key type : Public ID
			key	     : -//mybatis.org//DTD Config 3.0//EN
			- Mapper
			Location : http://mybatis.org/dtd/mybatis-3-mapper.dtd
			Key type : Public ID
			key	     : -//mybatis.org//DTD Mapper 3.0//EN
		
			>> DTD 파일로부터 xml 파일 생성
			1) resources 오른쪽 버튼 -> New -> XML File - Next
			2) Create XML file from a DTD file - Next
			3) Select XML Catalog entry - 해당 entry 선택 - 생성
		
			mybatis-config.xml 파일을 만들고 오자
		 -->

	<c:set var="contextPath" value="${ pageContext.servletContext.contextPath }"
	scope="application"/>

	<jsp:forward page="views/main/main.jsp"/>

</body>
</html>