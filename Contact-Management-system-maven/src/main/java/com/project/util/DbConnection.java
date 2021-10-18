package com.project.util;

import java.sql.*;

public class DbConnection {
	public static Connection getOracleConnection() {
		Connection cn= null;
		   try {
			String url="jdbc:oracle:thin:@//localhost:1521/XEPDB1";
			cn = DriverManager.getConnection(url,"hr","hr");
		} catch (Exception e) {
			e.printStackTrace();
		}
		  return cn;
	}
}
