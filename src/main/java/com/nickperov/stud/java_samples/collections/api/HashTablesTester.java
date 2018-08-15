package com.nickperov.stud.java_samples.collections.api;

import java.util.HashSet;

public class HashTablesTester {
	
	private static String[] names = {"Bob", "John", "Mike", "Jay", "Kate"};
	
	public static void main(String[] args) {
		
		HashTablesTester htTester = new HashTablesTester();
		
		htTester.fillHashSet();
		
	}
	
	private void fillHashSet() {
		
		HashSet<String> stSet = new HashSet<>(5);
		
		for (String n : names) {
			stSet.add(n);
		}
	}
}