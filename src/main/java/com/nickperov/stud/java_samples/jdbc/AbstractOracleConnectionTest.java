package com.nickperov.stud.java_samples.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public abstract class AbstractOracleConnectionTest {
	
	private Connection conn;
	protected OracleDataSource ods;
	
	public abstract void loadDriver() throws ClassNotFoundException, SQLException;

	public void testConnection(String url, String sql, String user, String password) throws SQLException {
		if (conn == null || conn.isClosed() ) {
			if (ods == null)
				conn = DriverManager.getConnection(url, user, password);
			else {
			    ods.setUser(user);
			    ods.setPassword(password);
			    ods.setURL(url);
				conn = ods.getConnection();
			}
		}
			
		
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		StringBuilder sb = new StringBuilder();
		
		int columnCount = rs.getMetaData().getColumnCount();
		StringBuilder namesSb = new StringBuilder();
			
		System.out.println( namesSb.toString() );
		while(rs.next()) {

			for ( int i = 1; i < columnCount + 1; i++ ) {
				sb.append( rs.getString(i) ).append( " | ");
			}
			
			System.out.println( sb.toString() );
			sb.delete(0, sb.length());
		}
		st.close();
		rs.close();
		conn.close();
	}
}
