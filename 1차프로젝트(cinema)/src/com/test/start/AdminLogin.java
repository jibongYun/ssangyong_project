package com.test.start;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import data.Path;
//장진영 구현 - 관리자 로그인
public class AdminLogin {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Path path = new Path();
		System.out.println("===============================================================================================");
		System.out.println("[ 쌍 용 영 화 관 ]");
		System.out.println("\t\t\t\t관리자 로그인");
		System.out.println();
		System.out.println("===============================================================================================");
		System.out.print("\t\t\t아이디 : ");
		String inputId = scan.nextLine();

		System.out.print("\t\t\t비밀번호 : ");
		String inputPw = scan.nextLine();
		boolean bool = false;
		
		try {//파일 read
			String readPath = path.adminPath+"adminList.txt";
			File file = new File(readPath);

			BufferedReader reader = new BufferedReader(new FileReader(file));

			String line = "";

			while((line = reader.readLine()) != null) {
				//System.out.println(line);
				String[] adminInfo = line.split("■");
				if(adminInfo[0].equals(inputId)) {	//아이디가 있으면
					bool = true;
					if(adminInfo[1].equals(inputPw)) {	//비밀번호 비교
						System.out.println("\t\t\t로그인에 성공하였습니다.");
						Admin.main(adminInfo);	//관리자 페이지
					}
					else 
						System.out.println("\t\t\t비밀번호가 틀렸습니다.");
					break;
				}
			}

			if(!bool)
				System.out.println("\t\t\t아이디가 존재하지 않습니다.");

			reader.close();
		} catch (Exception e) {
			System.out.println("Interface_UserList.Interface_UserList()");
			e.printStackTrace();
		}

	}
}
