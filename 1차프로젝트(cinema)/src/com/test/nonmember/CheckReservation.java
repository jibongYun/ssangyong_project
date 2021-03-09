package com.test.nonmember;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

import data.Path;
import data.UsedPC;

public class CheckReservation {

	static String coupon = "";
	static String point = "";

	public static void main(String[] movieInfo) {

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
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.print("\t\t번호를 입력하세요.(ex :1) : ");
		Scanner input = new Scanner(System.in);
		String num = input.nextLine();

		if(num.equals("1")) {
			Payment.main(movieInfo);
		} else if(num.equals("2")) {
			for(int i=0; i<movieInfo.length; i++)
				movieInfo[i] = null;   //초기화

			BookingMovie.main(null);

		} else if(num.equals("3")) {
			System.exit(0);
		}

	}//main

}