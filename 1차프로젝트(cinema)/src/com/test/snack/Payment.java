package com.test.snack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Scanner;

import data.Path;

//장진영 구현 -> 스낵 결정 후 구매
public class Payment {
	
	public static void main(String[] userInfo, int total, String branch) {

		//card
		//0001000200030004■0000■신한■0924
		Scanner scan = new Scanner(System.in);
		
		Path data = new Path();
		
		
		String line = fileProcessing(data.userPath, userInfo[0], "read", 0);
		String[] cardInfo = line.split("■");
		System.out.println("===============================================================================================");
		System.out.println("[ 쌍 용 영 화 관 ]");
		System.out.println("\t\t\t\t결 제");
		System.out.println();
		System.out.println("===============================================================================================");
		System.out.println("\t\t카드번호를 입력하세요 : ");
		String cardNum = scan.nextLine();
		System.out.println("\t\t카드비밀번호를 입력하세요 : ");
		String cardPw = scan.nextLine();
		
		if(cardNum.equals(cardInfo[0]) && cardPw.equals(cardInfo[1])) {
			fileProcessing(data.adminPath, branch, "write", total);
			System.out.printf("\t\t%,d원 결제되었습니다\n", total);
		} else
			System.out.println("\t\t정보가 일치하지 않습니다.");
	}

	private static String fileProcessing(String path1, String path2, String mode, int total) {
		try {
			
			if(mode.equals("read")) {
				//path1 유저폴더  path2 아이디
				String readPath = path1+"userCard\\"+path2+".txt";
				File file = new File(readPath);
				BufferedReader reader = new BufferedReader(new FileReader(file));
				
				String line = reader.readLine();	//카드정보 불러옴 (저장된)
				
				reader.close();
				return line;
			}
			
			if(mode.equals("write")) {//파일 처리 쓰기용
				Calendar c = Calendar.getInstance();
				c.set(c.get(c.YEAR), c.get(c.MONTH), c.get(c.DATE));
				//파일 이름포멧
				String todayDate = String.format("%d-%02d-%02d", c.get(c.YEAR), (c.get(c.MONTH)+1), c.get(c.DATE));
				//path1 관리자폴더 path2 지점명
				//D:\class\java\JavaProject\src\com\test\dummyData\admin\지점1\\날짜
				String readPath = path1 + "\\" + path2 + "\\" + todayDate;
				File file = new File(readPath);
				
				if(!file.exists()) {	//폴더가 존재하지않으면
					file.mkdir();		//만들어준다
					readPath = readPath + "\\present_condition.txt";	//Path 변경
					file = new File(readPath);	//파일도 변경
					file.createNewFile();		//파일도 만들어준다
					BufferedWriter writer = new BufferedWriter(new FileWriter(file));	//새로 쓴다
					writer.write("0■"+total);
					writer.close();
				} else {	//파일이 존재하면
					
					readPath = readPath + "\\present_condition.txt";	//파일주소
					file = new File(readPath);
					
					BufferedReader reader = new BufferedReader(new FileReader(file));

					String line = reader.readLine();
					
					String[] conditionInfo = line.split("■");
					//conditionInfo[0] 영화예약매출 // conditionInfo[1] 스낵매출
					total = Integer.parseInt(conditionInfo[1])+total;
					String result = conditionInfo[0] + "■" + total; 
					BufferedWriter writer = new BufferedWriter(new FileWriter(file));
					writer.write(result);

					writer.close();
					reader.close();
					
				}
			}
				return null;
		} catch (Exception e) {
			System.out.println("Payment.main()");
			e.printStackTrace();
		}
		
		return null;
	}
	
}
