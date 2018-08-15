package com.nickperov.stud.java_samples.basic;

public class CharTester {
	
	public static void main(String[] args) {
		
		char[] charArray = {'A','B','C','1','2','3',']','}',',','-','_','@','\\','\u0012','\n','\r','û','~','¸','ú'};
		
		
		/*Character chLetter = new Character( 'A' );
		Character chNumber = new Character( '1' );
		
		Character chBreak = new Character( '{' );
		Character chComma = new Character( ',' );*/
		
		
		for ( int i = 0; i < charArray.length; i++ ) {
			
			System.out.println( charArray[i]  + " ---> isLetter: " + Character.isLetter( charArray[i]  ) + 
					"; isDigit: " + Character.isDigit( charArray[i] ) + 
					"; isISOControl: " + Character.isISOControl( charArray[i] ) );
		}
	}
}
