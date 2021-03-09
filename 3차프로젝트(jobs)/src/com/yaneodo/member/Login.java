package com.yaneodo.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/login.do")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");	
		String password = req.getParameter("password");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();
		
		dto.setEmail(email);
		dto.setPassword(password);
		
		int result = dao.login(dto);
		
		if (result == 1) {
			
			//System.out.println("성공");
			
			HttpSession session = req.getSession();
			session.setAttribute("email", dto.getEmail()); 	

			MemberDTO rdto = dao.getMember(email);
			
			session.setAttribute("seq", rdto.getCustomerSeq());
			session.setAttribute("name", rdto.getName());
			/* session.setAttribute("email", rdto.getEmail()); */
			session.setAttribute("nickName", rdto.getNickName());
			/* session.setAttribute("lastJoin", rdto.getLastJoin()); */

			resp.sendRedirect("/yaneodo/main/index.do");
			//return;
			
		} else {
			resp.setCharacterEncoding("UTF-8");
			
			PrintWriter writer = resp.getWriter();
			
			writer.print("<html><body>");
			writer.print("<script>");
			writer.print("alert('입력된 정보가 없습니다.');");
			writer.print("</script>");
			writer.print("</body></html>");
			
			writer.close();
			
			//resp.sendRedirect("/yaneodo/member/register.do");

		}
		
	}
}

