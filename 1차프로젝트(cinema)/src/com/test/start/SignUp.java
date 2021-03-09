package com.test.start;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import data.Path;
//장진영 구현 -> 회원가입
public class SignUp {

	public static void main(String[] args) {

		//회원가입
		Scanner scan = new Scanner(System.in);
		boolean bool = false;
		String result = "";
		String input = "";

		//F7i2jmWPs■JSG6CJSf5■쫈뫱■01013848199■서울특별시 성북구 성북동 271-471
		while(!bool) {	//아이디 유효성 검사 -> 중복검사
			System.out.println("===============================================================================================");
			System.out.println("[ 쌍 용 영 화 관 ]");
			System.out.println("\t\t\t\t회 원 가 입");
			System.out.println();
			System.out.println("===============================================================================================");
			System.out.print("\t\t\t아이디 입력 : ");
			input = scan.nextLine();
			bool = fileProcessing(input, "read");
		}
		result = result + input + "■";

		System.out.print("\t\t\t비밀번호 입력 : ");
		input = scan.nextLine();
		result = result + input + "■";

		bool = false;
		while(!bool) {	//이름 유효 검사 -> 한글로만 이루어짐
			System.out.print("\t\t\t이름 입력 : ");
			input = scan.nextLine();
			bool = isValidName(input);
		}
		result = result + input + "■";

		bool = false;
		while(!bool) {	//폰번호유효검사 -> 숫자로만이루어져야함.
			System.out.print("\t\t\t전화번호 입력(-제외) : ");
			input = scan.nextLine();
			bool = isValidPhone(input);
		}
		result = result + input + "■";

		System.out.print("\t\t\t주소 입력 : ");
		input = scan.nextLine();
		result = result + input;

		fileProcessing(result, "write");

		//회원가입후 -> 정보 파일 만들어줌
		fileProcessing(result, "mkfile");
	}

	private static boolean isValidName(String input) {

		for(int i=0; i<input.length(); i++) {
			if(input.charAt(i) < '가' || input.charAt(i) > '힣')
			{
				System.out.println(input.charAt(i));
				System.out.println("\t\t\t유효하지 않은 이름입니다.");
				return false;
			}
		}
		return true;
	}

	private static boolean isValidPhone(String input) {

		for(int i=0; i<input.length(); i++) {
			if(input.charAt(i) < '0' || input.charAt(i) > '9') {//숫자로 이루어진게 아닐때
				System.out.println(input.charAt(i));
				System.out.println("\t\t\t유효하지 않은 번호입니다.");
				return false;
			}
		}
		return true;
	}

	private static boolean fileProcessing(String str, String mode) {

		try {
			Path path = new Path();
			
			String readPath = path.userPath+"userList.txt";
			
			File file = new File(readPath);

			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

			String line = "";
			Scanner scan = new Scanner(System.in);

			if(mode.equals("read")) {
				while((line = reader.readLine()) != null) {
					String []info = line.split("■");
					if(info[0].indexOf(str) > -1) {	
						System.out.println("\t\t\t중복된 아이디가 존재합니다.");
						return false;
					}//if(중복아이디검사)
				}//while
				return true;
			}//if(read모드)

			if(mode.equals("write")) {
				writer.write(str+"\n");
			}//if(write)

			if(mode.equals("mkfile")) {
				String [] info = str.split("■");
				readPath = path.userPath;
				// "C:\\class\\java\\BookingMovie\\src\\BookingMovie\\dummyData\\user\\userInfo\\아이디.txt
				System.out.println(info[0]);
				File newFile = new File(readPath+"userInfo\\"+info[0]+".txt");	//유저정보
				newFile.createNewFile();
				writer = new BufferedWriter(new FileWriter(newFile));
				writer.write("B■500\n");//브론즈 0포인트 -> 새로 생성된 아이디이므로
				writer.close();

				newFile = new File(readPath+"userCoupon\\"+info[0]+".txt");	//쿠폰정보
				newFile.createNewFile();
				writer = new BufferedWriter(new FileWriter(newFile));
				writer.write("discount3");//
				writer.close();

				newFile = new File(readPath+"userCard\\"+info[0]+".txt");	//카드정보
				newFile.createNewFile();
				writer = new BufferedWriter(new FileWriter(newFile));
				writer.write("0");//브론즈 0포인트 -> 새로 생성된 아이디이므로
				writer.close();
			}//if(makeFile)

			reader.close();
			writer.close();

		} catch (Exception e) {
			System.out.println("SignIn.main()");
			e.printStackTrace();
		}

		return true;
	}//fileProcessing

}


