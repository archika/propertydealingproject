package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Daopro{
	public static Connection getConnection() {
		Connection conn =null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");	
			conn= DriverManager.getConnection(
			"jdbc:oracle:thin:@127.0.0.1:1521:XE", "root", "root");
		}
		catch (ClassNotFoundException e){
			System.out.println(e);
		}
		catch (SQLException e){
			System.out.println(e);
		}
		return conn;
	}
}