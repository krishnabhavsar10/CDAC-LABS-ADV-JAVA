package com.cdac.usingfiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Main {

	public static void main(String[] args) {
		Properties dbProperties = new Properties();
		
		try {
			dbProperties.load(new FileInputStream("Db.properties"));
			
			String url = dbProperties.getProperty("connection.url");
			String username = dbProperties.getProperty("connection.username");
			String password = dbProperties.getProperty("connection.password");
			
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stSelect = conn.createStatement();
			ResultSet result = stSelect.executeQuery("Select * From Dept");
			
			while(result.next()) {
				System.out.println(
						result.getString(1) + " "
			               + result.getString(2) + " " 
								+ result.getString(3)
								);
				System.out.println("----------------------");
		
			}	
			
			
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
