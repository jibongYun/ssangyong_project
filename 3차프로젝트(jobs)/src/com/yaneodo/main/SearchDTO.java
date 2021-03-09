package com.yaneodo.main;

public class SearchDTO {
	
	//기업 정보
	private String companySeq;
	private String companyName;
	private String industry;
	private String companyPhoto;
	
	//공고 -> 직무 정보
	private String jobOpeningSeq;
	private String title;
	private String job;
	private String place;
	private String jobPhoto;
	
	
	public String getCompanySeq() {
		return companySeq;
	}
	public void setCompanySeq(String companySeq) {
		this.companySeq = companySeq;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getCompanyPhoto() {
		return companyPhoto;
	}
	public void setCompanyPhoto(String companyPhoto) {
		this.companyPhoto = companyPhoto;
	}
	public String getJobOpeningSeq() {
		return jobOpeningSeq;
	}
	public void setJobOpeningSeq(String jobOpeningSeq) {
		this.jobOpeningSeq = jobOpeningSeq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getJobPhoto() {
		return jobPhoto;
	}
	public void setJobPhoto(String jobPhoto) {
		this.jobPhoto = jobPhoto;
	}


}
