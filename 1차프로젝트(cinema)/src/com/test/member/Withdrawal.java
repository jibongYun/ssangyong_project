package com.test.member;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;

import com.test.start.Start;

import data.Path;

//윤지봉 구현 -> 회원탈퇴
public class Withdrawal { // 회원 탈퇴 페이지

	public static void main(String[] userInfo) {

		Scanner scan = new Scanner(System.in);

		try {

			Path data = new Path();
			String path = data.userPath;

			BufferedReader reader1 = new BufferedReader(new FileReader(path + "userList.txt"));
			String line;
			String id = "";
			boolean pass = false;
			while ((line = reader1.readLine()) != null) { // 비밀번호 확인용으로 가져오기
				String temp[] = line.split("■");
				if (temp[0].equals(userInfo[0])) {
					System.out.println("===============================================================================================");
					System.out.println("[ 쌍 용 영 화 관 ]");
					System.out.println("\t\t\t\t탈  퇴");
					System.out.println();
					System.out.println("===============================================================================================");
					System.out.println("\t\t\t회원님의 비밀번호를 입력하세요.");
					System.out.print("\t\t\t입력 : ");
			
					String password = scan.nextLine();
					if (password.equals(temp[1])) {
						pass = true;
					}
				}
			}
			reader1.close();

			if (!pass) {
				System.out.println("-----------------------------------------------------------------------------------------------");
				System.out.println("\t\t\t비밀번호가 틀렸습니다.");
				System.out.println("-----------------------------------------------------------------------------------------------");
				System.out.println("\t\t\t1. 돌아가기");
				System.out.println("\t\t\t2. 다시 입력하기");
				System.out.println("-----------------------------------------------------------------------------------------------");
				System.out.print("\t\t번호를 입력해주세요(ex: 1) : ");

				String input = scan.nextLine();
				switch (input) {

				case "1":
					ViewUserInfo.main(userInfo);
					break;

				case "2":
					main(userInfo); // 질문 다시하기
					break;

				default:
					System.out.println("\t\t잘못된 접근입니다.");
					main(userInfo);
					break;
				}
			}

			
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.println("\t\t\t정말 탈퇴하시겠습니까?");
			System.out.println("\t\t\t1. 탈퇴하기");
			System.out.println("\t\t\t2. 되돌아가기");
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.print("\t\t번호를 입력해주세요(ex: 1) : ");
			int select = Integer.parseInt(scan.nextLine());
			
			switch ( select) {
			
			case 2 : ViewUserInfo.main(userInfo); // 돌아가기
					break;			
			case 1 : 
				String all = ""; // LinkedList 누적용 변수
				BufferedReader reader = new BufferedReader(new FileReader(path + "userList.txt"));

				LinkedList<String> link = new LinkedList<String>();

				while ((line = reader.readLine()) != null) { // LinkedList 로 데이터를 전부 읽는다
					link.add(line);
				}

				reader.close(); // 읽기 종료

				for (int i = 0; i < link.size(); i++) {// list를 for문으로 돌려서 if + equals 로 원하는 정보를 찾는다
					String[] temp = link.get(i).split("■");

					if (userInfo[0].equals(temp[0])) { // 동일 id 찾기
						link.remove(i); // 발견되면 해당 내용삭제
						index--; // 삭제 후 index 줄이기
					}
				}

				for (int i = 0; i < link.size(); i++) {// 수정된 내용을 for + LinkedList로 돌려서 all 로 저장
					// System.out.println(link.get(i)); // 저장되는정보 확인
					all += link.get(i) + "\n";
				}

				BufferedWriter writer = new BufferedWriter(new FileWriter(path + "userList.txt"));

				writer.write(all);
				writer.close();

				link = null;
				break;
				
			default : System.out.println("\t\t잘못된 접근입니다.");
						main(userInfo);
						break;
			
			}
 
					File fileCard = new File(path + "userCard\\" + userInfo[0] + ".txt");					
					fileCard.delete();

					File filePoint = new File(path + "userInfo\\" + userInfo[0] + ".txt");
					filePoint.delete();

					File fileCoupon = new File(path + "userCoupon\\" + userInfo[0] + ".txt");
					fileCoupon.delete(); // 지워짐

		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("\t\t\t계정이 삭제되었습니다.");
		System.out.println("\t\t\t처음화면으로 돌아갑니다");
		System.out.println("\t\t\t엔터를 누르세요");
		String enter = scan.nextLine();
		
		Start.main(userInfo);

	}

}
