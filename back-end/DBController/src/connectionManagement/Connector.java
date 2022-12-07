package connectionManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;*/
//import java.util.Scanner;

public class Connector {
	
	private static final String controller = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost/lucaantoniorubentable";
	private static final String user = "root";
	private static final String password = "";
	
	public static Connection ConnectToDB() {
		Connection connection = null;
		try {
			Class.forName(controller);
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connected!");
			return connection;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
	
	public static boolean CreateTable(Connection connection, String tableName) {
		int intResult;
		boolean result = false;
		
		try {
			Statement request = (Statement) connection.createStatement();
			intResult = request.executeUpdate("CREATE TABLE "+ tableName
					+ "(id int, "
					+ "firstName varchar(25) NULL, "
					+ "lastName varchar(25) NULL, "
					+ "phoneNumber varchar(20) NULL, "
					+ "email varchar(25) NULL, "
					+ "PRIMARY KEY (id)"
					+ ");");
			if (intResult == 0)
				result = true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		return result;
	}
	
	public static boolean InsertElement(Connection connection, String tableName, ModelDB element) {
		int intResult;
		boolean result = false;
		
		try {
			Statement request = (Statement) connection.createStatement();
			intResult = request.executeUpdate("INSERT INTO `"+ tableName
					+ "`(`id`, `firstName`, `lastName`, `phoneNumber`, `email`)"
					+ "VALUES('" + element.getId() + "', '" + element.getFirstName() + "', '" + element.getLastName() + "', '"+ element.getPhoneNumber() + "', '"+ element.getEmail() + "')");
			if (intResult == 1)
				result = true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		return result;
	}
	
	public static String ReadTable(Connection connection, String tableName) {
		String tableElements = "";
		
		tableElements = "ID - FIRST NAME - LAST NAME - PHONE NUMBER - EMAIL\n";
		try {
			Statement request = (Statement) connection.createStatement();
			ResultSet result = (ResultSet) request.executeQuery("SELECT * FROM " + tableName);

			while (result.next()) {
				tableElements += (result.getString(1) + " - " + result.getString(2) + " - " + result.getString(3) 
						+ " - " + result.getString(4) + " - " + result.getString(5) + "\n");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e);
			return "";
		}

		return tableElements;
	}
}
