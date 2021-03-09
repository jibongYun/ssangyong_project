package com.test.start;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

import data.Path;
//장진영 구현 - 관리자로그인
public class Admin {

	public static void main(String[] adminInfo) {

			
		String branch = adminInfo[2];	//지점
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("===============================================================================================");
			System.out.println("[ 쌍 용 영 화 관 ]");
			System.out.printf("\t\t\t\t%s 관리자\n",branch);
			System.out.println();
			System.out.println("===============================================================================================");
			System.out.println("\t\t\t1. 매출보기");
			System.out.println("\t\t\t2. 영화 파일 생성");
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.print("\t\t번호를 선택하세요(ex: 1) : ");
		
			int sel = scan.nextInt();
			if(sel == 1)
				ViewSales(branch);
			else if(sel == 2)
				MakeMovieFile(branch);
			else if(sel == 3)
				System.exit(0);
		}
		//상영 목록을 만듬
	}

	private static void ViewSales(String branch) {
		Path path = new Path();
		String readPath = path.adminPath;
		Calendar c = Calendar.getInstance();
		String dirName = String.format("%d-%02d-%02d", c.get(c.YEAR), (c.get(c.MONTH)+1), c.get(c.DATE));
		File file = new File(readPath + branch + "\\" + dirName + "\\present_condition.txt");
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "";
			
			line = reader.readLine();
			String condition[] = line.split("■");
			System.out.println("===============================================================================================");
			System.out.printf("[ 쌍 용 영 화 관 ]\t\t\t%s의 %tF 매출\n",branch, c);
			System.out.println("===============================================================================================");
			System.out.printf("\t\t\t영화 매출 : %,d원\n", Integer.parseInt(condition[0]));
			System.out.printf("\t\t\t스낵 매출 : %,d원\n", Integer.parseInt(condition[1]));
			System.out.printf("\t\t\t총합 매출 : %,d원\n", (Integer.parseInt(condition[0]) + Integer.parseInt(condition[1])));
			reader.close();
		} catch (Exception e) {
			System.out.println("Admin.ViewSales()");
			e.printStackTrace();
		}
	}

	private static void MakeMovieFile(String branch) {
		
		Path path = new Path();
		String readPath = path.moviePath;
		File file = new File(readPath + "movieList.txt");
		ArrayList<String> movieList = new ArrayList<String>();
	
		Random ran = new Random();

		for(int date=2; date<10; date++) {
			//2일후를 위한 출력포멧
			Calendar c = Calendar.getInstance();
			c.set(c.get(c.YEAR), c.get(c.MONTH), c.get(c.DATE)+date);
			//파일 이름포멧
			String fileName = String.format("%d-%02d-%02d", c.get(c.YEAR), (c.get(c.MONTH)+1), c.get(c.DATE));
			
			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line = "";
	
				while((line = reader.readLine()) != null) {
					String temp[] = line.split("■");
					movieList.add(temp[0]);
				}
	
	
				String newPath = path.theaterPath;
				File newFile = new File(newPath + branch + "\\" + fileName + ".txt");
				newFile.createNewFile();
				//폴더 안에 파일 생성
				BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));
	
				for(int i=1; i<=10; i++) {
					String result = ""+i+"■";			//상영번호
					result = result + branch + "■";
					result = result + (ran.nextInt(3)+1) + "■"; //상영관번호 1~4
					result = result + movieList.get(ran.nextInt(movieList.size())) + "■";	//영화목록
					if(i%2==0)	//짝수
						result = result + (i+8) + ":00" + "■" + (i+8+2) + ":00"+"■";		//시작시간~종료시간
					else	//홀수
						result = result +  (i+8) + ":30" + "■" + (i+8+2) + ":30"+"■";		//시작시간~종료시간
					for(int j=0; j<25; j++)
						result += ran.nextInt(2);	//좌석배치 25자리 0, 1	
	
					writer.write(result);
					writer.newLine();
				}
	
				writer.close();
				reader.close();
	
	
			} catch (Exception e) {
				System.out.println("makeScreening.main()");
				e.printStackTrace();
			}
		}
		System.out.println("\t\t\t생성 완료");

	}
}


