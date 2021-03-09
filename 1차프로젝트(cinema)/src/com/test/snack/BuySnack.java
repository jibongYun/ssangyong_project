package com.test.snack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.test.nonmember.BookingMovie;

import data.Path;
import data.SnackInfo;
//장진영 구현 - 스낵구입
public class BuySnack {

	static ArrayList<SnackInfo> snacks=new ArrayList<SnackInfo>();
	
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] userInfo) {
		Path path = new Path();
		String PATH = path.snackPath;
		File file = new File(PATH);
		ArrayList<String> branches = new ArrayList<String>();
		File[] fileList = file.listFiles();

		
		for(int i=0; i<fileList.length; i++) {
			int sub = fileList[i].getName().indexOf(".txt");	///.txt를 제거해주기 위함!
			branches.add(fileList[i].getName().substring(0, sub));	//.txt제거해줘서 ArrayList에 add
		}
		System.out.println("===============================================================================================");
		System.out.println("[ 쌍 용 영 화 관 ]");
		System.out.println("\t\t\t\t쌍 용 스 낵");
		System.out.println();
		System.out.println("===============================================================================================");
		System.out.println("\t\t\t쌍용 영화관 지점 목록");
		System.out.println("-----------------------------------------------------------------------------------------------");
		for(int i=0; i<branches.size(); i++)
			System.out.printf("\t\t\t%d : %s\t\n",i+1,branches.get(i));
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.print("\t\t지점번호를 입력해주세요(ex: 1) : ");
		int sel = scan.nextInt();
		String branch = branches.get(sel-1);
		int total = 0;
		// 1. 매점 메뉴 조회
		
		// 메뉴
		
		// 음료 : 콜라(M) 2,500원, 사이다(M) 2,500원, 환타(M) 2,500원, 콜라(L) 3,000원, 사이다(L) 3,000원, 환타(L) 3,000원
		// 스낵
		// 팝콘류 : 기본팝콘(M) 4,500원, 기본팝콘(L) 5,000원, 달콤팝콘(M) 5,000원, 달콤팝콘(L) 5,500원, 치즈팝콘(M) 5,500원, 치즈팝콘(L) 6,000원
		// 그외 : 핫도그 4,000원, 나쵸 4,500원, 오징어 3,500원
		// 콤보
		// 1) 1인콤보(팝콘M + 음료M 1잔 6,500원)
		// 2) 쌍용콤보(팝콘L + 음료M 2잔 9,000원)
		// 3) 라지콤보(팝콘L + 음료L 2잔 14,000원)
		
		boolean loop=true;
		while(loop) {
			try {
				file = new File(PATH+branch+".txt");
				BufferedReader reader=new BufferedReader(new FileReader(file)); // 오늘 날짜 이름의 파일의 PATH
				
				String line=null;
				int i=0;
				String snack="";
				showHeader();
				while((line=reader.readLine())!=null) {
					
					if (line.contains("■")) {
						String[] snackInfo=line.split("■");
						if (snackInfo.length==3) { //콤보 or 스낵
							if (snackInfo[0].contains("콤보")) { //콤보
								//16■1인콤보(기본팝콘M+콜라M(1))■6500
								//nackInfo(String snackNo, String snackName, String snackSize, String snackPrice)
								System.out.printf("\t%s\t%s%,d원\n",snackInfo[0], snackInfo[1], Integer.parseInt(snackInfo[2]));
								snacks.add(new SnackInfo(snackInfo[0], snackInfo[1], "0" ,snackInfo[2]));
							}else {	//스낵
								System.out.printf("\t%s\t\t%s\t\t\t\t%,d원\n", snackInfo[0], snackInfo[1], Integer.parseInt(snackInfo[2]));
								snacks.add(new SnackInfo(snackInfo[0], snackInfo[1], "0" ,snackInfo[2]));
							}
						}else {	//팝콘, 음료
							System.out.printf("\t%s\t\t%s\t\t%s\t\t%,d원\n",snackInfo[0], snackInfo[1], snackInfo[2], Integer.parseInt(snackInfo[3]));
							snacks.add(new SnackInfo(snackInfo[0], snackInfo[1], snackInfo[2] ,snackInfo[3]));
						}
					}else {
						System.out.println("-----------------------------------------------------------------------------------------------");
						System.out.printf("\t\t\t\t%s\n", line);
						System.out.println("-----------------------------------------------------------------------------------------------");
						
					}
			    }
				warning();
				System.out.println();
				int selectMenu=showMenu();
				if (selectMenu==1) { // 뒤로가기
					//System.out.println("뒤로가기!!!!! 메인 불러오기!!!!!");
					BookingMovie.main(userInfo);
				} else if(selectMenu == 2) {
					total = choiceMenu(snacks.size());
					if(total > 0)
						break;
				} else if (selectMenu==3) { // 프로그램 종료
					System.exit(0);
				}else {
					System.out.println("\t\t\t잘못된 메뉴 선택입니다.");
				}
				
				reader.close();
			}catch (Exception e) {
				System.out.println("Exception! Screen_Snack, main()");
				e.printStackTrace();
			}
		}
		
		if(total > 0) {
			snacks.clear();
			Payment.main(userInfo, total, branch);
		}
	}
	
	private static int choiceMenu(int size) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("\t\t메뉴를 선택해주세요.(ex: 1,2,3) :  ");
		String select = scan.nextLine();
		String[] selectInfo = select.split(",");
		boolean bool = valid(selectInfo, size);	//유효성검사
		
		if(bool) {
			int total = 0;
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.print("\t\t선택하신 품목 : ");
			for(int i=0; i<selectInfo.length; i++) {
				if(!snacks.get(Integer.parseInt(selectInfo[i])-1).snackSize.equals(null)) {
					System.out.printf("%s %s", snacks.get(Integer.parseInt(selectInfo[i])-1).snackName
											,snacks.get(Integer.parseInt(selectInfo[i])-1).snackSize);
					
					total = total + Integer.parseInt(snacks.get(Integer.parseInt(selectInfo[i])-1).snackPrice);
				}
				else {
					System.out.printf("%s", snacks.get(Integer.parseInt(selectInfo[i])-1).snackName);
					total = total + Integer.parseInt(snacks.get(Integer.parseInt(selectInfo[i])-1).snackPrice);
				}
				if(i+1 != selectInfo.length)
					System.out.print(", ");
			}
			System.out.println("입니다.\n");
			return total;
		} else
			System.out.println("\t\t\t유효하지 않은 입력입니다.");
		
		return 0;
	}

	private static boolean valid(String[] select, int size) {
		
		for(int i=0; i<select.length; i++)
		{
			for(int j=0; j<select[i].length(); j++) {//숫자가 아닌수가 있을때
				if(select[i].charAt(j) < '0' || select[i].charAt(j) > '9')
					return false;
			}
			if(Integer.parseInt(select[i]) > size)
				return false;	//목록보다 큰 수가 있을때
		}
		
		return true;
	}

	public static void showHeader() {
		System.out.println("===============================================================================================");
		System.out.println("[ 쌍 용 영 화 관 ]");
		System.out.println("\t\t\t\t스 낵 메 뉴");
		System.out.println();
		System.out.println("===============================================================================================");
		System.out.println("\t[구분]\t\t[품목]\t\t[사이즈]\t\t[가격]");
	}
	
	public static int showMenu() {
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("\t\t1.뒤로 가기\t\t2.메뉴선택");
		System.out.println("\t\t3.종료");
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.printf("\t\t메뉴번호를 입력해 주세요(ex: 1) : ");
		int selectMenu=scan.nextInt(); 
		
		return selectMenu;
	}
	
	public static void warning() {
		System.out.println();
		System.out.println("* * * 각 지점 사정에 따라 판매하지 않는 품목도 있습니다.");
	}
	
}
