package com.nickperov.stud.java_samples.basic;

public class FPCalculationTest001 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double v1, v2, v3, v4, v5;
		
		v1 = 0.2d;
		v2 = 0.2f;
		
		/*v1 = 0.125d;
		v2 = 0.125f;*/
		
		v4 = -0d;
		v5 = 0d;
		
		boolean b1 = v4 == v5;
		System.out.println( b1 );
		
		v3 = v1 + v2;
		
		System.out.println( v1 );
		System.out.println( v2 );
		System.out.println( v3 );
		System.out.println( v4 );
	}

}
