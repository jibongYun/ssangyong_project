package com.test.start;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import com.test.member.BookingMovie;
import data.Path;

//장진영 구현 -> 로그인
public class UserLogin {

	public static void main(String[] args) {

		//로그인
		Scanner scan = new Scanner(System.in);
		
		System.out.println("===============================================================================================");
		System.out.println("[ 쌍 용 영 화 관 ]");
		System.out.println("\t\t\t\t회원 로그인");
		System.out.println();
		System.out.println("===============================================================================================");

		System.out.print("\t\t\t[ID] : ");
		String inputId = scan.nextLine();
		
		System.out.print("\t\t\t[PW] : ");
		String inputPw = scan.nextLine();
		
		boolean bool = false;

		try {//파일 read
			Path data = new Path();
			
			String path = data.userPath + "userList.txt";
			File file = new File(path);

			BufferedReader reader = new BufferedReader(new FileReader(file));

			String line = "";

			while((line = reader.readLine()) != null) {//한 라인에 아이디가 있는지 없는지 확인함
				//WYz2MrX■db22tDaN■웽쿓캚■01051188892■서울특별시 용산구 도원동 571-501
				String[] userInfo = line.split("■");
				if(userInfo[0].equals(inputId)) {	//아이디가 있으면
					bool = true;
					if(userInfo[1].equals(inputPw)) {	//비밀번호 비교
						System.out.println("\t\t\t로그인에 성공하였습니다.");
						BookingMovie.main(userInfo);	//멤버예약페이지
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
