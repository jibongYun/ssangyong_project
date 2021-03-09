package data;

public class ScreenInfo {

	private String sNum;	//영상번호
	private String title;			//영화제목
	private String branch;			//지점
	private String theaterNum;			//상영관
	private String sTime;			//시작시간
	private String eTime;			//종료시간
	private String seat;
	private String date;			//날짜
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getsNum() {
		return sNum;
	}

	public void setsNum(String sNum) {
		this.sNum = sNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getTheaterNum() {
		return theaterNum;
	}

	public void setTheaterNum(String theaterNum) {
		this.theaterNum = theaterNum;
	}

	public String getsTime() {
		return sTime;
	}

	public void setsTime(String sTime) {
		this.sTime = sTime;
	}

	public String geteTime() {
		return eTime;
	}

	public void seteTime(String eTime) {
		this.eTime = eTime;
	}
	
	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}


	public ScreenInfo(String sNum, String branch, String theaterNum, String title,  String sTime, String eTime, String seat, String date) {
		
		this.sNum = sNum;
		this.branch = branch;
		this.title = title;
		this.theaterNum = theaterNum;
		this.sTime = sTime;
		this.eTime = eTime;
		this.seat = seat;
		this.date = date;
	}

	public ScreenInfo() {
		// TODO Auto-generated constructor stub
	}
}
