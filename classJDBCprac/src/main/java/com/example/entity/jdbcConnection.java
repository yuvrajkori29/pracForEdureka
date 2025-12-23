package com.example.entity;

import java.sql.Connection;
import java.sql.DriverManager;

public class jdbcConnection{
	   
	public static Connection dbUtil(){
		Connection connection = null; 
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection(
		            "jdbc:mysql://localhost:3306/shop", "root", "Root123$"
		        );
			
			
			  System.out.println("Connection created");
			
			
		}catch (Exception e) {
            System.out.println(e);
	}
		
		return connection;
	}
}