package fi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		// Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = null;
		
		Statement stSelect = null;
		
		Statement stUpdate = null;
		
		PreparedStatement psInsert = null;
		
		PreparedStatement psUpdate = null;
		
		ResultSet result = null;
		
		Scanner scanner = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac_acts","acts","Cdac@123");
			
			stSelect = connection.createStatement();
			psInsert = connection.prepareStatement(
					"insert into users(username,email) values(?,?)");
			
			psUpdate = connection.prepareStatement("update users set name=? where userName=?");
			scanner = new Scanner(System.in);
			//result = selectQuery(stSelect);
			
			System.out.println("Enter the useranme");
			String userName = scanner.next();
			
			/*System.out.println("enter hte passw");
			String password = scanner.next();
			*/
			System.out.println("enter the name");
			String name = scanner.next();
			
			psUpdate.setString(1, name);
			psUpdate.setString(2, userName);
			
			psUpdate.executeUpdate();
			
			
			/*
			 * System.out.println("enter the email"); String email = scanner.next();
			 * psInsert.set psInsert.setString(1, userName); psInsert.setString(2,
			 * password); psInsert.setString(3, name); psInsert.setString(4, email);
			 */
			//psInsert.executeUpdate();
			System.out.println("Record saved");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(scanner!=null)
					scanner.close();
				if(result!=null)
					result.close();
				if(psInsert!=null)
					psInsert.close();
				if(stSelect!=null)
				stSelect.close();
				if(connection!=null)
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
	}

	private static ResultSet selectQuery(Statement stSelect) throws SQLException {
		ResultSet result;
		result = stSelect.executeQuery("select * from users");
		
		while(result.next())
		{
			System.out.println(result.getString(1));
			System.out.println(result.getString("password"));
			System.out.println(result.getString(3));
			System.out.println(result.getString(4));
			System.out.println("******************************");
		}
		return result;
	}

}
