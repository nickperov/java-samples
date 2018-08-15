package com.nickperov.stud.java_samples.basic;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class StringTester {

	public static void main(String[] args) {

		//testST001();
		
		//testST002();
		
		//testST003();
		
		//test004();
		
		testST005();
		
		testST006();
	}
	
	
	
	private static void testST001() {
		StringBuilder sb = new StringBuilder();
		
		sb.append( "Test Text " );
		sb.append("\n\\\\BUYBACKPRIC/");
			
			
		System.out.println( sb.toString() );
	}

	
	private static void testST002() {
		
		String pCodeOrig = "INV0CITIX001";
		String pCodeModif;
		
		if ( pCodeOrig.length() == 12 ) {
			pCodeModif = pCodeOrig.substring(0, 8) + ( pCodeOrig.substring(8).equals("XXXX") ? "" : pCodeOrig.substring(9) );
        } else {
        	pCodeModif =  pCodeOrig;
        }
		
		System.out.println( pCodeModif );
	}
	
	private static void testST003() {
		
		String secType =  "NA/DTFTFN";
		if ( secType.contains( "/" ) )
			secType = secType.substring(0, secType.indexOf( '/' ) );
			
			
		System.out.println( secType );
	}
	
	private static void test004() {
		//String[] sbTypes = {"PLED","COLL","AVAI"};
		String[] sbTypes = {"",null,null};
		final StringBuilder sbTypesInSb = new StringBuilder();
		for (String sbType : sbTypes)
			if (sbType != null && !sbType.isEmpty()) sbTypesInSb.append('\'').append(sbType).append('\'').append(',');
		
		if (sbTypesInSb.length() != 0)
			sbTypesInSb.deleteCharAt(sbTypesInSb.length()-1);
		
		System.out.print(sbTypesInSb.toString());
	}
	
	private static void testST005() {
		StringBuilder sb = new StringBuilder();
		
		sb.append( "Test Text " );
		sb.append("\n\\\\BUYBACKPRIC/");
		
		sb.append('A');
			
		System.out.println( sb.toString() );
	}
	
	
	private static void testST006() {
		// Validate String against regexp
		System.out.println("RegExp validation test");
		
		List<String> testStrings = new ArrayList<>();
		
		testStrings.add("UYI/UYU(CSE)"); //Good
		testStrings.add("USD/RUB(Test rate type)"); //Good
		testStrings.add("USD/RUB(Complicated (%) test rate type!!!)"); //Good
		testStrings.add("EUR/USD"); //Good
		testStrings.add("USD/RUB(bad"); //Bad
		testStrings.add("usd/RUB(bad)"); //Bad
		
		
		String regExp = "[A-Z]{3}[/][A-Z]{3}([(]{1}.*[)]{1}){0,1}";
		
		System.out.println(regExp);
		
		for (String str : testStrings) {
			System.out.print("STR: " + str + " Validation result: ");
			System.out.println(str.matches(regExp));
			if (str.contains("(")) {
				String rateType = str.substring(str.indexOf("(") + 1, str.length() - 1);
				System.out.println("!!! Contains Rate type: " + rateType);
			}
		}
		
		
	}
}
