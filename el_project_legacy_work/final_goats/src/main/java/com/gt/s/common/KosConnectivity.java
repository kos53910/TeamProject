package com.gt.s.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class KosConnectivity {

	public static final String JDBC_ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String JDBC_ORACLE_URL = "jdbc:oracle:thin:@192.168.0.35:1521:orclLSB00";
	public static final String JDBC_ORACLE_USER = "goats";
	public static final String JDBC_ORACLE_PWD = "goats00";
	
	public static final String JDBC_MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String JDBC_MYSQL_URL = "jdbc:mysql://192.168.0.35:3306/goats";
	public static final String JDBC_MYSQL_USER = "goats";
	public static final String JDBC_MYSQL_PWD = "goats00";
	
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			Class.forName(JDBC_ORACLE_DRIVER);
			conn = DriverManager.getConnection(JDBC_ORACLE_URL, JDBC_ORACLE_USER, JDBC_ORACLE_PWD);
		} catch (Exception e) {
			System.out.println(" DB 연결 중 에러 발생. > : " + e);
		}
		
		
		return conn;
	}
	
	public static Connection getConnectionMysql() {
		
		Connection conn = null;
		
		try {
			Class.forName(JDBC_MYSQL_DRIVER);
			conn = DriverManager.getConnection(JDBC_MYSQL_URL, JDBC_MYSQL_USER, JDBC_MYSQL_PWD);
		} catch (Exception e) {
			System.out.println(" DB 연결 중 에러 발생. > : " + e);
		}
		
		
		return conn;
	}
	
	public static void conClose(Connection conn, PreparedStatement pstmt) {
		
		try {
			if(pstmt != null) try {pstmt.close(); pstmt=null;} catch(Exception e) {}
			if(conn != null) try {conn.close(); conn=null;} catch(Exception e) {}
		}catch(Exception e) {}
		
	}
	
	public static void conClose(Connection conn, PreparedStatement pstmt, ResultSet rsRs) {
		try {
		if(pstmt != null) try {pstmt.close(); pstmt=null;} catch(Exception e) {}
		if(conn != null) try {conn.close(); conn=null;} catch(Exception e) {}
		if(rsRs != null) try {rsRs.close(); rsRs=null;} catch(Exception e) {}
		}catch(Exception e) {}
	}
}