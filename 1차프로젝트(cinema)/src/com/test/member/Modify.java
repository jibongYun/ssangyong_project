package com.test.member;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;

import data.Path;

//윤지봉 구현 -> 개인정보 수정
public class Modify { // 개인정보 수정 페이지
	
	public static void main(String[] userInfo) {

		final String ID = userInfo[0]; 
		System.out.println("===============================================================================================");
		System.out.println("[ 쌍 용 영 화 관 ]");
		System.out.println("\t\t\t\t개인정보 수정");
		System.out.println();
		System.out.println("===============================================================================================");
		System.out.println("\t\t\t1. 이름");

		System.out.println("\t\t\t2. 전화번호");

		System.out.println("\t\t\t3. 주소");

		System.out.println("\t\t\t4. password");

		System.out.println("\t\t\t5. 카드번호");

		System.out.println("\t\t\t6. 돌아가기");
		System.out.println("-----------------------------------------------------------------------------------------------");

		System.out.print("\t\t수정을 원하는 번호를 선택하세요.(ex: 1) : ");
		Scanner scan = new Scanner(System.in);
		String num = scan.nextLine();

		if (num.equals("6")) {	//돌아가기
			ViewUserInfo.main(userInfo);
		}

		// id, pw, 이름, 번호, 주소
		if (num.equals("1")) {
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.print("\t\t\t이름: ");
			String input = scan.nextLine();
			System.out.println("-----------------------------------------------------------------------------------------------");
			in(2, input, ID);

		} else if (num.equals("2")) {
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.print("\t\t\t전화번호 : ");
			String input = scan.nextLine();
			System.out.println("-----------------------------------------------------------------------------------------------");
			
			for(int i=0; i<input.length(); i++) {
				if(input.charAt(i) < '0' || input.charAt(i) > '9')
				{
					System.out.println(input.charAt(i));
					System.out.println("\t\t\t유효하지 않은 번호입니다.");
							
					Modify.main(userInfo);
				}
			}

			in(3, input, ID);
			
			//reservation\\member\\전화번호 -> 전화번호 바꾸기
			Path data = new Path();
			String path = data.reservationPath + "member\\" + userInfo[3] + ".txt"; 
			String path2 = data.reservationPath + "member\\" + input + ".txt";
			File file = new File(path);
			File file2 = new File(path2);
			file.renameTo(file2);



		} else if (num.equals("3")) {
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.print("\t\t\t주소 : ");
			// = scan.nextLine();
			String input = scan.nextLine();
			System.out.println("-----------------------------------------------------------------------------------------------");
			in(4, input, ID);

		} else if (num.equals("4")) {
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.print("\t\t\tpassword : ");
			String input = scan.nextLine();
			System.out.println("-----------------------------------------------------------------------------------------------");
			in(1, input, ID);

		} else if (num.equals("5")) {

			cardRegist(ID);

		} else {
			System.out.println("\t\t\t잘못된 접근입니다.");
			main(userInfo);
		}



	}

	private static void cardRegist(String ID) { // 카드 등록 메소드

		Scanner scan = new Scanner(System.in);
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.print("\t\t\t카드번호 : ");
		String cardNumber = scan.nextLine();
		if(cardNumber.length() != 16 ) {
			System.out.println("\t\t\t유효하지 않은 카드번호입니다.");
			cardRegist(ID); // 다시 입력하도록 재귀
		}
			
		for ( int i=0; i<16; i++) {
			if(cardNumber.charAt(i) < '0' || cardNumber.charAt(i) >'9') {
				System.out.println("\t\t\t유효하지 않은 카드번호입니다.");
				cardRegist(ID);
			}
		}
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.print("\t\t\t비밀번호 : "); 
		String cardPw = scan.nextLine();
		
		if(cardPw.length() != 4 ) {
			System.out.println("\t\t\t유효하지 않은 비밀번호입니다.");
			cardRegist(ID);
		}
			
		for ( int i=0; i<4; i++) {
			if(cardPw.charAt(i) < '0' || cardPw.charAt(i) >'9') {
				System.out.println("\t\t\t유효하지 않은 비밀번호입니다.");
				cardRegist(ID);
			}
		}		
		
		
		String temp4 = ""; 
		for(CardCompany company: CardCompany.values()) {
			temp4 += company + " ";   
		}
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.printf("\t\t카드사예시( %s)\n", temp4);

		System.out.print("\t\t\t카드사 : ");
		String cardCompany = scan.nextLine();

		Boolean bool = false;
		for(CardCompany company: CardCompany.values()) {
			if (company.toString().equals(cardCompany.substring(0,2))) {
				bool = true;
			} 

		}
		if( !bool ) {
			System.out.println("\t\t\t유효하지 않은 카드사입니다.");
			cardRegist(ID);			
		}
		
		
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.print("\t\t유효기간(Month/Year) : ");
		String validDate = scan.nextLine();
		System.out.println("-----------------------------------------------------------------------------------------------");
		
		if(validDate.length() != 4) {
			System.out.println("\t\t유효하지 않은 유효기간입니다.");
			cardRegist(ID);
		}
		if(Integer.parseInt(validDate.substring(0,2)) < 0 || Integer.parseInt(validDate.substring(0,2)) > 12) {	
			System.out.println("\t\t유효하지 않은 유효기간입니다.");
			cardRegist(ID);
		} 

//		for()
//		if(cardNumber)

		try {
			Path data = new Path();
			String path =  data.userPath + "\\userCard\\";
			File file = new File(path);

			String[] list = file.list();

			//			for (String title : list) { // 카드번호 전체 확인
			//				System.out.println(title);
			//				if ((cardNumber +".txt").equals(title)) { // 같은 번호가 있는지 학인
			//
			String temp = cardNumber+"■"+ cardPw +"■"+ cardCompany.substring(0,2) +"■"+ validDate;

			BufferedWriter writer = new BufferedWriter(new FileWriter(path + "\\" + ID + ".txt"));
			writer.write(temp);
			writer.close();
			
			temp = null;

		} catch (Exception e) {
			System.out.println("Screen_InsertPage.cardRegist()");
			e.printStackTrace();
		}

	}

	
	private static void in(int num, String input, String ID) { //윤지봉. 개인정보 수정하는 메서드

		try {

			Path data = new Path();
			String all = ""; // LinkedList 누적용 변수
			String path = data.userPath + "userList.txt";
			BufferedReader reader = new BufferedReader(new FileReader(path));	

			String line="";

			LinkedList<String> link = new LinkedList<String>();

			while ((line = reader.readLine()) != null) { // LinkedList 로 데이터를 전부 읽는다
				link.add(line);
			}

			reader.close(); // 읽기 종료

			for (int i = 0; i < link.size(); i++) {// list를 for문으로 돌려서 if + equals 로 원하는 정보를 찾는다
				String[] info = link.get(i).split("■");

				if (ID.equals(info[0])) { // 동일 id 찾기

					String some = link.get(i); // 한줄 그대로 복사
					some = some.replace(info[num], input); // 덮어 쓰기
					link.remove(i); // 해당 데이터 삭제
					link.add(some); // 발견되면 해당 수정 데이터 삽입/ [이름[2], 전화번호[3], 주소[4]
				}
			}

			for (int i = 0; i < link.size(); i++) {// 수정된 내용을 for + LinkedList로 돌려서 all 로 저장
				//	System.out.println(link.get(i)); // 저장되는정보 확인
				all += link.get(i) + "\n";
			}
			
			

			BufferedWriter writer = new BufferedWriter(new FileWriter(path));

			writer.write(all);

			writer.close(); // 쓰기 종료

			link = null;
			all = null;
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}

enum CardCompany {
	   신한, 우리, 국민, 농협, 수협, 기업, 롯데, 하나, 삼성, 씨티
	}
