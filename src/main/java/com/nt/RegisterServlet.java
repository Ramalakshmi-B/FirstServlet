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

public class RegisterServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.service(req, res);
		int id = Integer.parseInt(req.getParameter("t1"));
		String name = req.getParameter("t2");
		
		//Db connection
		try {
			Class.forName( "com.mysql.jdbc.Driver" );
			Connection con = DriverManager
					.getConnection( "jdbc:mysql://localhost:3306/Student", "root", "root_1234" );
			PreparedStatement ps = con.prepareStatement( "insert into StudentInfo values(?,?)" );
			ps.setInt( 1, id );
			ps.setString( 2, name );
			ps.executeUpdate();
		}
		catch( Exception e ) {
			e.printStackTrace();
		}
		res.setContentType( "text/html" );
		PrintWriter pw = res.getWriter();
		pw.write( "<h3 style=color:'green'>Registration successfull</h3>" );
		pw.close();
	}
	
	

}
