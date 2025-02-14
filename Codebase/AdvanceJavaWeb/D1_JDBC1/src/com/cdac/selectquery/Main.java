package com.cdac.selectquery;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		
		Connection connection = null;
		Statement stSelect = null;
		ResultSet result = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
			stSelect = connection.createStatement();
			result = stSelect.executeQuery("select * from dept");
			
			while(result.next()) {
				System.out.println(
						result.getString(1) + " "
			               + result.getString(2) + " " 
								+ result.getString(3)
								);
				System.out.println("----------------------");
		
			}	
			
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

}
