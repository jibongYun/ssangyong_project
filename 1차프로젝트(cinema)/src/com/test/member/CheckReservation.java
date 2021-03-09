package com.test.member;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

import data.Path;
import data.UsedPC;

public class CheckReservation {

	static String coupon = "";
	static String point = "";

	public static void main(String[] userInfo, String[] movieInfo) {

		//무비인포 네이밍 
		String branch = movieInfo[2];
		String theaterN=movieInfo[3];
		String title = movieInfo[4];
		String sTime = movieInfo[5];
		String eTime = movieInfo[6];
		String selectedSeat = movieInfo[9];
		String price = movieInfo[8];

		System.out.println("===============================================================================================");
		System.out.println("[ 쌍 용 영 화 관 ]");
		System.out.println("\t\t\t\t예 매 내 역 확 인");
		System.out.println();
		System.out.println("===============================================================================================");
		System.out.printf("\t\t\t\t\t%s %s관\n\t\t\t영화 제목 : %s\n\t\t\t상영시간 : %s - %s\n\t\t\t좌석 : %s\n\t\t\t가격 : %s\n"
				,branch,theaterN,title,sTime,eTime,selectedSeat,price);
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("\t\t\t1. 결제하기");
		System.out.println("\t\t\t2. 되돌아가기");
		System.out.println("\t\t\t3. 종료");
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.print("\t\t번호를 입력하세요.(ex :1) : ");
		Scanner input = new Scanner(System.in);
		String num = input.nextLine();

		if(num.equals("1")) {

			price = payment(userInfo, price);
			movieInfo[8] = price;
			UsedPC used = new UsedPC(point, coupon);
			Payment.main(userInfo, movieInfo, used);

		} else if(num.equals("2")) {
			for(int i=0; i<movieInfo.length; i++)
				movieInfo[i] = null;   //초기화

			BookingMovie.main(userInfo);


		} else if(num.equals("3")) {
			System.exit(0);
		}

	}//main

	private static String payment(String[] userInfo, String price) {

		Scanner scan = new Scanner(System.in);
		System.out.println("===============================================================================================");
		System.out.println("[ 쌍 용 영 화 관 ]");
		System.out.println("\t\t\t\t포인트 및 쿠폰 사용");
		System.out.println();
		System.out.println("===============================================================================================");
		System.out.println("\t\t\t포인트 사용을 하시겠습니까? (y/n)");
		System.out.print("\t\t\t입력 (ex: y): ");
		String num = scan.nextLine();

		if(num.toLowerCase().equals("y")) {
			price = UsePoint(userInfo, price);
			System.out.println("\t\t\t쿠폰을 사용 하시겠습니까?(y/n) ");
			System.out.print("\t\t\t입력 (ex: y): ");
			num = scan.nextLine();
			if(num.toLowerCase().equals("y")) {
				price = UseCoupon(userInfo, price);
			} else {
				return price;
			}
		} else {
			System.out.println("\t\t\t쿠폰을 사용 하시겠습니까?(y/n) ");
			System.out.print("\t\t\t입력 (ex: y): ");
			num = scan.nextLine();
			if(num.toLowerCase().equals("y")) {
				price = UseCoupon(userInfo, price);
			} else {
				return price;
			}
		}
		return price;

	}

	private static String UseCoupon(String[] userInfo, String price) { //쿠폰사용 

		System.out.println("===============================================================================================");
		System.out.println("/t/t보유하고 있는 쿠폰목록입니다.");
		try { // 쿠폰목록 가져오기
			Path path = new Path();
			String readPath = path.userPath+ "userCoupon\\" + userInfo[0] + ".txt";
			BufferedReader reader = new BufferedReader(new FileReader(readPath));
			String line = null;

			LinkedList<String> list = new LinkedList<String>();
			while((line = reader.readLine()) != null) {
				list.add(line);// 파일에있는 쿠폰번호를 리스트로 담음.
			}
			reader.close();

			for(int i=0; i<list.size(); i++) { 
				System.out.printf("\t\t%s. %s\n",i+1,list.get(i)); //담았던 쿠폰목록을 출력
			}

			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.print("\t\t사용할 쿠폰 번호를 입력해 주세요 (ex: 1) : ");
			Scanner scan = new Scanner(System.in);
			int num = Integer.parseInt(scan.nextLine());

			if(num>=1 && num<=list.size()) { //입력받은 넘버 유효성 검사
				for(int i=0; i<list.size(); i++) { // 리스트에 있는 쿠폰 사용
					if((num-1)==i) { 

						if(list.get(i).equals("discount3")) {
							coupon = "discount3";
							System.out.println("-----------------------------------------------------------------------------------------------");
							System.out.println("\t\t\t쿠폰이 선택되었습니다.");
							list.clear();
							price = (Integer.parseInt(price)-3000) + "";
							return price;


						} else if (list.get(i).equals("discount5")) {
							coupon = "discount5";
							System.out.println("-----------------------------------------------------------------------------------------------");
							System.out.println("\t\t\t쿠폰이 선택되었습니다.");
							price = (Integer.parseInt(price)-5000) + "";
							list.clear();
							return price;

						} else {
							System.out.println("\t\t\t유효하지않는 번호입니다.");
							break;
						}
					}// if
				}//for

			}//유효성검사 if닫음
		}//try

		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return price;

	}

	private static String UsePoint(String[] userInfo, String price) { //포인트 사용
		Path path = new Path(); //경로
		String readPath = path.userPath + "userInfo\\" + userInfo[0] + ".txt" ; //경로
		try {

			BufferedReader reader = new BufferedReader(new FileReader(readPath));
			String line = "";

			line = reader.readLine();
			String[] info = line.split("■"); //포인트 쪼개기 

			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.printf("\t\t\t회원님의 잔여 포인트 : %s\n" , info[1]); //현재 있는 포인트 출력
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.println("\t\t\t사용할 포인트값을 입력해 주세요");
			System.out.print("\t\t\t입력(ex: 1000) : ");
			Scanner scan = new Scanner(System.in);
			String input = scan.nextLine();

			//포인트
			if(Integer.parseInt(info[1])-Integer.parseInt(input) > 0) { //포인트값유효성검사 
				point = input;
				price = (Integer.parseInt(price)-Integer.parseInt(input)) + "";

				System.out.println("-----------------------------------------------------------------------------------------------");
	            System.out.printf("\t\t\t사용된 포인트 값은 %s점 입니다. \n",input); //사용포인트
	            System.out.printf("\t\t\t잔여 포인트 : %d\n"
						,(Integer.parseInt(info[1])-Integer.parseInt(input))); 

				return price;
			}   else {
	 			System.out.println("-----------------------------------------------------------------------------------------------");
	            System.out.println("\t\t\t포인트가 부족합니다. 다시 입력해주세요");
				UsePoint(userInfo, price);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return price;

	}
}