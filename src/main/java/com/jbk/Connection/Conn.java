package com.jbk.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
private static Connection con= null;
	
	public static Connection getCon()  {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/springboot","root","1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
		

}}
