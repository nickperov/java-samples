package com.nickperov.stud.java_samples.collections.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionTester001 {

	
	public static void main(String[] str) {
		testCollection001();
		testCollection002();
	}
	
	private static void testCollection001() {
		System.out.println("==========Test 001=========");
		
		CollectionProvider collProv = new CollectionProvider();
		
		collProv.traceArray();
		
		System.out.println("======= Edit array =======");
		ArrayList<String> array = (ArrayList<String>) collProv.getArray();
		array.add("New NAME");
		
		collProv.traceArray();
		
	}
	
	private static void testCollection002() {
		System.out.println(" =========Test 002===========");
		
		CollectionProvider collProv = new CollectionProvider();
		
		collProv.traceArray();
		
		System.out.println("======= Edit array =======");
		Collection<String> array = collProv.getUnmodiffiableArray();
	//	array.add("New NAME");
		
		collProv.traceArray();
	}
	
}


class CollectionProvider {
	
	private ArrayList<String> array;
	
	public CollectionProvider() {
		array = new ArrayList<>();
		array.add("Nikolay");
		array.add("Ivan");
		array.add("Andrey");
		array.add("Bob");
		array.add("Mike");
	}
	
	public Collection<String> getArray() {
		return array;
	}
	
	public Collection<String> getUnmodiffiableArray() {
		return Collections.unmodifiableCollection(array);
	}
	
	public void traceArray() {
		for (String str : array)
			System.out.println(str);
	}
	
}

/*class CollectionSubscriber {
	
	CollectionProvider collProvider;
	
	public CollectionSubscriber(CollectionProvider collProvider) {
		this.collProvider = collProvider;
	}
	
	
	
}*/