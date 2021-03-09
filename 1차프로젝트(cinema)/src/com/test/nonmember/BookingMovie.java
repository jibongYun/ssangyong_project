package com.test.nonmember;

import java.util.Scanner;

public class BookingMovie {

	public static void main(String[] args)  {
		
		Scanner scan = new Scanner(System.in);

		while(true) {
			System.out.println("===============================================================================================");
			System.out.println("[ 쌍 용 영 화 관 ]");
			System.out.println("===============================================================================================");
			System.out.println("\t\t\t\t1. 영화별 예매");
			System.out.println("\t\t\t\t2. 영화관별 예매");
			System.out.println("\t\t\t\t3. 예매내역조회");
			System.out.println("\t\t\t\t4. 로그아웃(종료)");
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.print("\t\t\t번호를 입력하세요.(ex: 1) : ");
			String sel = scan.nextLine();
			
			if(sel.equals("5")) {
				System.out.println("\t\t프로그램을 종료합니다.");
				break;
			}
			
			switch(sel) {
				case "1":
					MovieList.main(null);
					break;
				case "2":
					ChooseTheater.main(null);
					break;
				case "3":
					ViewReservation.main(null);
					break;
				case "4":
					System.exit(0);
					break;
				default:
					System.out.println("\t\t잘못된 접근입니다.");
			}
		}
	}
}

