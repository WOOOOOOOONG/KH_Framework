package com.kh.spring.member.model.service;

import com.kh.spring.member.model.vo.Member;

public interface MemberService {
	// Controller에서 서비스를 수행하기 위한 메소드의 이름을 정의하여 프로젝트에 규칙을 부여한다.
	// 1. 회원 로그인 서비스를 위한 메소드
	public Member loginMember(Member m);

	// 2. 회원 가입 서비스를 위한 메소드
	public int insertMember(Member m);

	public int updateMember(Member m);

	public int deleteMember(Member m);
}