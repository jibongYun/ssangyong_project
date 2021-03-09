package com.yaneodo.main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/main/index.do")
public class Index extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  
		HttpSession session = req.getSession();
		String seq = (String)session.getAttribute("seq");

		SearchDAO dao = new SearchDAO();

		// 추천 공고
		ArrayList<SearchDTO> reclist = dao.reclist(seq);

		// 신규 채용
		ArrayList<SearchDTO> newlist = dao.newlist();

		req.setAttribute("reclist", reclist); // jobOpeningSeq, companyName, title, job, jobPhoto, 공고링크
		req.setAttribute("newlist", newlist); // jobOpeningSeq, companyName, title, job, jobPhoto, 공고링크

		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/index.jsp");
		dispatcher.forward(req, resp);

	} 
}