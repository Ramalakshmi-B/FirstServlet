package com.nt.utilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static Connection con = null;
	static
	{
		try {
			Class.forName( "com.mysql.jdbc.Driver" );

			Connection con = DriverManager
					.getConnection( "jdbc:mysql://localhost:3306/Student", "root", "root_1234" );
	}
catch (Exception e)
		{
	e.printStackTrace();}
		}
	/**
	 * @return the con
	 */
	public static Connection getCon() {
		return con;
	}

}
