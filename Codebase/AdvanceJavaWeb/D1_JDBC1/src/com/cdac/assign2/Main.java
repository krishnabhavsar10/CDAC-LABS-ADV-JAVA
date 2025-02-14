package com.cdac.assign2;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Properties dbProperties = new Properties();
		
		try(Scanner sc = new Scanner(System.in)) {
			dbProperties.load(new FileInputStream("DB.properties"));
			String url =  dbProperties.getProperty("connection.url");
			String username = dbProperties.getProperty("connection.username");
			String password = dbProperties.getProperty("connection.password");
			
			Connection connection = DriverManager.getConnection(url, username, password);
			
//			createTable(connection, sc);
			
		
			// Using MetaData 
			String tableName = "krishna";
			
			DatabaseMetaData dmd = connection.getMetaData();
			
			ResultSet rs = dmd.getColumns(null, null, tableName, null);
			
			while(rs.next()) {
				System.out.println(rs.getString("COLUMN_NAME"));
			}
				
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		

	}

	private static void createTable(Connection connection, Scanner sc) throws SQLException {
		System.out.print("Enter Name of the Table: ");
		String tableName = sc.next();
		
		System.out.print("Enter Number of Columns to create: ");
		int columnNum = sc.nextInt();
		sc.nextLine();
		
		StringBuilder sb = new StringBuilder("CREATE TABLE " + tableName + " ( ");
		
		for(int i = 0 ;i < columnNum; i++) {
			System.out.print("Column " + (i + 1) + " Data : ");
			String columnData = sc.nextLine();
			
			sb.append(columnData);
			if(i < columnNum - 1) {
				sb.append(" , ");
			}
			
		}
		sb.append(" ) ");
		
		System.out.println(sb.toString());
		
		PreparedStatement psCreateTable = connection.prepareStatement(sb.toString());
		
		psCreateTable.executeUpdate();
		
		System.out.println("Table Created Successfully !!");
	}

	
}
