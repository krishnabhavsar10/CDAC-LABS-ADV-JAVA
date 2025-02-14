package com.cdac.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Connection connection = null;
		Statement stSelect  = null;
//		Statement stUpdate = null;
		Statement stInsert = null;
		ResultSet result = null;
		
		Scanner sc;
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
			
			stSelect = connection.createStatement();
			stInsert = connection.createStatement();
//			stUpdate = connection.createStatement();
			
			sc = new Scanner(System.in);
			
			System.out.println("Enter Deparment No: ");
			int deptno = sc.nextInt();
			
			System.out.println("Enter Deparment Name: ");
			String dname = sc.next();
			
			System.out.println("Enter Deparment Location: ");
			String dloc = sc.next();
			
			String sqlQuery = "insert into dept values('" +
								deptno + "','" +
								dname +  "','" +
								dloc + "')";
			
			System.out.println(sqlQuery);
			
			stInsert.executeUpdate(sqlQuery);
			
			System.out.println("Insertion Successfull");
			
			printDB(stSelect);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			 try {
				 if(result != null) result.close();
				 if(stSelect != null) stSelect.close();
				 if(connection != null) connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

	}
	
	private static void printDB(Statement stSelect) throws SQLException {
		ResultSet result = stSelect.executeQuery("select * from dept");
		
		while(result.next()) {
			System.out.println(
					result.getString(1) + " "
		               + result.getString(2) + " " 
							+ result.getString(3)
							);
			System.out.println("----------------------");
	
		}	
	}

}
