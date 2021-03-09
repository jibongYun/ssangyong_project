package com.test.nonmember;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import data.CardInfo;
import data.Path;

//임채원 구현 -> 최종결제
public class Payment {

	public static void main(String[] movieInfo) {

		/*for(int i=0; i<movieInfo.length; i++)
		System.out.println(movieInfo[i]);
		0	12
		1	강남점
		2	2
		3	도굴
		4	09:00
		5	11:00
		6	0001001010011101011111100
		7	20000
		8	A1 A3
		 */
			System.out.println("===============================================================================================");
			System.out.println("[ 쌍 용 영 화 관 ]");
			System.out.println("\t\t\t\t결 제");
			System.out.println();
			System.out.println("===============================================================================================");
			Scanner scan = new Scanner(System.in);
			System.out.print("\t\t1. 휴대폰 번호 입력 : ");
			
			String phone = scan.nextLine();

			ChangeFile.main(movieInfo, phone);
	}

}




