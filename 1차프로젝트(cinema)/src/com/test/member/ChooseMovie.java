package com.test.member;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Scanner;

import data.Path;
import data.ScreenInfo;

public class ChooseMovie {

	private static ArrayList<File> allBranches=new ArrayList<File>();
	private static ArrayList<ScreenInfo> allScreenInfo = new ArrayList<ScreenInfo>();
	private static Scanner scan = new Scanner(System.in);
	static ScreenInfo finalSelectMovie;
	// 1. 영화목록 보여주기(while문) -> 뒤로가기 선택하면 break
	// 넘겨받은 영화 제목으로 theater폴더 접근해서 각 지점폴더 돌면서
	// 3일치자료 ArrayList에 넣기
	// 그리고 3일치 상영정보보여주기
	// 선택 하나 하면 끝.

	public static void main(String[] userInfo, String selectedTitle) {
		
		
		// 고객이 선택한 영화정보를 넘겨받았고,
		// 이제 theater폴더 접근해서 각 지점 폴더 돌면서 3일치자료 ArrayList에 넣으면 된다.
		// 찾아야할 영화제목
		Path data = new Path();
		String PATH= data.theaterPath;
		File branches=new File(PATH);
		
		try {
			String findTitle=selectedTitle;	
			
			if (branches.exists()) {
				// 각 지점 폴더들을 branches리스트에 넣는다.
				for(File each:branches.listFiles()) {
					allBranches.add(each);
				}
				// 각 지점별 변수를 생성하고, 3일치 파일을 읽어온다.
				// allBranches 리스트 내용은 아래와 같다.

				// 읽어와야하는 파일은 ~/지점1/날짜별 파일

				// 아래의 branchPath에 오늘날짜, 내일날짜, 내일모레날짜를 각각 더해서
				// 파일 읽어와서 ArrayList에 넣는다.
				for(int i=0; i<allBranches.size();i++) {
					String branchPath=allBranches.get(i).toString(); // theater폴더 속 각 지점 폴더의 PATH
					// 3일치자료만 필터링해줄 3일치의 변수를 만든다.
					// 오늘
					Calendar now=Calendar.getInstance();
					String today=String.format("%d-%02d-%02d", now.get(Calendar.YEAR), now.get(Calendar.MONTH)+1, now.get(Calendar.DATE));
					
					// 내일
					Calendar plusOneDay=Calendar.getInstance();
					plusOneDay.add(Calendar.DATE, 1);
					String tomorrow=String.format("%d-%02d-%02d", plusOneDay.get(Calendar.YEAR), plusOneDay.get(Calendar.MONTH)+1, plusOneDay.get(Calendar.DATE));
					
					// 내일모레
					Calendar plusTwoDay=Calendar.getInstance();
					plusTwoDay.add(Calendar.DATE, 2);
					String dayAfterTomorrow=String.format("%d-%02d-%02d", plusTwoDay.get(Calendar.YEAR), plusTwoDay.get(Calendar.MONTH)+1, plusTwoDay.get(Calendar.DATE));
					
					File branchDir=new File(branchPath); // 각 지점 폴더
					File[] eachBranch=branchDir.listFiles(); // eachBranch는 각 지점 폴더 안의 날짜이름으로된 파일을 가리킨다.
					
					// TODO 합치면서 .DS_Store 이 부분 제거해도 상관없음!
					// 맥북에서 작업하느라 필요했던 부분.
					// .DS_Store 제거
					if (eachBranch==null) {
						continue;
					}
					// TODO 이 부분까지 삭제해도 상관없음!

					// 3일의 날짜를 path 뒤에 붙여서 파일 불러오기
					// 제목, 지점주소, 파일텍스트명
					makeAllScreenInfo(findTitle, branchPath, today);
					makeAllScreenInfo(findTitle, branchPath, tomorrow);
					makeAllScreenInfo(findTitle, branchPath, dayAfterTomorrow);
				}

				//for문
			}else {
				System.out.println("\t\t\tError! 극장 정보 폴더가 존재하지 않습니다.");
			}

			// 루프들어가기전에
			// 상영내역정보가 들어있는 ArrayList를 최신순으로 정렬
			sortByLatest(allScreenInfo);

			boolean loop=true;
			int i=0;
			int j=0;
			int linePerPage=15;
			
			while(loop) {	//영화목록 출력 //15배수일때 수정
				for (i=0;i<(allScreenInfo.size()/linePerPage)+1;i++) {
					showHeader(i, allScreenInfo.size(), linePerPage);
					
					for (j=i*linePerPage;j<(linePerPage+i*linePerPage);j++) {
						
						if (j>=allScreenInfo.size()) {
							break;
						}else {
							ScreenInfo temp=allScreenInfo.get(j);
							System.out.printf("\t%d. %s | %s | %s | %s관 | %s | %s | %d석 / 25석\n",j+1, temp.getTitle(), temp.getDate(), temp.getBranch()
									, temp.getTheaterNum(), temp.getsTime(), temp.geteTime(), countVacancy(temp));
						}
					}	//for
					
					// 메뉴 출력 및 메뉴 선택
					int selectMenu = showMenu();
					
					if (selectMenu==1) { // 이전목록 선택
						if(i==0){
							i-=1;
						}else{
							i-=2;
						}
					}else if (selectMenu==2){ // 다음목록 선택
						if (j>=allScreenInfo.size()){
							i -= 1;
						}
						
					}else if (selectMenu==3) { // 영화 선택
						System.out.print("\t\t\t상영번호 선택 :");
						int selectInfoNum = scan.nextInt()-1; // 그 페이지에서의 번호
						if(selectInfoNum>allScreenInfo.size()||selectInfoNum<0){
							System.out.println("-----------------------------------------------------------------------------------------------");
							System.out.println("\t\t\t잘못된 상영번호입니다.");
							System.out.println("-----------------------------------------------------------------------------------------------");
							i -= 1;
						}else{
							finalSelectMovie=allScreenInfo.get(selectInfoNum);
							loop = false;
							break;
						}
					}else if (selectMenu==4) { // 뒤로가기
						MovieList.main(null);
					}else if (selectMenu==5) { // 프로그램 종료
						System.exit(0);
					}else {
						System.out.println("\t\t\t잘못된 메뉴 선택입니다.");
						break;
					
					}
				}
				// 영화목록 15개 표시된 상태
			}//while
		}catch (Exception e) {
			System.out.println("Exception! Screen_ChooseMovie, showScreenList()");
			e.printStackTrace();
		}
		
		//1■광화문점■3■덤보■08:00■10:00■0100100101100010100111110
		String movieInfo[] = new String[8];	//문자열로 받아서 호출
		movieInfo[0] = finalSelectMovie.getsNum();
		movieInfo[1] = finalSelectMovie.getDate();
		movieInfo[2] = finalSelectMovie.getBranch();
		movieInfo[3] = finalSelectMovie.getTheaterNum();
		movieInfo[4] = finalSelectMovie.getTitle();
		movieInfo[5] = finalSelectMovie.getsTime();
		movieInfo[6] = finalSelectMovie.geteTime();
		movieInfo[7] = finalSelectMovie.getSeat();
		allScreenInfo.removeAll(allScreenInfo);	//뒤로가기로 오면 다시 쓰기위해 전부 다 삭제
		allBranches.removeAll(allBranches);
		
		ChooseSeat.main(userInfo, movieInfo);
		
	}	//main

	public static int showMenu(){
		
		System.out.println("===============================================================================================");

		System.out.println("\t\t1.이전 목록\t\t2.다음 목록");
		System.out.println("\t\t3.상영정보 선택\t\t4.뒤로 가기");
		System.out.println("\t\t5.종료");
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.printf("\t\t\t번호를 입력하세요(ex: 1) : ");
		
		int selectMenu=scan.nextInt(); 
		
		return selectMenu;
	}

	public static void showHeader(int i, int total, int linePerPage) {
		// 목록 총 개수가 15개 이하라면 1로 표시,
		// 15개 이상인데 15로 나누어진다면 total/linePerPage-1로 표시
		// 15개 이상이면서 15로 나누어지지 않는다면 total/linePerPage+1
		int showTotal=(total<=15)?1:(total%linePerPage==0)?total/linePerPage-1:total/linePerPage+1;
		System.out.println("===============================================================================================");
		System.out.println("[ 쌍 용 영 화 관 ]");
		System.out.printf("\t\t\t\tB O X O F F I C E [ %d/%d ]\n",i+1, showTotal);
		System.out.println();
		System.out.println("===============================================================================================");
	}

	// 빈 좌석을 세서 상영내역 리스트에서 보여주는 메서드
	// 0 이면 이용가능한 좌석, 1 이면 이미 예매된 좌석
	public static int countVacancy(ScreenInfo screenInfo) {	//빈자리 확인용
		int count=0;
		for (int i=0;i<screenInfo.getSeat().length();i++) {
			if ((screenInfo.getSeat().charAt(i))=='0'){
				count++;
			}
		}
		return count;
	}

	// 상영내역을 최신순으로 정렬해주는 메서드
	public static void sortByLatest(ArrayList<ScreenInfo> allScreenInfo) {
		allScreenInfo.sort(new Comparator<ScreenInfo>() {

			@Override
			public int compare(ScreenInfo info1, ScreenInfo info2) {
				return info1.getDate().compareTo(info2.getDate());
			}
		});
	}

	//  선택된 영화, 지점, 날짜	
	public static void makeAllScreenInfo(String findTitle, String branchPath, String date) throws NumberFormatException {
		File eachFile=new File(branchPath+"\\"+date+".txt");

		if (eachFile.exists()) { //파일이 존재하면
			try {
				BufferedReader reader=new BufferedReader(new FileReader(eachFile)); // 오늘 날짜 이름의 파일의 PATH
				
				String line=null;
				
				while((line=reader.readLine())!=null) {
					
					String[] screenInfo=line.split("■");
					
					if (screenInfo[3].equals(findTitle)) {
						
						ScreenInfo info= new ScreenInfo(
										screenInfo[0] 	//상영번호
										, screenInfo[1]	//지점
										, screenInfo[2]	//상영관
										, screenInfo[3]	//제목
										, screenInfo[4]	//시작시간
										, screenInfo[5]	//종료시간
										, screenInfo[6]	//좌석도
												, date);//상영일
						allScreenInfo.add(info);
					}
					
				}//while
				reader.close();
			} catch (Exception e) {
				System.out.println("Screen_ChooseMovie.makeAllScreenInfo()");
				e.printStackTrace();
			}	//try ~ catch
		}else {	//파일이 존재하지 않으면
			System.out.printf("\t\t\tError! %s폴더에 %s의 파일이 존재하지 않습니다.\n", branchPath.substring(branchPath.lastIndexOf('/')), date);
		} // if~else
	}

}
