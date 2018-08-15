package com.nickperov.stud.java_samples.collections.api;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionSortTests {
	
	public static void main(String[] args) {
		Set<String> strSet = genTestSet(1000000);
		printSet(strSet);
		System.out.println("=================================================");
		
		long startTime = System.nanoTime();
		List<String> sortedStrSet = strSet.stream().sorted().collect(Collectors.toList());
		long finishTime = System.nanoTime();
		
		printSet(sortedStrSet);
		double timeDelta = (finishTime - startTime) / 1000000;
		System.out.println("Time:" + timeDelta + " ms");
	}
	
	private static void printSet(Collection<String> strSet) {
		strSet.forEach(str -> System.out.println(str));
	}
	
	private static Set<String> genTestSet(int size) {
		HashSet<String> strSet = new HashSet<>();
		for (int i = 0; i < size; i++)
			strSet.add(genStrValue());
		
		return strSet;
	}
	
	private static String genStrValue() {
		Random rnd = new Random();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 5; i++)
			sb.append((char) (65 + rnd.nextInt(25)));
		
		return sb.toString();
	}
	
}