package com.yaneodo.member.resume;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/member/resume/resume_editok.do")
public class Resume_editOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		

		

		String rseq="";
		String title="";
		String info="";
		String writeDate="";
		String name="";
		String phone="";
		String email="";
		String exseq="";
		String exstartDate="";
		String exendDate="";
		String excompany ="";
		String exjob="";
		String exfield="";
		String edseq="";
		String edstartDate="";
		String edendDate="";
		String edschool="";
		String eddegree="";
		String edmajor="";
		String edstate="";
		String ceseq="";
		String cegetDate="";
		String cetype="";
		String cegrade="";
		String ceagency="";
		String awseq="";
		String awgetDate="";
		String awname="";
		String awagency="";
		String trseq="";
		String trstartDate="";
		String trendDate="";
		String trname="";
		String trtype="";
		String tragency="";
		String abseq="";
		String abstartDate="";
		String abendDate="";
		String abtype="";
		String abcountry="";
		String abnote="";
		String laseq="";
		String language="";
		String level="";
		String prseq="";
		String prtype="";
		String prnote="";
		String poseq="";
		String pourl="";
		String filename="";
		String orgfilename="";


		try {
			MultipartRequest multi = new MultipartRequest(
										req,
										req.getRealPath("/files"),
										1024 * 1024 * 100,
										"UTF-8",
										new DefaultFileRenamePolicy()
									);
			
			System.out.println(req.getRealPath("/files"));
		
			rseq= multi.getParameter("req");
			 title= multi.getParameter("title");
			 info= multi.getParameter("info");
			 writeDate = multi.getParameter("writeDate");
			 name=multi.getParameter("name");
			 phone=multi.getParameter("phone");
			 email=multi.getParameter("email");
			 exseq= multi.getParameter("exseq");
			 exstartDate= multi.getParameter("exstartDate");
			 exendDate= multi.getParameter("exendDate");
			 excompany = multi.getParameter("excompany");
			 exfield= multi.getParameter("exfield");
			 exjob= multi.getParameter("exjob");
			 edseq= multi.getParameter("edseq");
			 edstartDate= multi.getParameter("edstartDate");
			 edendDate= multi.getParameter("edendDate");
			 edschool= multi.getParameter("edschool");
			 eddegree= multi.getParameter("eddegree");
			 edmajor= multi.getParameter("edmajor");
			 edstate= multi.getParameter("edstate");
			 ceseq= multi.getParameter("ceseq");
			 cegetDate= multi.getParameter("cegetDate");
			 cetype= multi.getParameter("cetype");
			 cegrade= multi.getParameter("cegrade");
			 ceagency= multi.getParameter("ceagency");
			 awseq= multi.getParameter("awseq");
			 awgetDate= multi.getParameter("awgetDate");
			 awname= multi.getParameter("awname");
			 awagency= multi.getParameter("awagency");
			 trseq= multi.getParameter("trseq");
			 trstartDate= multi.getParameter("trstartDate");
			 trendDate= multi.getParameter("trendDate");
			 trname= multi.getParameter("trname");
			 trtype= multi.getParameter("trtype");
			 tragency= multi.getParameter("tragency");
			 abseq= multi.getParameter("abseq");
			 abstartDate= multi.getParameter("abstartDate");
			 abendDate= multi.getParameter("abendDate");
			 abtype= multi.getParameter("abtype");
			 abcountry= multi.getParameter("abcountry");
			 abnote= multi.getParameter("abnote");
			 laseq= multi.getParameter("laseq");
			 language= multi.getParameter("language");
			 level= multi.getParameter("level");
			 prseq= multi.getParameter("prseq");
			 prtype= multi.getParameter("prtype");
			 prnote= multi.getParameter("prnote");
			 poseq= multi.getParameter("poseq");
			 pourl= multi.getParameter("pourl");
			filename = multi.getFilesystemName("attach");
			orgfilename = multi.getOriginalFileName("attach");

			
			ResumeDAO dao = new ResumeDAO();
			ResumeDTO dto = new ResumeDTO();
			dto.setResumeSeq(rseq);
			dto.setOrgfileName(title);
			dto.setIntroduce(info);
			dto.setEmail(email);
			dto.setName(name);
			dto.setPhone(phone);

			
			  dao.resumeEdit(dto);
			
			ArrayList<ExperienceDTO> exlist = new ArrayList<ExperienceDTO>();
			
					
			for( ExperienceDTO exdto : exlist ) {
				
				exdto.setExperienceseq(exseq);
				exdto.setField(exfield);
				exdto.setCompany(excompany);
				exdto.setJob(exjob);
				exdto.setStartdate(exstartDate);
				exdto.setEnddate(exendDate);
				
				exlist.add(exdto);
				
			}
			dao.experienceEdit(exlist);
			
			

			
		} catch (Exception e) {
			System.out.println(e);
		}
		


	}
}

