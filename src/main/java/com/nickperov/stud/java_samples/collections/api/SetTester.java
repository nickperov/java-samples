package com.nickperov.stud.java_samples.collections.api;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

public class SetTester {
	public static void main(String[] str) {
		
		HashSet<Long> megaSet = new HashSet<>();
		megaSet.add(1L);
		megaSet.add(2L);
		System.out.println(megaSet.contains(null));

		Comparator<String> cmp = null;
		
		TreeSet<String> strSet = new TreeSet<>(Comparator.naturalOrder());
		
		strSet.add("1Gamma");
		strSet.add("1alfa");
		strSet.add("1betta");
		
		System.out.println(strSet);
		
	}
	
	

}
