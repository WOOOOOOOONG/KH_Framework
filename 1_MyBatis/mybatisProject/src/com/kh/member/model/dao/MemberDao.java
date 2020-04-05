package com.kh.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.member.model.exception.DeleteFailException;
import com.kh.member.model.exception.InsertFailException;
import com.kh.member.model.exception.LoginFailException;
import com.kh.member.model.exception.UpdateFailException;
import com.kh.member.model.vo.Member;

public class MemberDao {

	public Member selectMember(SqlSession session, Member m) throws LoginFailException {
		
		// 앞으로는 마이바티스를 적용하므로 session이 제공하는 메소드를 통해
		// sql 구문을 실행 시킨다.
		
		// 객체 한 개를 조회 할때는 SqlSession의 selectOne() 메소드를 사용
		// 사용 시 전달 인자로 2개의 값을 넘기고
		// 첫번째 인자는 쿼리문이 존재하는 '매퍼의 네임스페이스.쿼리문아이디"
		// 두번째 인자는 쿼리문을 완성시킬 '객체'
		Member member = null;
		member = session.selectOne("memberMapper.loginMember", m);
		
		// 회원 관련 쿼리문을 담을 member-mapper.xml 만들기
		System.out.println("member = " + member);
		
		// 조회 여부에 따라 사용자 정의 exception을 발생 시킨다
		// 정상으로 리턴하는 흐름과는 다른 흐름을 고의로 발생시키기
		if(member == null) {
			// 조회 되지 않는 경우 즉, 로그인 실패시
			
			// 예외를 발생 시키면 정상적으로 service 쪽으로 리턴하지 않기 때문에
			// 세션을 이곳에서 닫아준다.
			session.close();
			
			throw new LoginFailException("로그인 실패!!");
			// 예외 클래스를 만들어 예외를 발생시킴
			// 직접 처리하지 않고 throws한다.
			
		}
		// 조회 되는 경우 즉, 로그인 성공 시 로그인 된 회원 리턴
		return member;
	}

	public void insertMember(SqlSession session, Member m) throws InsertFailException {
		// 예외 발생 여부를 결정하기 위한 int형 변수 선언(쓰레기 값으로 초기화)
		// 정상 수행 상황이 아니면 rollback이 되도록 음수 값으로 지정함
		int result = -99;
		
		// insert, update, delete등의 mybatis 메소드는 int 값을 반환함
		result = session.insert("memberMapper.insertMember", m);
		
		// 삽입에 실패하는 경우
		if(result <= 0) {
			// 원칙상 트랜잭션 처리는 service에서 해야 하지만 아직 spring을 위한
			// 진행단계이므로 임시적으로 여기서 rollback 처리 한다.
			session.rollback();
			// 정상적으로 service 리턴 되지 않으므로 session 닫기
			session.close();
			// 실패 시에는 회원 가입 실패 메세지로 예외 발생 시키기
			throw new InsertFailException("회원 가입 실패!");
		}
		
	}

	public void updateMember(SqlSession session, Member m) throws UpdateFailException {
		int result = -99;
		result = session.update("memberMapper.updateMember", m);
		if(result <= 0) {
			session.rollback();
			session.close();
			throw new UpdateFailException("회원 수정 실패!!");
		}
		
	}

	public void deleteMember(SqlSession session, int mid) throws DeleteFailException {
		int result = -99;
		result = session.update("memberMapper.deleteMember", mid);
		if(result <= 0) {
			session.rollback();
			session.close();
			throw new DeleteFailException("회원 탈퇴 실패!!");
		}
		
	}

}
