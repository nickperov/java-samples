package com.nickperov.stud.java_samples.collections.api;

import java.util.ArrayList;

public class ArrayListTester001 {
	
	public static void main(String[] str) {
		ArrayList<? extends I> list = new ArrayList<A>();
	}

	
interface I {
	
}
class A implements I {
}

}
