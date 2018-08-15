package com.nickperov.stud.java_samples.basic;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;


public class BDTest001 {

	public static void main(String[] args) {
		BigDecimal value1 = new BigDecimal( "0.9392812568355228" );
		BigDecimal value2 = new BigDecimal( "0.9392813" );

		System.out.println( "value1 = " + value1.toPlainString() + "; value2 = " + value2.toPlainString() );
		
		System.out.println("Comparison result (value1 - value2): " + value1.compareTo( value2 ) );
		
		int pr1 = value1.precision();
		int pr2 = value2.precision();
		
		System.out.println( "Pr1 = " + pr1 + "; Pr2 = " + pr2 );
		
		if ( Integer.compare( pr1, pr2 ) > 0 ) {
			System.out.println("Comparison result (value1 - value2): " + value1.round( new MathContext(pr2, RoundingMode.HALF_UP ) ).compareTo( value2 ) );
		} else {
			System.out.println("Comparison result (value1 - value2): " + value1.compareTo( value2.round( new MathContext(pr1, RoundingMode.HALF_UP ) ) ) );
		}
		
		System.out.println( "value1 = " + value1.toPlainString() + "; value2 = " + value2.toPlainString() );
	}

}
