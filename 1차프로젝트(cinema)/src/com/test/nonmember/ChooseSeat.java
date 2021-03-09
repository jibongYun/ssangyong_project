package com.test.nonmember;

import java.util.ArrayList;
import java.util.Scanner;

//조혜승 구현 -> 좌석선택
public class ChooseSeat {
	
	static ArrayList<Seat> reserved = new ArrayList<Seat>();//예약된 좌석
	static ArrayList<Seat> seatSel = new ArrayList<Seat>();//입력받은 좌석에대한 배열
	
	public static void main(String[] movieInfo) {

		Scanner scan = new Scanner(System.in);
		reserved.clear();
		seatSel.clear();
		System.out.println("===============================================================================================");
		System.out.println("[ 쌍 용 영 화 관 ]");
		System.out.println("\t\t\t\t좌석 배치도");
		System.out.println();
		System.out.println("===============================================================================================");
		System.out.println("\t\t□ = 선택가능 \t\t ■ = 선택불가");
		viewSeat(movieInfo[7]); //좌석배치도메서드
		System.out.println("-----------------------------------------------------------------------------------------------");
		
		chooseSeat();
		
		//확장
		String[] temp = new String[movieInfo.length+2];
		for(int i=0; i<movieInfo.length; i++) {
			temp[i] = movieInfo[i];
		}
		temp[8] = seatSel.size()*10000 + ""; //가격설정하기.
		String result = "";
		//좌석 String으로 만들어줌
		for(int i=0; i<seatSel.size(); i++) {
			String col = seatSel.get(i).getCol();
			String row = seatSel.get(i).getRow();
				if(i+1 != seatSel.size())
					result = result + col + row + " ";
				else
					result = result + col + row;
		}
		temp[9] = result;
		movieInfo = temp;//배열교체
//		
//		for(int i=0; i<movieInfo.length; i++)
//			System.out.println(movieInfo[i]);
//		
//		scan.nextInt();
		
		reserved.clear();
		CheckReservation.main(movieInfo);
	} 	
	
	private static void chooseSeat() {
		Scanner scan = new Scanner(System.in);

		System.out.printf("\t\t좌석을 선택해 주세요 (ex:A1 A2): ");
		String seatInput = scan.nextLine(); //좌석선택 받음

		if(!seatInput.equals("")) {	//뭐라도 입력을 받아야 통과함
			String[] seatDiv = seatInput.split(" ");		//선택받은 좌석 쪼개기

			for(int i=0; i<seatDiv.length; i++) {

				seatSel.add(new Seat(seatDiv[i].substring(0,1).toUpperCase()	//문자 대문자로 up -> add	
						,seatDiv[i].substring(1)));					// 뒤 숫자
			}//자리 입력 for

			boolean bool = isValidInput(seatSel);
			if(bool) {	//유효성 검사 통과 
				bool = compareReserved(seatSel);	//예약받은 자리랑 비교
				if(bool)	//예약받은자리통과
					return;	//메서드 종료
				else	//예약된 자리면
					System.out.println("\t\t예약된 자리입니다. 다시 입력해주세요.");

			} else 
				System.out.println("\t\t다시 입력해주세요. ");

			seatSel.clear();//새로 초기화때림
		}
		chooseSeat();
	}//chooseSeat

	private static boolean compareReserved(ArrayList<Seat> seatSel) {//예약된 자리비교
		
		for(int i=0; i<seatSel.size(); i++) { //예약된 좌석 선택시.
			
			for(int j=0; j<reserved.size(); j++) {

				if (seatSel.get(i).getCol().equals(reserved.get(j).getCol()) && 
						seatSel.get(i).getRow().equals(reserved.get(j).getRow())) {
	
					return false;
				}
			}
		}
		return true;
	}//compareReserved

	private static boolean isValidInput(ArrayList<Seat>seatSel) {//유효성 검사	
		
		for(int i=0; i<seatSel.size(); i++) {
//			String col = seatSel.get(i).getCol();
//			String row = seatSel.get(i).getRow();
//			if(col.compareTo("E")>="A".compareTo("E")
//					&& row.compareTo("5")>="1".compareTo("5")) { //TODO 유효성검사 AA를 입력해도 넘어가버림..
//				
//				return false;
//			}
		}
		
		return true;
	}

	private static void viewSeat(String seat) {

		int col = 65;
		for(int i=0; i<seat.length(); i++) {

			if(i%5 == 0 ) { //행알파벳
				if(i != 0 )
					System.out.printf("\n\t\t\t%c ",col++);
				else
					System.out.printf("\t\t\t%c ",col++);
			}
			if(seat.charAt(i)=='0') { //좌석 배치도 모양
				System.out.printf("%c ",'□');
			} else {
				reserved.add(new Seat((char)(col-1)+"",((i%5)+1)+""));

				System.out.printf("%c ",'■');							
			}
		}
		System.out.println();

		System.out.print("\t\t\t");
		for(int k=0;k<=4;k++) { //열번호

			if (k==0) { 
				System.out.print("  ");
			}
			System.out.printf("%d ", k+1);
		}	
		System.out.println();
	}
} //main

class Seat { //좌석 받아와서 행과열로 구분해주는 클래스 
	private String col;
	private String row;

	public String getRow() {
		return row;
	}
	public void setRow(String row) {
		this.row = row;
	}
	public String getCol() {
		return col;
	}
	public void setCol(String col) {
		this.col = col;
	}
	public Seat(String col, String row) {
		this.row = row;
		this.col = col;
	}

}
