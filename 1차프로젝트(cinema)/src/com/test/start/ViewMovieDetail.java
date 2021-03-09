package com.test.start;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Scanner;

import data.Path;
import data.ScreenInfoDetail;

//조아라 구현 -> 영화 상세 정보 보기
public class ViewMovieDetail {
	
	private static ArrayList<ScreenInfoDetail> allMoviesInfoList=new ArrayList<ScreenInfoDetail>(); // 모든 영화의 제목과 감독을 모아서 보여줄 용도
	private static Calendar now=Calendar.getInstance();
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		showHeader();
		
		
		/* 시작메뉴
		 * 
		 * 1. 회원별 예매
		 * 2. 비회원별 예매
		 * .
		 * .
		 * .
		 * 0. 상영중인 영화 -> 선택하면 여기로 넘어옴!
		 */
		
		// 1. 영화목록 가져오기 -> 메서드 호출해서 재활용? -> 불가능 -> 코드 자체를 재활용 -> getAllMovieInfo()
		// 2. 영화목록 보여주기 -> showAllMovieInfo()
		while(true) {
			getAllMoviesInfo();
			sortInfoByLatest(allMoviesInfoList);
			showAllMoviesInfo();
			int selectMenu=showMenu();
			if (selectMenu==1) { // 뒤로가기
				Start.main(null);
			}else if (selectMenu==2){ // 종료
				System.exit(0);
			}else {
				System.out.println("\t\t\t잘못된 메뉴 선택입니다.");
			}
		}
	}
	
	// 보여줄 영화들 목록만드는 메서드
	private static void getAllMoviesInfo() {
		
		Path path = new Path();
		String PATH=path.moviePath+"movieList.txt";
		File allMoviesInfo = new File(PATH);
		//파일 프로세싱 -> 영화 리스트 add
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(PATH));
			if (allMoviesInfo.exists()) {

				// 파일이 존재한다면 파일을 읽으면서 영화 객체를 만들어서 객체리스트인 allMoviesInfoList에 넣는다.
				String line=null;
				
				
				while((line=reader.readLine())!=null) {
					
					String[] movieInfo=line.split("■");
					// 현재 상영중인 영화여야 한다는 조건!
					// 즉, 상영종료일-현재날짜가 양수여야 한다!
					long nowTick=now.getTimeInMillis();
					//상영종료일 movieInfo[4]
					int year=Integer.parseInt(movieInfo[4].substring(0, 4)); // 연도만
					int month=Integer.parseInt(movieInfo[4].substring(5, 7)); // 월만
					int date=Integer.parseInt(movieInfo[4].substring(8, 10)); // 날짜만
					
					Calendar end=Calendar.getInstance();
					end.set(year, month-1, date);
					long endTick=end.getTimeInMillis();
					
					if (endTick-nowTick>=0) {
						ScreenInfoDetail eachMovie=new ScreenInfoDetail(movieInfo[0], // 영화제
																		movieInfo[1], // 장르
																		movieInfo[2], // 상영시간(러닝타임)
																		movieInfo[3], // 상영시작일
																		movieInfo[4], // 상영종료일
																		movieInfo[5], // 별점
																		movieInfo[6], // 감독
																		movieInfo[7], // 배우
																		movieInfo[8]); // 줄거리
						allMoviesInfoList.add(eachMovie);
					}
				}
				
			}else {
				System.out.println("\t\t\tError! 영화 정보 파일이 존재하지 않습니다."); // 파일이 존재하지 않으면 에러 출력.
			}
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println("Exception! Screen_MovieList, main()");
			e.printStackTrace();
		}
	}
	
	// 모여진 영화목록을 보여줄 메서드
	private static void showAllMoviesInfo() {
		for (int i=0;i<allMoviesInfoList.size();i++) {
			System.out.printf("%s  |  %s  |  %s  | ★ %s\n", // 윗줄 영화제목, 감독, 배우, 별점 순으로 출력
					allMoviesInfoList.get(i).getTitle(), // 영화제목
					allMoviesInfoList.get(i).getDirector(), // 감독
					allMoviesInfoList.get(i).getActor(), // 배우
					allMoviesInfoList.get(i).getStar()); // 별점
			System.out.println("-----------------------------------------------------------------------------------------------");
			for(int j=0;j<allMoviesInfoList.get(i).getScenario().length();j++) {
				if (j%45==0) {
					System.out.println();
				}
				System.out.print(allMoviesInfoList.get(i).getScenario().charAt(j)); // 줄거리
			}
			System.out.println(); // 보기편하게 각 영화별 정보 사이에 공간 넣어주는 역할
			System.out.println(); // 보기편하게 각 영화별 정보 사이에 공간 넣어주는 역할
			System.out.println(); // 보기편하게 각 영화별 정보 사이에 공간 넣어주는 역할
		}
	}
	
	// 헤더 보여줄 메서드
	private static void showHeader() {
		System.out.println("===============================================================================================");
		System.out.println("[ 쌍 용 영 화 관 ]");
		System.out.println("\t\t\t\t현재 상영중인 영화정보");
		System.out.println();
		System.out.println("===============================================================================================");
	}
	
	// 영화를 최신순으로 정렬해주는 메서드
	public static void sortInfoByLatest(ArrayList<ScreenInfoDetail> allMoviesInfoList) {
		allMoviesInfoList.sort(new Comparator<ScreenInfoDetail>() {

			@Override
			public int compare(ScreenInfoDetail info1, ScreenInfoDetail info2) {
				return info1.getReleaseDate().compareTo(info2.getReleaseDate());
				
			}
		});
	}
	
	// 메뉴 보여줄 메서드
	public static int showMenu(){
			
		System.out.println("===============================================================================================");
		System.out.println("\t\t\t1. 뒤로가기");
		System.out.println("\t\t\t2. 종료");
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.printf("\t\t번호를 선택해주세요(ex: 1) : ");
		
		int selectMenu=scan.nextInt(); 
		
		return selectMenu;
	}

}
