package com.test.member;

//정경화님 구현부 -> 영화관 선택

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import data.Path;
import data.ScreenInfo;


public class ChooseTheater {

	public static void main(String[] userInfo) {

		Scanner scan = new Scanner(System.in);
		ArrayList<ScreenInfo> movieList = new ArrayList<ScreenInfo>();
		String[] movieInfo = new String[8];

		//1. 지점 선택하기
		//지점 선택
		String branch = selectBranch();

		//2. 선택한 지점의 오늘 날짜 상영 목록 보여주기
		Calendar c = Calendar.getInstance();

		int addDate = 0;
		Boolean loop = true;

		while(loop) {

			if (addDate < 3) {

				System.out.println("-------------------------------------------------------------------------------------------------------------");
				System.out.printf("                                            %d년 %d월 %d일\n", c.get(Calendar.YEAR), c.get(Calendar.MONTH)+1, c.get(Calendar.DATE));
				System.out.println("-------------------------------------------------------------------------------------------------------------");
				System.out.println("\t[상영번호]\t[상영관번호]\t\t[영화제목]\t[시작시간]\t[종료시간]\t[예약현황]");
				movieList = getMovie(branch, addDate);	//지점 영화 리스트 호출
				showMovie(movieList);
				System.out.println("===============================================================================================");
				System.out.println("\t\t\t1. 영화 선택");
				System.out.println("\t\t\t2. 다음 날짜 보기");
				System.out.println("\t\t\t3. 종료");
				System.out.println("-----------------------------------------------------------------------------------------------");
				System.out.print("\t\t\t번호를 입력하세요.(ex: 1) : ");
				int sel = scan.nextInt();

				if (sel == 1) {
					movieInfo = selectMovie(movieList);
					loop = false;
					ChooseSeat.main(userInfo, movieInfo);
				} else if (sel == 2) {
					addDate++;
					c.add(Calendar.DATE, 1);
				} else if (sel == 3) {
					loop = false;
				}	

			} else { //if
				System.out.println("\t\t\t마지막 페이지입니다.");
				System.out.println("\t\t\t첫번째 페이지로 돌아갑니다.");
				addDate = 0; //오늘 날짜로 초기화
				c = Calendar.getInstance(); //오늘 날짜로 초기화
			}
		} //while


	} //main

	private static String selectBranch() {//지점선택메서드

		boolean loop = true;
		Scanner scan = new Scanner(System.in);
		Path path = new Path();
		String readPath = path.theaterPath;
		File file = new File(readPath);
		File[] files = file.listFiles();
		ArrayList<String> branches = new ArrayList<String>();

		for(File fileName : files)
			branches.add(fileName.getName());

		while(loop) {
			System.out.println("===============================================================================================");
			System.out.println("[ 쌍 용 영 화 관 ]");
			System.out.println("\t\t\t\t극 장 목 록");
			System.out.println();
			System.out.println("===============================================================================================");
			for(int i=0; i<branches.size(); i++)
				System.out.printf("\t\t\t%d. %s\n",i+1,branches.get(i));
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.print("\t\t극장 번호를 입력하세요.(ex: 1) : ");

			int sel = Integer.parseInt(scan.nextLine());   //지점선택

			if(sel > 0 && sel <= branches.size())
				return branches.get(sel-1);
			else {
				System.out.println("/t/t잘못된 번호입니다. 번호를 다시 입력해주세요.");
				System.out.println();
			}
		}
		return null;

	}

	// 선택한 영화 ArrayList return
	// n -> 1: 당일, 2: 내일, 3: 내일 모레
	// movieNum -> 상영번호
	private static String[] selectMovie(ArrayList<ScreenInfo> movieList)  {

		Scanner scan = new Scanner(System.in);
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.print("\t\t관람할 영화의 상영 번호를 선택해주세요.(ex: 1) : ");	
		int movieNum = scan.nextInt(); //상영번호 선택

		String[] movieInfo = new String[8];	//배열 형태로 저장해줌.
		movieInfo[0] = movieList.get(movieNum-1).getsNum();		//상영번호
		movieInfo[1] = movieList.get(movieNum-1).getDate();			//상영날짜
		movieInfo[2] = movieList.get(movieNum-1).getBranch();		//지점
		movieInfo[3] = movieList.get(movieNum-1).getTheaterNum();	//상영관
		movieInfo[4] = movieList.get(movieNum-1).getTitle();		//제목
		movieInfo[5] = movieList.get(movieNum-1).getsTime();		//시작시간
		movieInfo[6] = movieList.get(movieNum-1).geteTime();		//종료시간
		movieInfo[7] = movieList.get(movieNum-1).getSeat();			//좌석현황

		return movieInfo;

	}		

	//상영중인 영화를 날짜 순으로 출력
	private static void showMovie(ArrayList<ScreenInfo> movieList) { //해당 날짜 영화 리스트 출력

		int max = 0;

		for (ScreenInfo list : movieList) {	
			max = list.getTitle().length();
			if (max > 0 && max <= 2) {
				System.out.printf("\t%5s\t\t%5s관\t\t%13s\t\t%7s\t\t%7s\t\t  "
						, list.getsNum(), list.getTheaterNum(), list.getTitle(), list.getsTime(), list.geteTime());
							//상영번호			상영관번호				//영화제목		//시작시간		//종료시간
				
			} else if (max > 2 && max < 9) {
				System.out.printf("\t%5s\t\t%5s관\t\t%13s\t%7s\t\t%7s\t\t  "
						, list.getsNum(), list.getTheaterNum(), list.getTitle(), list.getsTime(), list.geteTime());
				
			} else if (max >= 9) {
				System.out.printf("\t%5s\t\t%5s관\t\t%13s\t%7s\t\t%7s\t\t  "
						, list.getsNum(), list.getTheaterNum(), list.getTitle(), list.getsTime(), list.geteTime());
			} 	
			reservedCheck(list.getSeat());         
	   } 
		
	}

	private static void reservedCheck(String seat) {//예약 자리 확인

		int count = 0;
		for(int i=0; i<seat.length(); i++) {
			if(seat.charAt(i) == '0')
				count++;
		}
		System.out.printf("[%d/%d]\n",count,seat.length());

	}

	//ArrayList에 영화 정보 담기
	public static ArrayList<ScreenInfo> getMovie(String branch, int addDate) {//지점 영화리스트 get메서드
		Path path = new Path();	//data.Path -> data패키지.Path클래스 호출
		String readPath = path.theaterPath + branch + "\\";	//디렉터리 주소 parsing

		//당일 + addDate만큼의 시간표 (+0, +1, +2)
		Calendar today = Calendar.getInstance();
		today.add(Calendar.DATE, addDate);

		String date = String.format("%d-%02d-%02d", today.get(Calendar.YEAR), today.get(Calendar.MONTH)+1, today.get(Calendar.DATE));
		ArrayList <ScreenInfo> movieList = new ArrayList<ScreenInfo>();

		try {
			readPath = readPath + date + ".txt";	//최종 파일 주소 parsing
			BufferedReader reader = new BufferedReader(new FileReader(readPath));

			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] movieInfo = line.split("■");
				movieList.add(new ScreenInfo(movieInfo[0], movieInfo[1], movieInfo[2], movieInfo[3], movieInfo[4], movieInfo[5], movieInfo[6], date));			
			}
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
		//만든 리스트 리턴
		return movieList;
	}	

}
