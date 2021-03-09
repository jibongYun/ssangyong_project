package com.test.member;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import data.CardInfo;
import data.Path;
import data.UsedPC;

//임채원 구현 -> 최종결제
public class Payment {

	public static void main(String[] userInfo, String[] movieInfo, UsedPC used) {

		Scanner scan = new Scanner(System.in);
		System.out.println("===============================================================================================");
		System.out.println("[ 쌍 용 영 화 관 ]");
		System.out.println("\t\t\t\t결 제");
		System.out.println();
		System.out.println("===============================================================================================");

		while(true) {

			System.out.println("\t\t\t1. 카드 결제");
			System.out.println("\t\t\t2. 휴대폰 결제");
			System.out.println("\t\t\t3. 예약화면");
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.print("\t\t\t결제 방법을 선택하세요(ex: 1) : ");
			int sel = scan.nextInt();
			String id = userInfo[0];

			if(sel == 1) {
				payCard(id);
				viewReservation(id, movieInfo, used, "c");
				break;
			}
			else if(sel == 2) {
				payPhone(id);
				viewReservation(id, movieInfo, used, "p");
				break;
			} else if(sel == 3) {
				for(int i=0; i<movieInfo.length; i++)
					movieInfo[i] = null;	//초기화
				BookingMovie.main(userInfo);
				break;
			}
		}

		//최종결제후 텍스타파일교체
		ChangeFile.main(userInfo, movieInfo, used);

	}

	private static void viewReservation(String id, String[] movieInfo, UsedPC used, String option) {

		Scanner scanner = new Scanner(System.in);
		String[] seat = movieInfo[9].split(" ");// 쪼갬

		System.out.println();
		System.out.printf(""
				+ "===============================================================================================\n"
				+ "\t\t\t주문 금액 : %,d￦\n"
				,seat.length * 10000
				);
		if (!used.getUsedPoint().equals("")) {
			System.out.printf(""
					+ "\t\t\t       -\n"
					+ "\t\t\t포인트 사용 %,d￦\n"
					,Integer.parseInt(used.getUsedPoint())
					);
		}
		if (!used.getUsedCoupon().equals("")) {
			System.out.printf(""
					+ "\t\t\t       -\n"
					+ "\t\t\t쿠폰 사용::: [%s]\n"
					,used.getUsedCoupon()
					);
		}
		System.out.printf(""
				+ "-----------------------------------------------------------------------------------------------\n"
				+ "\t\t\t최종 결제금액 %,d￦\n"
				+ "-----------------------------------------------------------------------------------------------\n"
				+ "\t\t\t결제하시겠습니까?(y/n)\n"
				,Integer.parseInt(movieInfo[8])
				);

		String yon = scanner.nextLine();
		if (yon.toUpperCase().equals("Y")) {
			System.out.println();
			System.out.println("\t\t\t결제중입니다\n.\n.\n.\n");
		}



		System.out.println("\t\t\t결제가 완료되었습니다.");
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t결제 정보");
		System.out.println("-----------------------------------------------------------------------------------------------\\n\"");
		System.out.printf(""
				+ "\t\t\t결제 구분 : %s\n"
				+ "\t\t\t상품금액 : %,d￦\n"
				+ "\t\t\t할인금액 : %,d￦\n"
				+ "\t\t\t결제금액 : %,d￦\n",
				option=="p"?"휴대폰 결제":"신용카드 결제",
						seat.length * 10000,
						seat.length * 10000 - Integer.parseInt(movieInfo[8]),
						Integer.parseInt(movieInfo[8])
				);
		System.out.println();
		System.out.println();

		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t티켓 정보");
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.printf(""
				+ "\t\t\t%s(%s점)\n"
				+ "\t\t\t%s %s~%s\n"
				+ "\t\t\t관람관 : %s관\n"
				+ "\t\t\t좌석 : %s\n",
				movieInfo[4],movieInfo[2],movieInfo[1],movieInfo[5],movieInfo[6],
				movieInfo[3],movieInfo[9]
				);

		System.out.println();

	}

	private static void payPhone(String id) {

		Scanner scan = new Scanner(System.in);
		System.out.println("===============================================================================================");
		System.out.println("[ 쌍 용 영 화 관 ]");
		System.out.println("\t\t\t\t휴대폰 결제");
		System.out.println();
		System.out.println("===============================================================================================");
		System.out.println("\t\t\t1. 휴대폰 번호를 입력해주세요");
		System.out.print("\t\t\t입력 : ");
		int input = scan.nextInt();

		try {
			Path path = new Path();
			String readPath = path.userPath + "userList.txt";

			BufferedReader reader = new BufferedReader(new FileReader(readPath));
			String line = "";

			while((line = reader.readLine()) != null) {
				String[] userInfo = line.split("■");
				if(userInfo[0].equals(id))
					break;
			}
			reader.close();

			String[] userInfo = line.split("■");
			if(userInfo[3].equals(input)) {
				System.out.println("\t\t\t결제가 완료되었습니다.");
			} else {
				System.out.println("\t\t\t휴대폰 번호가 다릅니다.");
			}

		} catch (Exception e) {
			System.out.println("Payment.payPhone()");
			e.printStackTrace();
		}


	}

	private static void payCard(String id) {//카드 지불

		Scanner scan = new Scanner(System.in);

		System.out.println("===============================================================================================");
		System.out.println("[ 쌍 용 영 화 관 ]");
		System.out.println("\t\t\t\t카 드 결 제");
		System.out.println();
		System.out.println("===============================================================================================");
		System.out.println("\t\t\t1. 카드 등록");
		System.out.println("\t\t\t2. 카드 결제");
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.print("\t\t결제 방법을 선택하세요(ex: 1) : ");
		int sel = scan.nextInt();
		String line = "";

		if(sel == 1) {
			Path path = new Path();
			String readPath = path.userPath + "userCard\\" + id + ".txt"; 
			try {

				BufferedReader reader = new BufferedReader(new FileReader(readPath));
				line = "";

				line = reader.readLine();
				reader.close();
				if(line.equals("0"))	//등록된 카드가 없으면
					inputCardInfo(id);	//카드 정보 등록
				else
					System.out.println("\t\t\t이미 등록된 카드가 있습니다.");

			} catch (Exception e) {
				System.out.println("Payment.main()");
				e.printStackTrace();
			}
		} else if(sel == 2) {
			Path path = new Path();
			String readPath = path.userPath + "userCard\\" + id + ".txt"; 
			try {

				BufferedReader reader = new BufferedReader(new FileReader(readPath));
				line = "";

				line = reader.readLine(); 	// 카드정보 불러옴!
				String[] cardInfo = line.split("■");
				reader.close();

				scan.nextLine();	//엔터키 버퍼제거
				System.out.println("\t\t\t카드 번호 : " + cardInfo[0]);

				System.out.println("\t\t\t카드 비밀번호를 입력하세요");
				System.out.print("\t\t\t입력 : ");
				String cardPw = scan.nextLine();

				if(cardInfo[1].equals(cardPw)) {
					System.out.println("\t\t\t결제가 완료됐습니다.");
				}
				else {
					System.out.println("\t\t\t입력된 정보가 다릅니다.");
					payCard(id);
				}
			} catch (Exception e) {
				System.out.println("Payment.main()");
				e.printStackTrace();
			}
		}
		else {
			System.out.println("\t\t\t잘못된 접근입니다.");
		}
	}

	private static void inputCardInfo(String id) {//카드정보 input 

		Scanner scan = new Scanner(System.in);

		System.out.print("\t\t카드 번호를 '-'없이 입력하세요 : ");
		String cardNum = scan.nextLine();
		System.out.print("\t\t카드 비밀번호를 입력하세요 : ");
		String cardPw = scan.nextLine();
		System.out.print("\t\t카드사를 입력하세요 : ");
		String cardCorp = scan.nextLine();
		System.out.print("\t\t유효기간을 입력하세요 : ");
		String cardExp = scan.nextLine();

		CardInfo cardInfo = new CardInfo(cardNum, cardPw, cardCorp, cardExp);
		boolean bool = isValidCard(cardInfo);

		if(bool) { //카드 등록
			try {
				Path path = new Path();
				String readPath = path.userPath + "userCard\\"+id+".txt";
				BufferedWriter writer = new BufferedWriter(new FileWriter(readPath));

				writer.write(cardNum+"■"+cardPw+"■"+cardCorp+"■"+cardExp);

				writer.close();

			} catch (Exception e) {
				System.out.println("Payment.inputCardInfo()");
				e.printStackTrace();
			}
			return;
		}
		else {
			System.out.println("\t\t\t카드정보를 다시 입력해주세요.");
			inputCardInfo(id);
		}

	}

	public static boolean isValidCard(CardInfo cardInfo) {//카드 유효성검사

		//카드번호 유효성검사
		if (cardInfo.getCardNum().length() == 16) {	//카드 자리수가 16자리가 아닌가?
			for (int i=0; i<cardInfo.getCardNum().length(); i++) {
				char c = cardInfo.getCardNum().charAt(i);
				if (!(c>='0' && c <='9'))	//0~9범위안에있는 숫자가 없을때
					return false;
			}//for
		} else 
			return false;

		//카드 비밀번호 유효성 검사
		if(cardInfo.getCardPw().length() == 4)	{		//카드자리수가 4글자인가
			for (int i=0; i<cardInfo.getCardPw().length(); i++) {
				char c = cardInfo.getCardPw().charAt(i);
				if (!(c>='0' && c <='9'))	//0~9범위안에있는 숫자가 없을때
					return false;
			}//for
		}
		else 
			return false;

		//카드회사 유효성 검사


		//		 enum CardCompany {
		//	   		신한, 우리, 국민, 농협, 수협, 기업, 롯데, 하나, 삼성, 씨티}

		//카드회사 유효성 검사
		String[] cardCompany = new String[]{ "신한", "우리", "국민", "농협", "수협", "기업", "롯데", "하나", "삼성", "씨티" };
		boolean bool = false;
		for(int i=0; i<cardCompany.length; i++) {
			if(cardInfo.getCardCorp().equals(cardCompany[i])) {
				bool = true;
				break;
			}
		}
		if(!bool)	//카드회사 유효성검사 통과못함
			return false;

		return true;
	}
}




