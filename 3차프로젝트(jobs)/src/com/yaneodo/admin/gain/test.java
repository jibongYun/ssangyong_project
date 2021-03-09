package com.yaneodo.admin.gain;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class test {

	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		String date = "2021-01-12";
	
	try {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dates = formatter.parse(date);
		cal.setTime(dates);
		cal.add(Calendar.DATE, -7);
				
		String end = String.format("%tF", cal);
		
		String daystart = end.substring(2,4) +"/"+ end.substring(5,7)+"/"+end.substring(8);
		
		System.out.println(daystart);
		
	} catch (Exception e) {
		System.out.println(e);
	}
	}
}