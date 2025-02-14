package com.cdac.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {

		
		try(
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
			Statement stSelect = connection.createStatement();
			PreparedStatement psUpdate = connection.prepareStatement("update dept set dname=? where deptno=?");
			){
			
			String dname = "Manit";
			int dno = 80;
			
			printAllTable(stSelect);
			
			psUpdate.setString(1,dname);
			psUpdate.setInt(2,dno);
			
			psUpdate.executeUpdate();
			
			System.out.println("Update Successfull !!");
			
			printAllTable(stSelect);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	private static void printAllTable(Statement stSelect) throws SQLException {
		ResultSet result = stSelect.executeQuery("select * from dept");
		
		while(result.next()) {
			System.out.println(
					result.getString(1) + " "
		               + result.getString(2) + " " 
							+ result.getString(3)
							);
			System.out.println("----------------------");
	
		}	
		
		System.out.println("\n**********************\n");
		
	}

}
