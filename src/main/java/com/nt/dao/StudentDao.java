package com.nt.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nt.entity.Student;
import com.nt.utilities.ConnectionFactory;

public class StudentDao {
	public boolean register(Student s)
	{
		try {
			Connection con = ConnectionFactory.getCon();
			PreparedStatement ps = con.prepareStatement( "insert into StudentInfo values(?,?)" );
			ps.setInt( 1, s.getStdid() );
			ps.setString( 2, s.getStdname() );
			int result = ps.executeUpdate();
			if (result == 1)
			{
				return true;
			}
		}
		catch( Exception e ) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateInfo(int id, String name) 
	{
		try {
			Connection con = ConnectionFactory.getCon();

			PreparedStatement ps = con.prepareStatement( "update StudentInfo set StdName=? where StdId=?" );
			ps.setString( 1, name);
			ps.setInt( 2, id );
			int result = ps.executeUpdate();
			if (result==1)
				return true;
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Student getById(int id) {
		try {
		Connection con = ConnectionFactory.getCon();
			PreparedStatement ps = con.prepareStatement( "select * from StudentInfo where StdId=?" );
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next())

			{
				int i = rs.getInt( "id" );
				String name = rs.getString( "name" );
				Student s = new Student( id, name);
                return s;
                
				
			}
			else
			{
				return null;
			}
		}
	catch( Exception e ) {
		e.printStackTrace();
	}
	
return null;
		
	}
}
