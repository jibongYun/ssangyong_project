package com.test.start;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import data.Path;
//장진영 구현 -> 아이디, 비밀번호 찾기
public class Search {
	
	public static void main(String[] args) {

		//아이디, 비밀번호 찾기

		Scanner scan = new Scanner(System.in);

		while(true) {
			System.out.println("===============================================================================================");
			System.out.println("[ 쌍 용 영 화 관 ]");
			System.out.println("\t\t\t\t ID/PW 찾기");
			System.out.println();
			System.out.println("===============================================================================================");
			System.out.println("\t\t\t1. 아이디 찾기");
			System.out.println("\t\t\t2. 비밀번호 찾기");
			System.out.println("\t\t\t3. 뒤로가기");
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.print("\t\t번호를 입력하세요(ex: 1) : ");
			int sel = scan.nextInt();
			if(sel == 1) 	//아이디 찾기
				searchId();
			else if(sel == 2)
				searchPw();
			else if(sel == 3)
				Start.main(args);
			else
				System.out.println("\t\t\t잘못된 입력입니다.");
		}
	}
	
	private static void searchPw() {
		Scanner scan = new Scanner(System.in);

		System.out.print("\t\t\t아이디 입력 : ");
		String id = scan.nextLine();
		System.out.print("\t\t\t전화번호 입력 : ");
		String phone = scan.nextLine();
		
		
		try {

			Path path = new Path();
			File file = new File(path.userPath + "userList.txt");

			BufferedReader reader = new BufferedReader(new FileReader(file));
			boolean bool = true;
			String line = "";

			while((line = reader.readLine()) != null) {
				//JkLKtnE4■VjU1p■꺬뇰■01021139498■서울특별시 강서구 오쇠동 81-271
				String[] info = line.split("■");
				if(info[3].equals(phone) && info[0].equals(id)) {	//번호와 아이디가 일치하면
					System.out.printf("\t\t\t%s\n",info[1]);
					bool = false;
					break;
				}
			}
			
			if(bool)	//일치하지 않을때
				System.out.println("\t\t\t정보가 일치하지 않습니다.");
			
			reader.close();
		} catch (Exception e) {
			System.out.println("Search.searchId()");
			e.printStackTrace();
		}
	}

	public static void searchId() {
		Scanner scan = new Scanner(System.in);

		System.out.print("\t\t\t전화번호 입력 : ");
		String phone = scan.nextLine();

		try {

			Path path = new Path();
			File file = new File(path.userPath + "userList.txt");

			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "";
			boolean bool = true;

			while((line = reader.readLine()) != null) {
				//JkLKtnE4■VjU1p■꺬뇰■01021139498■서울특별시 강서구 오쇠동 81-271
				String[] info = line.split("■");
				if(info[3].equals(phone)) {
					System.out.printf("\t\t\t%s\n",info[0]);
					bool = false;
					break;
				}
			}
			
			if(bool)
				System.out.println("\t\t\t아이디가 존재하지 않습니다.");

			reader.close();
		} catch (Exception e) {
			System.out.println("Search.searchId()");
			e.printStackTrace();
		}
	}
	
}
