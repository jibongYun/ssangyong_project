package com.test.member;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import data.Path;

public class MovieList {
	// 1. 영화목록 보여주기(while문) -> 뒤로가기 선택하면 break
	// movieList 읽어서 ArrayList에 넣기!
	// 두 데이터를 String.format으로 묶어서 ArrayList에 전달
	// ArrayList 출력(영화제목, 감독)
	// 인덱스 하나 선택하면 Screen_ChooseMovie로 영화제목 넘겨주기.

	public static ArrayList<String> allMovies=new ArrayList<String>(); // 모든 영화의 제목과 감독을 모아서 보여줄 용도
	private static Scanner scan = new Scanner(System.in);
	private static Calendar now=Calendar.getInstance();
	static int selectMovieNum;

	public static void main(String[] userInfo)  {
		Path data = new Path();
		final String PATH = data.moviePath + "movieList.txt";
		File movies = new File(PATH);
		
		//파일 프로세싱 -> 영화 리스트 add
		if(movies.exists()) {
			try {

				BufferedReader reader = new BufferedReader(new FileReader(PATH));

				// movieList파일을 읽어서 제목(movieInfo[0])과 감독(movieInfo[5])를 String형태로 만들어서 ArrayList에 넣는다.
				// ArrayList에서 꺼내서 보여주고, 그 중 하나를 고르면 그걸 index로 정보를 찾을 계획.
				String line=null;

				while((line=reader.readLine())!=null) {

					String[] movieInfo=line.split("■");
					// 현재 상영중인 영화여야 한다는 조건!
					// 즉, 상영종료일-현재날짜가 양수여야 한다!
					long nowTick=now.getTimeInMillis();
					//상영종료일
					int year=Integer.parseInt(movieInfo[4].substring(0, 4));
					int month=Integer.parseInt(movieInfo[4].substring(5, 7));
					int date=Integer.parseInt(movieInfo[4].substring(8, 10));

					Calendar end=Calendar.getInstance();
					end.set(year, month-1, date);
					long endTick=end.getTimeInMillis();

					if (endTick-nowTick>=0) {	//제목 | 감독 | 배우
						String eachMovie=String.format("\t%s | %s | %s", movieInfo[0], movieInfo[6],movieInfo[7]);
						allMovies.add(eachMovie);
					}
				}

				reader.close();

			} catch (Exception e) {
				System.out.println("Exception! Screen_MovieList, showMovieList()");
				e.printStackTrace();
			}
			
			int listNo = 0;
			int selectMenu;
			while(true) {
				
				showHeader(listNo, (allMovies.size()/15)+1);	// \t\t영화별조회 [ listNo / Total ]		
	
				for (int i=listNo; i<listNo+1 ;i++) {	//한페이지만 보여줄 예정
	
					for (int j=i*15;j<(15+i*15);j++) {
	
						if (j>=allMovies.size()) 	// 영화 목록보다 인덱스가 크면
							break;						// 	출력 중단
						else 
							System.out.printf("\t%d. %s\n",j+1, allMovies.get(j));
	
					}	//2중 for
				}	//1중 for
	
				System.out.println("===============================================================================================");
				System.out.println("\t\t\t1.이전 목록\t\t2.다음 목록");
				System.out.println("\t\t\t3.영화 선택\t\t4.뒤로 가기");
				System.out.println("\t\t\t5.종료");
				System.out.println("===============================================================================================");
				System.out.printf("\t\t번호를 입력하세요.(ex: 1) : ");	
				selectMenu = scan.nextInt();

				if (selectMenu==1) { // 이전목록 선택
					if(listNo==0){	//1페이지일때
						System.out.println("\t\t이전목록이 존재하지 않습니다.");
					}else{		//2페이지부터
						listNo--;
					}
				}else if (selectMenu==2){ // 다음목록 선택
					if(listNo+1 > allMovies.size()/15)	{// 다음목록이 존재하지 않으면
						System.out.printf("\t\t다음 목록이 존재하지 않습니다.\n");
					} else {
						listNo++;
					}
				}else if (selectMenu==3) { // 영화 선택
					System.out.print("\t\t\t영화번호 선택 :");
					selectMovieNum = scan.nextInt()-1; 

					if(selectMovieNum>allMovies.size()||selectMovieNum<0) {	// 그 페이지에서의 번호
						System.out.println("\t\t잘못된 번호 입력입니다.");
					}else{	//영화선택완료
						break;
					}
				}else if (selectMenu==4) { // 뒤로가기
					break;
				}else if (selectMenu==5) { // 프로그램 종료
					System.exit(0);
				}else {
					System.out.println("\t\t잘못된 메뉴 선택입니다.");
				}
			}
			
			if(selectMenu == 3) {	// 영화선택
				int pipeIndex=allMovies.get(selectMovieNum).indexOf("|");		//영화제목 찾기위한 |
				String selectedTitle=allMovies.get(selectMovieNum).substring(0, pipeIndex-1);	//영화제목 subString
				allMovies.clear();		//싹다 지움 -> 휘발성이 아니기때문
				ChooseMovie.main(userInfo, selectedTitle);
			} else if(selectMenu == 4) {
				allMovies.clear();		//싹다 지움 -> 휘발성이 아니기때문
				com.test.nonmember.BookingMovie.main(null);
			}
		}else {
			System.out.println("\t\tError! 영화 정보 파일이 존재하지 않습니다."); // 파일이 존재하지 않으면 에러 출력.
		}
		
		
	}//main


	public static void showHeader(int i, int total) {
		System.out.println("===============================================================================================");
		System.out.println("[ 쌍 용 영 화 관 ]");
		System.out.printf("\t\t\t\t영 화 별 조 회 [ %d / %d ]\n",i+1, total);
		System.out.println();
		System.out.println("===============================================================================================");

	}

}