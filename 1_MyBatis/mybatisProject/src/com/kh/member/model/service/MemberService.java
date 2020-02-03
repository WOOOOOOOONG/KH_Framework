package com.kh.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.exception.DeleteFailException;
import com.kh.member.model.exception.InsertFailException;
import com.kh.member.model.exception.LoginFailException;
import com.kh.member.model.exception.UpdateFailException;
import com.kh.member.model.vo.Member;
import static com.kh.common.Template.getSqlSession;
public class MemberService {

	public Member selectMember(Member m) throws LoginFailException {
		// Connection 객체를 생성하는 것이 아니라
		// SqlSession이라는 객체를 생성한다.
		// ==> mybatis 라이브러리를 다운 받아야 생성 가능함
		
		// JDBCTemplate을 만들어 싱글 톤 적용시켜 connection 생성, 롤백, 커밋 등의
		// 작업을 했던 것과 유사하게 commom.Template 클래스를 만들어 보자
		
		SqlSession session = getSqlSession();
		// import static 필요
		
		Member member = new MemberDao().selectMember(session, m);
		// 리턴 된 결과가 예외 처리에 대한 책임이 있기 때문에 다시 Controller로 위임한다.
		
		// 정상 수행 후 close 처리함
		session.close();
		
		return member;
	}

	public void insertMember(Member m) throws InsertFailException {
		SqlSession session = getSqlSession();
		
		new MemberDao().insertMember(session, m);
		
		// 예외 발생 시 이 아래 구문은 실행되지 않으며 정상 수행시만 실행 됨
		// 따라서 바로 commit
		session.commit();
		
		// 정상 수행 후 close 처리
		session.close();
	}

	public Member updateMember(Member m) throws UpdateFailException, LoginFailException {
		SqlSession session = getSqlSession();
		
		MemberDao mdao = new MemberDao();
		mdao.updateMember(session, m);
		
		Member updateMember = mdao.selectMember(session, m);
		session.commit();
		session.close();
		
		return updateMember;
	}

	public void deleteMember(int mid) throws DeleteFailException {
		SqlSession session = getSqlSession();
		
		new MemberDao().deleteMember(session, mid);
		
		session.commit();
		session.close();
		
	}

}
