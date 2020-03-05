package com.utility;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;

public class ConnectionDatabase {
	public static Connection con;
	public static Connection getConnection() throws SQLException,ClassNotFoundException{
		String url="jdbc:mysql://localhost:3306/userlogin";
		String uname="root";
		String pass="adm@123";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= (Connection) DriverManager.getConnection(url,uname,pass);
		return con;
		
				
	}
}
