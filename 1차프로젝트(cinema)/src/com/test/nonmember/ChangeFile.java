package com.test.nonmember;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import data.Path;

public class ChangeFile {
	public static void main(String[] movieInfo, String phone) {

		
		/*for(int i=0; i<movieInfo.length; i++)
		System.out.println(movieInfo[i]);
	0	12
	1	날짜
	2	강남
	3	2
	4	도굴
	5	09:00
	6	11:00
	7	0001001010011101011111100//얜안씀
	8	20000
	9	A1 A3
	 */
		
		String seat = movieInfo[7];
		String reservedSeat = movieInfo[9];
		seat = changeSeat(seat, reservedSeat);	//결제한 자리를 0에서 1로 바꿔준다.
		
		try {
			Path path = new Path();
			String readPath = path.reservationPath + "nonmember\\" + phone + ".txt";
			File file = new File(readPath);
			
			//예약한 것 때문에 파일 생성해줌
			file.createNewFile();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(readPath));
			String finalReserveLine = movieInfo[0] + "■" + movieInfo[1] + "■" + movieInfo[2] + "■" + movieInfo[3] + "■" +
									movieInfo[4] + "■" + movieInfo[5] + "■"  + movieInfo[6] + "■" + movieInfo[9] + "■" + movieInfo[8];
			
			writer.write(finalReserveLine);
			writer.close();
			
			readPath = path.adminPath + movieInfo[2] + "\\" + movieInfo[1] ;
			file = new File(readPath);
			
			if(!file.exists()) {	//폴더가 존재하지않으면
				file.mkdir();		//만들어준다
				readPath = readPath + "\\present_condition.txt";	//Path 변경
				file = new File(readPath);	//파일도 변경
				file.createNewFile();		//파일도 만들어준다
				writer = new BufferedWriter(new FileWriter(file));	//새로 쓴다
				writer.write(movieInfo[8]+"■0");
				writer.close();
			} else {	//파일이 존재하면
				
				readPath = readPath + "\\present_condition.txt";	//파일주소
				file = new File(readPath);
				
				BufferedReader reader = new BufferedReader(new FileReader(file));

				String line = reader.readLine();
				
				String[] conditionInfo = line.split("■");
				//conditionInfo[0] 영화예약매출 // conditionInfo[1] 스낵매출
				movieInfo[8] = (Integer.parseInt(conditionInfo[0])+Integer.parseInt(movieInfo[8])) + "";
				String result = movieInfo[8] + "■" + conditionInfo[1]; 
				writer = new BufferedWriter(new FileWriter(file));
				writer.write(result);

				writer.close();
				reader.close();
				
				readPath = path.theaterPath + movieInfo[2] + "\\" + movieInfo[1] + ".txt";
												//지점					//날짜
				
				reader = new BufferedReader(new FileReader(readPath));
				String modifyLine = "";
				line = "";
				while ((line = reader.readLine()) != null) {
					String[] movie = line.split("■");
					//System.out.println(readPath + " " + line + " " + movieInfo[0]);
					if(movie[0].equals(movieInfo[0])) {//상영번호와 일치하면
						line = line.replace(movie[movie.length-1], seat);
						modifyLine = modifyLine + line + "\n";
					}
					else
						modifyLine = modifyLine + line + "\n";
				}
				
				reader.close();
				writer = new BufferedWriter(new FileWriter(readPath));
				writer.write(modifyLine);
				writer.close();
			}
			
		} catch (Exception e) {
			System.out.println("ChangeFile.main()");
			e.printStackTrace();
		}

		System.out.println("\t\t\t예약이 완료되었습니다!");
		
		for(int i=0; i<movieInfo.length; i++)
			movieInfo[i] = null;
	}

	private static String changeSeat(String beforeSeat, String reservedSeat) {
				//현재예약현황
		String[] cols = new String[] { "A", "B", "C", "D", "E"};
		String[] rows = new String[] { "1", "2", "3", "4", "5"};
		String[] reserved = reservedSeat.split(" ");
		String afterSeat = "";
		int count = 0;

		//예약된자리 change logic
		for(int i=0; i<reserved.length; i++) {//모든자리 비교
			afterSeat = "";
			for(int j=1; j<=5; j++) {//세로
				String col = cols[j-1];

				for(int k=1; k<=5; k++) {//가로
					String row = rows[k-1];

					char c = beforeSeat.charAt(count++);	//자리

					if((col+row).equals(reserved[i]))	//합쳐져서 예약되어있는자리면
						afterSeat = afterSeat + 1;
					else
						afterSeat = afterSeat + c;
					
				}
			}
			beforeSeat = afterSeat;
			count = 0;
		}
		
		return afterSeat;
	}
}
