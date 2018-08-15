package com.nickperov.stud.java_samples.collections.api;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class HashMapTester {
	

	public static void main(String ... args) {
		test001();
		test002();
	}
	
	private static void test001() {
		
		System.out.println("=================test001===========");
		// Order test 01
		HashMap<Long, String> cities = new HashMap<Long, String>();
		
		cities.put(2L, "Moscow");
		cities.put(1L, "Auckland");
		cities.put(3L, "New York");
		
		for(String city : cities.values()) {
			System.out.println(city);
		}
		
	}
	
	
	private static void test002() {
		
		System.out.println("=================test002===========");
		// Order test 02
		LinkedHashMap<Long, String> cities = new LinkedHashMap<Long, String>();
		
		cities.put(2L, "Moscow");
		cities.put(1L, "Auckland");
		cities.put(3L, "New York");
		
		for(String city : cities.values()) {
			System.out.println(city);
		}
		
	}

}
