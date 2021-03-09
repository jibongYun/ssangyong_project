package com.test.member;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import data.Path;

public class CancelReservation {

	public static void main(String[] userInfo) {

		final String ID = userInfo[0];
		
		try {
		Path data = new Path();
		String path3 = data.userPath+"userList.txt";
		
		String phoneNumber = "";
		BufferedReader reader1 = new BufferedReader(new FileReader(path3));
		String line4;
		String id = "";
		while ((line4 = reader1.readLine()) != null) {
			String temp[] = line4.split("■");
			if (temp[0].equals(ID)) {
				phoneNumber = temp[3];
			}
		}
		
		reader1.close();
		
		String path = data.reservationPath + "member\\" + phoneNumber + ".txt";
	
			BufferedReader reader = new BufferedReader(new FileReader(path));

			String[] temp = reader.readLine().split("■");
			String num = temp[0]; // 영화 고유 번호
			String day = temp[1]; // 영화 상영 날짜
			String seat = temp[7]; // 좌석 영어
			
			
			reader.close();
			
			File file = new File(path);
			file.delete();

			path = data.theaterPath + temp[2] + "\\" + temp[1] + ".txt";		// 해당 예약 내역이 있는 theater의 날짜 폴더


			reader = new BufferedReader(new FileReader(path));
			
			String line;
			String all="";
			String seatNum;
			String front ="";
			String[] part;
			while ((line = reader.readLine()) != null) {
				//1■강남점■3■담보■08:00■10:00■0100100101100010100111110
				if (line.split("■")[0].equals(num)) { // 해당 line 찾기
					part = line.split("■");
					seatNum = line.split("■")[6];// -> 좌석숫자 (ex 1110111101011)
					front = part[0]+"■"+part[1]+"■"+part[2]+"■"+part[3]+"■"+part[4]+"■"+part[5];
					String line2 = seatNum; // 현재예약현황 // 좌석 숫자
					String[] cols = new String[] { "A", "B", "C", "D", "E" };
					String[] rows = new String[] { "1", "2", "3", "4", "5" };
					String reservedSeat = seat; //(ex A4 A5)
					String[] reserved = reservedSeat.split(" ");
					String resultLine = "";
					int count = 0;

					for (int i = 0; i < reserved.length; i++) {// 모든자리 비교
						resultLine = "";
						for (int j = 1; j <= 5; j++) {// 세로
							String col = cols[j - 1];

							for (int k = 1; k <= 5; k++) {// 가로
								String row = rows[k - 1];

								char c = line2.charAt(count++); // 자리

								if ((col + row).equals(reserved[i])) // 합쳐져서 예약되어있는자리면
									resultLine += 0;
								else
									resultLine += c;

							}
						}

						line2 = resultLine; // 숫자
						count = 0;
						
						
					}
					all += front +"■" + line2 +"\n";


				} else {
					all += line + "\n";
				}
				
			}
			reader.close();
			
			//System.out.println(all);
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			
			writer.write(all);
			writer.close();
			
			String path2 = data.reservationPath + "member\\" + phoneNumber + ".txt";
		
			File file2 = new File(path2);
			file2.delete();
			
			System.out.println("\t\t\t예약을 취소했습니다.");
			BookingMovie.main(userInfo);

		} catch (Exception e) {
			System.out.println("CancelReservation.main()");
			e.printStackTrace();
		}

	}

}
