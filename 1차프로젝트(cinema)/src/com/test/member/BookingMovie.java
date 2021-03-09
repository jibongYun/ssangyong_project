package com.test.member;

import java.util.Scanner;

import com.test.snack.BuySnack;

//장진영 구현 -> 로그인 후 예매
public class BookingMovie {

	public static void main(String[] userInfo) {
		
		//회원예매
	
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("===============================================================================================");
			System.out.println("[ 쌍 용 영 화 관 ]");
			System.out.printf("\t\t\t\t%s님 환영합니다!\n",userInfo[0]);
			System.out.println();
			System.out.println("===============================================================================================");
			System.out.println("\t\t\t\t1. 영화별 예매");
			System.out.println("\t\t\t\t2. 영화관별 예매");
			System.out.println("\t\t\t\t3. 예매내역조회");
			System.out.println("\t\t\t\t4. 개인정보조회");
			System.out.println("\t\t\t\t5. 스낵구매");
			System.out.println("\t\t\t\t6. 로그아웃(종료)");
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.print("\t\t\t번호를 입력하세요.(ex: 1) : ");
			String sel = scan.nextLine();
			
			if(sel.equals("6")) {
				System.out.println("\t\t\t프로그램을 종료합니다.");
				System.exit(0);
			}
			
			switch(sel) {
				case "1":
					MovieList.main(userInfo);
					break;
				case "2":
					ChooseTheater.main(userInfo);
					break;
				case "3":
					ViewReservation.main(userInfo);
					break;
				case "4":
					ViewUserInfo.main(userInfo);
					break;
				case "5":
					BuySnack.main(userInfo);
					break;
				default:
					System.out.println("\t\t\t잘못된 접근입니다.");
			}
			
			
			
		}
	}

}

