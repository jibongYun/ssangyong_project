package com.yaneodo.member.profile;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yaneodo.member.MemberDAO;
import com.yaneodo.member.MemberDTO;


@WebServlet("/member/profile/view.do")
public class View extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		//1. 데이터 가져오기(seq) > 회원번호
		//2. DB 작업 -> select
		//3. 결과 반환 -> JSP 호출하기 + 전달
		
		HttpSession session = req.getSession();
		
		//1.
//		String seq = req.getParameter("seq");

	
		//2.
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.getProfile("1");
		
		dao.close();//*****
		
	
		//3.
		req.setAttribute("dto", dto);


		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/profile/view.jsp");
		dispatcher.forward(req, resp);
	}

}
