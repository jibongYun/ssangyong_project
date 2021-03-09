package com.yaneodo.member.profile;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yaneodo.member.MemberDAO;
import com.yaneodo.member.MemberDTO;


@WebServlet("/member/profile/edit.do")
public class Edit extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		//view.do -> edit.do?seq=1
		
		//1. 데이터 가져오기(seq)
		//2. DB 작업 -> select
		//3. 결과 반환 -> JSP 호출하기
		
		
		//1.
		String seq = req.getParameter("seq");
		
		//2.
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.getProfile(seq); //(view.do에서 사용하던 메소드)
		
		
		//2.1
		//글쓴이가 맞는지 확인?
		
		
//		HttpSession session = req.getSession();
//		
//		//글쓴이id != 현재로그인한회원id
//		if (!dto.getId().equals((String)session.getAttribute("id"))) {
//			
//			//권한 없음 -> 쫓아내기
//			PrintWriter writer = resp.getWriter();
//			
//			writer.print("<html><body>");
//			writer.print("<script>");
//			writer.print("alert('failed');");
//			writer.print("history.back();");
//			writer.print("</script>");
//			writer.print("</body></html>");
//			
//			writer.close();
//			
//			return; //*****
//		}
		
		//3.
		req.setAttribute("dto", dto);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/profile/edit.jsp");
		dispatcher.forward(req, resp);
	}

}
