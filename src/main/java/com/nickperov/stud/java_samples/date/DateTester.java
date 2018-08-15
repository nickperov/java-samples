package com.nickperov.stud.java_samples.date;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateTester {
	
	public static void main(String... str) {
		dateInitTest01();
		dateInitTest02();
		
		dateShiftTest01();
		
		dateShiftTest02();
		
		dateShiftTest03();
		///-Duser.timezone="America/Asuncion" -Duser.country=PY
	}
	
	
	public static void dateInitTest01() {
		
		System.out.println("===========================dateInitTest01==============================");
		
		Date date1 = new Date(1444014000000L);
		Date date2 = new Date(1444017600000L);
		
		System.out.println(date1);
		System.out.println(date2);		
	}
	
	public static void dateInitTest02() {
		System.out.println("==============================dateInitTest02===========================");
		Date date1 = new SimpleDateFormat("yyyyMMdd").parse("20151005", new ParsePosition(0));
		System.out.println(date1);
		System.out.println(date1.getTime());
		//operday -> //1443956400000
		
		//1443956400000
		//1444014000000L
	}
	
	public static void dateShiftTest01() {
		System.out.println("============================dateShiftTest01=============================");
		
		System.out.println(System.getProperty("java.version"));
		
		TimeZone.setDefault(TimeZone.getTimeZone("America/Asuncion"));
		
		Calendar c = Calendar.getInstance();
		Calendar cl = Calendar.getInstance();
		
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		
		Date date = df.parse("20151002", new ParsePosition(0));
		
		System.out.println("Orig date: " + date);
		
		c.setTime(date);
		c.add(Calendar.DATE, 1);
		System.out.println("Shift 1 day : " + c.getTime());
		c.add(Calendar.DATE, 1);
		System.out.println("Shift 1 day : " + c.getTime());
		c.add(Calendar.DATE, 1);
		System.out.println("Shift 1 day : " + c.getTime());
		
		cl.setTime(date);
		cl.add(Calendar.DATE, 3);
		System.out.println("Shit 3 days: " +  cl.getTime());
		
		Date dateChange = df.parse("20151004", new ParsePosition(0));
		System.out.println(dateChange);
	}
	
	public static void dateShiftTest02() {
		System.out.println("============================dateShiftTest02=============================");
		
		TimeZone.setDefault(TimeZone.getTimeZone("America/Santiago"));
		
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		
		Date date = df.parse("20140901", new ParsePosition(0));
		
		
		
		System.out.println("Orig date: " + date);
		c.setTime(date);
		System.out.println(c.getTimeZone().getID());
		for (int i = 0; i < 7; i++) {
			c.add(Calendar.DATE, 1);
			System.out.println("Shift 1 day : " + c.getTime());
		//	System.out.println("Hours 1 day : " + c.get(Calendar.HOUR));
			
		}
		
	}
	

	public static void dateShiftTest03() {
		System.out.println("============================dateShiftTest03=============================");
		
		TimeZone.setDefault(TimeZone.getTimeZone("America/Santiago"));
		
		TimeZone tz = TimeZone.getDefault();
		
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		
		Date date = df.parse("20140908", new ParsePosition(0));		
		
		System.out.println("DST offset: " + c.get(Calendar.DST_OFFSET));
		
		System.out.println("Orig date: " + date);
		c.setTime(date);
		
		System.out.println("DST offset: " + c.get(Calendar.DST_OFFSET));
		
		c.add(Calendar.DATE, -1);
		System.out.println("Shift 1 day : " + c.getTime());
		System.out.println(tz.inDaylightTime(c.getTime()));
		
		System.out.println("DST offset: " + c.get(Calendar.DST_OFFSET));
	}
}
