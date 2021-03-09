package com.yaneodo.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yaneodo.company.main.CompanyDAO;

@WebServlet("/member/registercheck.do")
public class RegisterCheck extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Ajax 응답 처리 페이지

		//1. 데이터 가져오기 (ajax -> email)
		//2. DB 작업 -> select
		//3. 결과 반환
		
		//1.
		String email = req.getParameter("email");

		//2.
		System.out.println(email);
		
		MemberDAO dao = new MemberDAO();
		int result = dao.checkId(email);
		
		System.out.println(result);
		
		
		//3. 
		PrintWriter writer = resp.getWriter();
		
		writer.print(result);
		writer.close();
		
		

	}
}
