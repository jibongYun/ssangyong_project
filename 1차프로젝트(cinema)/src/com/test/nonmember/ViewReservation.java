package com.test.nonmember;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import data.Path;

public class ViewReservation {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("===============================================================================================");
			System.out.println("[ 쌍 용 영 화 관 ]");
			System.out.println("\t\t\t\t예매내역 확인");
			System.out.println();
			System.out.println("===============================================================================================");;
			System.out.println("\t\t\t정보 확인을 위해 전화번호를 입력하세요.");
			System.out.print("\t\t\t전화번호 : ");
			System.out.println("정보 확인을 위해 전화번호를 입력하세요.");
			System.out.print("전화번호 : ");
			String phone = scan.nextLine();

			Path data = new Path();
			try {

				String path = data.reservationPath + "nonmember";

				File file = new File(path);

				String[] list = file.list();
				

				// String phoneNum;
				for (String title : list) { // 예매고객의 전화번호와 대조
					// System.out.println(title);
					if ((phone + ".txt").equals(title)) { // 같은 번호가 있는지 학인
						// phoneNum = phone;
						BufferedReader reader = new BufferedReader(new FileReader(path + "\\" + title));
						String[] info = reader.readLine().split("■");
						System.out.println("-----------------------------------------------------------------------------------------------");
						System.out.printf("\t\t상영날짜 : %s\n", info[1]); //
						System.out.printf("\t\t지    점 : %s\n", info[2]); //
						System.out.printf("\t\t상 영 관 : %s\n", info[3]); //
						System.out.printf("\t\t제    목 : %s\n", info[4]); //
						System.out.printf("\t\t시작시간 : %s\n", info[5]); //
						System.out.printf("\t\t종료시간 : %s\n", info[6]); //
						System.out.printf("\t\t예약좌석 : %s\n", info[7]); //
						System.out.printf("\t\t최종요금 : %,d\n", Integer.parseInt(info[8])); //
						System.out.println("-----------------------------------------------------------------------------------------------");

						reader.close();

						System.out.println("\t\t\t1.예매 취소하기");
						System.out.println("\t\t\t2. 첫화면으로 돌아가기");
						System.out.println("-----------------------------------------------------------------------------------------------");
						System.out.print("\t\t번호를 입력하세요.(ex: 1) : ");
						String input = scan.nextLine();
						if (input.equals("2")) {
							BookingMovie start = new BookingMovie();
							start.main(args);
						} else if (input.equals("1")) {
							CancelReservation.main(phone);
						
						}

					}
				}

				System.out.println("\t\t\t예매 내역이 없습니다.");
				System.out.println("\t\t\t1. 예매하러가기");
				System.out.println("\t\t\t2. 다시입력하기");
				System.out.println("-----------------------------------------------------------------------------------------------");
				System.out.print("\t\t번호를 입력하세요.(ex: 1) : ");
				int input = Integer.parseInt(scan.nextLine());


				if (input == 1) { // 회원 예매하기 페이지로 간다
					BookingMovie start = new BookingMovie();
					start.main(args);

				} else { // 전화번호를 다시 입력하는 창으로 간다
					main(args);

				}

			} catch (Exception e) {
				System.out.println("Screen_BookChecking.numberCheck()");
				e.printStackTrace();
			}
		}
	}
}
