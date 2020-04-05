package com.kh.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	
	// SqlSession 생성해서 반환하는 메소드
	public static SqlSession getSqlSession() {
		SqlSession session = null;
		
		// DB 접속 정보가 존재하는 mybatis-config.xml 파일을 불러와서
		// SqlSession을 생성해야 함
		
		try {
			// 현재 클래스 패스와 다른 위치에 있는 자원을 로드하는 것을 좀 더 쉽게해주는
			// 마이바티스 라이브러리에서 제공하는 util성 클래스인 Resources라는 클래스를 이용하여
			// 파일을 로드함
			InputStream stream = Resources.getResourceAsStream("/mybatis-config.xml");
			session = new SqlSessionFactoryBuilder().build(stream).openSession(false);
		
			// SqlSession을 만들기 위해서는 SqlSessionFactory에서 openSession이라는 것을
			// 해줘야 하는데 SqlSessionFactory는 SqlSessionFactoryBuilder라는 클래스의 
			// build()를 통해서 생성이 된다.
			// openSession(false)의 의미는 자동 커밋을 하지 않게 설정하는 것이다.
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return session;
	}
	
	// commit(), rollback(), close() 함수는 안 만드나요?????
	// YES!!! 왜냐면 SqlSession 클래스가 commit, rollback, close 함수를
	// 제공해 주고 우리가 만들었던 Statement관련, ResultSet 관련한 close 부분은
	// Dao로 가면 마이바티스를 적용하여 더 편리하게 sql문을 작성하게 되었으므로
	// 사용하지 않게 된다.

}
