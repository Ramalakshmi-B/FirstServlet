package com.nt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.entity.Student;

public class SelectServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.service(req, resp);
		
		int id = Integer.parseInt(req.getParameter("t1"));
		try {
			Class.forName( "com.mysql.jdbc.Driver" );

			Connection con = DriverManager
					.getConnection( "jdbc:mysql://localhost:3306/Student", "root", "root_1234" );
			PreparedStatement ps = con.prepareStatement( "select * from StudentInfo where StdId=?" );
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			res.setContentType( "text/html" );
			PrintWriter pw = res.getWriter();
			if (rs.next())
				
			{
				int i = rs.getInt( "id" );
				String name = rs.getString( "name" );
				Student s = new Student( id, name);
				req.setAttribute( "std", s);
				pw.write("Student Information is  Id" + i + "name " + name);
			}
			else
			{
				pw.write("No record found !!");
			}
	}
	
	catch( Exception e ) {
		e.printStackTrace();
	}

}
}
