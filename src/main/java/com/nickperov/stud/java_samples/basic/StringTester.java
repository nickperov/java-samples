package com.nickperov.stud.java_samples.basic;

import java.util.ArrayList;
import java.util.List;

public class StringTester {

	public static void main(final String[] args) {

		//testST001();

		//testST002();

		//testST003();

		//test004();

		//testST005();

		//testST006();

		//testST007();

		//testST008();

		testST009();
	}


	private static void testST001() {
		final StringBuilder sb = new StringBuilder();

		sb.append("Test Text ");
		sb.append("\n\\\\BUYBACKPRIC/");

		System.out.println(sb.toString());
	}


	private static void testST002() {

		final String pCodeOrig = "INV0CITIX001";
		final String pCodeModif;

		if (pCodeOrig.length() == 12) {
			pCodeModif = pCodeOrig.substring(0, 8) + (pCodeOrig.substring(8).equals("XXXX") ? "" : pCodeOrig.substring(9));
		} else {
			pCodeModif = pCodeOrig;
		}

		System.out.println(pCodeModif);
	}

	private static void testST003() {

		String secType = "NA/DTFTFN";
		if (secType.contains("/")) {
			secType = secType.substring(0, secType.indexOf('/'));
		}

		System.out.println(secType);
	}

	private static void test004() {
		//String[] sbTypes = {"PLED","COLL","AVAI"};
		final String[] sbTypes = {"", null, null};
		final StringBuilder sbTypesInSb = new StringBuilder();
		for (final String sbType : sbTypes) {
			if (sbType != null && !sbType.isEmpty()) {
				sbTypesInSb.append('\'').append(sbType).append('\'').append(',');
			}
		}

		if (sbTypesInSb.length() != 0) {
			sbTypesInSb.deleteCharAt(sbTypesInSb.length() - 1);
		}

		System.out.print(sbTypesInSb.toString());
	}

	private static void testST005() {
		final StringBuilder sb = new StringBuilder();

		sb.append("Test Text ");
		sb.append("\n\\\\BUYBACKPRIC/");

		sb.append('A');

		System.out.println(sb.toString());
	}


	private static void testST006() {
		// Validate String against regexp
		System.out.println("RegExp validation test");

		final List<String> testStrings = new ArrayList<>();

		testStrings.add("UYI/UYU(CSE)"); //Good
		testStrings.add("USD/RUB(Test rate type)"); //Good
		testStrings.add("USD/RUB(Complicated (%) test rate type!!!)"); //Good
		testStrings.add("EUR/USD"); //Good
		testStrings.add("USD/RUB(bad"); //Bad
		testStrings.add("usd/RUB(bad)"); //Bad

		final String regExp = "[A-Z]{3}[/][A-Z]{3}([(]{1}.*[)]{1}){0,1}";

		System.out.println(regExp);

		for (final String str : testStrings) {
			System.out.print("STR: " + str + " Validation result: ");
			System.out.println(str.matches(regExp));
			if (str.contains("(")) {
				final String rateType = str.substring(str.indexOf("(") + 1, str.length() - 1);
				System.out.println("!!! Contains Rate type: " + rateType);
			}
		}
	}

	private static void testST007() {
		// Copy String

		final char[] charSequence = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g'};

		final StringBuilder sb = new StringBuilder();
		for (final char c : charSequence) {
			sb.append(c);
		}

		System.out.println("Original char sequence: " + sb.toString());

		printStrCopy(charSequence, 0, 1);

		printStrCopy(charSequence, 0, 2);

		printStrCopy(charSequence, 0, 5);

		printStrCopy(charSequence, 0, 0);

		printStrCopy(charSequence, 3, 0);

	}

	private static void testST008() {
		// CharArray to string
		final char[] charSequence = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g'};
		final String str = new String(charSequence);

		System.out.println("Copied string: " + str);

		for (int i = 0; i < charSequence.length; i++) {
			charSequence[i] = '*';
		}

		System.out.println("String after array erase: " + str);
	}

	private static void testST009() {
		// Try split
		final String str = "123456789Oiereuuerier";
		for (final String partStr : str.split("")) {
			System.out.println(partStr);

		}

	}

	private static void printStrCopy(final char[] charSequence, final int offset, final int length) {
		System.out.println("Offset " + offset + ", length " + length + ": " + new String(charSequence, offset, length));
	}


}
