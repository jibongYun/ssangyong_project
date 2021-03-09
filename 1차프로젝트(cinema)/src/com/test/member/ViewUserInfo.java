package com.test.member;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import data.Path;

public class ViewUserInfo {

	public static void main(String[] userInfo) {

		final String ID = userInfo[0];
		Path data = new Path();  
		

		try {
			Scanner scan = new Scanner(System.in);
			String fileName = ID + ".txt";	//파일네임
			String path = data.userPath; // 회원 폴더
			
			BufferedReader reader1 = new BufferedReader(new FileReader(path+"\\userList.txt"));
			String line;
			String id = "";
			while ((line = reader1.readLine()) != null) {
				String temp[] = line.split("■");
				if (temp[0].equals(ID)) {
					
					
			  		System.out.println("===============================================================================================");
					System.out.println("[ 쌍 용 영 화 관 ]");
					System.out.println("\t\t\t\t회원 정보 보기");
					System.out.println();
					System.out.println("===============================================================================================");
					System.out.printf("%s : %s\n", "\t\t\t아 이 디", userInfo[0]);
					System.out.printf("%s : %s\n", "\t\t\t이    름", temp[2]);
					System.out.printf("%s : %s\n", "\t\t\t전화번호", temp[3]);
					System.out.printf("%s : %s\n", "\t\t\t주    소", temp[4]);
				}
			}
			reader1.close();
			File file = new File(path + "\\userCard\\" + fileName); // 카드 정보 폴더
			BufferedReader reader = new BufferedReader(new FileReader(file));

			String readline;
	         if ( (readline = reader.readLine()).equals("0")) {
	            System.out.println("\t\t\t카드번호 : ");
	            
	         } else {
	            String cardNumber = readline.substring(0, 16);
	            System.out.println("\t\t\t카드번호 : " + cardNumber);
	         }


			file = new File(path + "\\userInfo\\" + fileName); // 회원정보 폴더
			
			reader.close();
			
			reader = new BufferedReader(new FileReader(file));
			
			line = reader.readLine();		
			String[] info = line.split("■");
			System.out.printf("%s : %s점\n", "\t\t\t포 인 트", info[1]);
			System.out.printf("%s : %s\n", "\t\t\t등    급", info[0]);
			reader.close();



			// System.out.printf("%d등급까지 영화관람 %s번 남았어요!", , );
			
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.println("\t\t\t1. 수정하기");
			System.out.println("\t\t\t2. 탈퇴하기");
			System.out.println("\t\t\t3. 되돌아가기");
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.print("\t\t번호를 입력해주세요.(ex: 1) : ");

			int input = Integer.parseInt(scan.nextLine());
			
			switch (input) {
			case 1 : 
				Modify.main(userInfo); // 수정하기 메서드로 이동
				break;
				
			case 2 :
				Withdrawal.main(userInfo); // 탈퇴하기 메서드로 이동
				break;

			case 3 :
				BookingMovie.main(userInfo);
				break;
			
			default :
				System.out.println("\t\t잘못된 접근입니다.");
				main(userInfo);
				break;
			}
			
			
		} catch (Exception e) {
			System.out.println("Screen_PersonalInfo.Personal()");
			e.printStackTrace();
		}

	}
}
