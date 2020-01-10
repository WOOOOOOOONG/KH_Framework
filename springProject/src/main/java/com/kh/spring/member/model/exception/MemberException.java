package com.kh.spring.member.model.exception;

public class MemberException extends RuntimeException {
	// Exception을 상속받지 않고 RuntimeException을 상속받기
	public MemberException(String message) {
		super(message); 
	}
}
