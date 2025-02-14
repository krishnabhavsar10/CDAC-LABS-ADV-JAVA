package fi.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties dbProperties = new Properties();
		try {
			dbProperties.load(new FileInputStream("DB.properties"));
			String dbUrl = dbProperties.getProperty("connection.url");
			String dbUser = dbProperties.getProperty("connection.username");
			String dbPwd = dbProperties.getProperty("connection.password");
			
			try(
				Connection connection = DriverManager.getConnection(
								dbUrl,dbUser,dbPwd);
					
				PreparedStatement psSelect= connection.prepareStatement("select * from users");
					ResultSet result = psSelect.executeQuery();
					)
			{
				DatabaseMetaData dmd = connection.getMetaData();
				ResultSet resultTables = dmd.getTables(null, "cdac_acts", null, new String[] {"TABLE"});
				while(resultTables.next())
				{
					//System.out.println(resultTables.getString(1));
					//System.out.println(resultTables.getString(2));
					System.out.println(resultTables.getString(3));
					//System.out.println(resultTables.getString(4));
				}
				
				ResultSet resultColumn = dmd.getColumns(null, "cdac_acts", "users", null);
				while(resultColumn.next())
				{
					System.out.println(resultColumn.getString(1));
					System.out.println(resultColumn.getString(2));
					System.out.println(resultColumn.getString(3));
					System.out.println(resultColumn.getString(4));
					System.out.println(resultColumn.getString(5));
				}
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
