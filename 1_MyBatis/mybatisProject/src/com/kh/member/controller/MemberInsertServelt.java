package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.exception.InsertFailException;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberInsertServelt
 */
@WebServlet(name = "MemberInsertServlet", urlPatterns = { "/minsert.me" })
public class MemberInsertServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String birthDay = request.getParameter("birthDay");
		int genderNumber = Integer.parseInt(request.getParameter("gender"));
		String gender = "";
		// 주민번호 성별자리에 대한 처리
		if(genderNumber == 1 || genderNumber == 3)
			gender = "M";
		else
			gender = "F";
				
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		Member m = new Member(userId, userPwd, userName, email, birthDay,
				gender, phone, address);
		
		try {
			new MemberService().insertMember(m);
			
			// 세션 영역에 메세지 담기
			request.getSession().setAttribute("msg", "회원 가입이 완료 되었습니다. 로그인 해주세요.");
			// 회원 가입 완료 후 메인으로 이동
			response.sendRedirect(request.getContextPath());
		} catch (InsertFailException e) {
			// 에러 페이지로 전달
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
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
