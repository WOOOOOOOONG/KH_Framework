package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.exception.LoginFailException;
import com.kh.member.model.exception.UpdateFailException;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/mupdate.me")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터로 넘어온 전달값을 변수에 저장
		int mid = ((Member)request.getSession().getAttribute("loginUser")).getMid();
				
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		Member m = new Member(mid, userId, userPwd, userName, email, phone, address);
		
		try {
			Member updateMember = new MemberService().updateMember(m);
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", updateMember);
			session.setAttribute("msg", "회원 정보 수정이 완료되었습니다.");
			response.sendRedirect(request.getContextPath());
			
		} catch (UpdateFailException | LoginFailException e) {
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
