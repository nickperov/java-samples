package com.nickperov.stud.java_samples.collections.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class ArrayListTester002 {
	
	public static void main(String[] args) {
		
		copyAndSortTest();
		
	}
	
	public static void copyAndSortTest() {
		ArrayList<Integer> srcList = new ArrayList();
		List<Integer> dstList = new ArrayList();
		
		while (true) {
			srcList.add(new Random().nextInt(100000));
			if (srcList.size() == 30)
				break;
		}
		
		dstList.addAll(srcList);
		dstList.sort(Comparator.comparingInt(elem -> elem));
		
		System.out.println(srcList);
		System.out.println(dstList);
		
	}
}
