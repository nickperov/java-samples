package com.nickperov.stud.java_samples.date;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.joda.time.DateTime;

public class DateJodaTimeTester {
	
	public static void main(String... str) {
		
		jodaTimeTest001();
		
	}
	
	private static void jodaTimeTest001() {
		
		TimeZone.setDefault(TimeZone.getTimeZone("America/Santiago"));
		
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date date = df.parse("20140901", new ParsePosition(0));
		
		DateTime dt = new DateTime(date);
		TimeZone tz = TimeZone.getDefault();
		
		System.out.println(dt);
		System.out.println(dt.toDate());
		
		for (int i = 1; i < 10; i++) {
			dt = dt.plusDays(1);
			System.out.print(dt.toDate());
			System.out.println(" is IN DST: " + tz.inDaylightTime(dt.toDate()));
		}
		
	//	dt.time
	//	dt.getDayOfYear();
		
		DateTime dtM = new DateTime(date);
		System.out.println(dtM.plusDays(9).toDate());
	}
}
