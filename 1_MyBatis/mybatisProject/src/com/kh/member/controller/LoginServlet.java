package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.exception.LoginFailException;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.me")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		// Member 클래스 만들기
		Member m  = new Member();
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		
		try {
			Member member = new MemberService().selectMember(m);
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", member); // 로그인 회원 세션 객체 생성
			
			request.getRequestDispatcher("/").forward(request, response);
			// /로 시작하면 웹 애플리케이션의 루트로 인식
			// localhost:8800/mybatis(루트) + "/"
		} catch (LoginFailException e) {
			// 예외 발생 시 즉, 로그인 실패 시
			// 에러 페이지로 forward하면서 메세지를 함께 보내준다.
			RequestDispatcher error = request.getRequestDispatcher("/views/common/errorPage.jsp");
			request.setAttribute("message", e.getMessage());
			error.forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
