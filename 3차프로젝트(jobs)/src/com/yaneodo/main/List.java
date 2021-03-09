package com.yaneodo.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main/list.do")
public class List extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  String searchKey = req.getParameter("searchKey");
		  //System.out.println(searchKey); 
		  
		  SearchDAO dao = new SearchDAO(); 
		  
		  //회사명 검색 -> 기업 리스트 
		  ArrayList<SearchDTO> clist = dao.clist(searchKey);
		  
		  //position 검색 -> 직무 리스트 
		  ArrayList<SearchDTO> jlist = dao.jlist(searchKey);
		  
		  for (SearchDTO dto: jlist) {
			  if (dto.getPlace().length() > 15) {
				  dto.setPlace(dto.getPlace().substring(0,  15) + "..");
			  }
		  }
		  
		  req.setAttribute("searchKey", searchKey);	  
		  req.setAttribute("clist", clist); //companySeq, companyName, industry, companyPhoto
		  req.setAttribute("jlist", jlist); //jobOpeningSeq, companyName, title, job, place, jobPhoto

		  //System.out.println(clist.get(0).getCompanyPhoto());
		  
		  
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main/list.jsp");
		dispatcher.forward(req, resp);

	}
}
