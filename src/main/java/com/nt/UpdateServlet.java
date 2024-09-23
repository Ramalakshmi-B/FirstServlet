package com.nt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateServlet extends HttpServlet {
	@Override
	protected void service( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {

		int id = Integer.parseInt( req.getParameter( "id" ) );
		String name = req.getParameter( "name");

		try {
			Class.forName( "com.mysql.jdbc.Driver" );

			Connection con = DriverManager
					.getConnection( "jdbc:mysql://localhost:3306/Student", "root", "root_1234" );

			PreparedStatement ps = con.prepareStatement( "update StudentInfo set StdName=? where StdId=?" );
			ps.setString( 1, name);
			ps.setInt( 2, id );
			ps.executeUpdate();
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		res.setContentType( "text/html" );
		PrintWriter pw = res.getWriter();
		pw.write( "<h3 style=color:'green'>Name updated successfully</h3>" );
		pw.close();

	}
}
