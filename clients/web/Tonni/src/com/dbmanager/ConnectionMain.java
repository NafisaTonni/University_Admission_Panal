package com.dbmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.global.Global;
import com.staticvalue.StaticValue;

public class ConnectionMain {
	private String class_name = "com.dbmanager.ConnectionMain";

	public Connection get_mysql_connection() {
		String method_name = "get_mysql_connection";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			Global.LogServiceErrors(class_name, method_name, e.getMessage());
		}

		Connection conn = null;
		/*try {
			conn = DriverManager.getConnection("jdbc:mysql://" + StaticValue.DB_Server + ":" + StaticValue.DB_Port
					+ "/" + StaticValue.DB_Name, StaticValue.DB_User, StaticValue.DB_Password);
		} catch (SQLException e) {
			Global.LogServiceErrors(class_name, method_name, e.getMessage());
		}*/
		String con= "jdbc:mysql://" + StaticValue.DB_Server + ":" + StaticValue.DB_Port+ "/" + StaticValue.DB_Name;
		try {
			System.out.println("Database NAME: "+StaticValue.DB_Name);
			conn = DriverManager.getConnection(con,StaticValue.DB_User,StaticValue.DB_Password);
			
		} catch (SQLException e) {
			Global.LogServiceErrors(class_name, method_name, e.getMessage());
		}
		
		
		
		return conn;
	}
	

}
