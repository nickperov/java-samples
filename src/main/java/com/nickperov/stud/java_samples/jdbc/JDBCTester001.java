package com.nickperov.stud.java_samples.jdbc;

import java.sql.SQLException;



public class JDBCTester001 {
	
	final static String oracleLocalURL = "jdbc:oracle:thin:@localhost:1521:SSYS";
	final static String selectCurrencies = "SELECT * FROM D_CURRENCIES order by CURRENCY_ID";
	final static String oracleUser = "DEPO";
	final static String oraclePassword = "SSYS";
	
	public static void main(String[] args) {
		
		
//		AbstractOracleConnectionTest tester = new OracleConnectionTest001();
		AbstractOracleConnectionTest tester = new OracleConnectionTest002();
		try {
			tester.loadDriver();
		} catch (ClassNotFoundException e) {
			System.out.println( "Loading driver problem: " + e.getLocalizedMessage() );
		}catch (SQLException e) {
			System.out.println( "Loading driver problem: " + e.getLocalizedMessage() );
		}
		
		try {
			tester.testConnection(oracleLocalURL, selectCurrencies, oracleUser, oraclePassword);
		} catch (SQLException e) {
			System.out.println( "SQL Exception while test: " + e.getLocalizedMessage() );
		}
	}

}
