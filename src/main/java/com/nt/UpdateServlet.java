package com.nt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dao.StudentDao;
import com.nt.entity.Student;

public class UpdateServlet extends HttpServlet {
	@Override
	protected void service( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {

		int id = Integer.parseInt( req.getParameter( "id" ) );
		String name = req.getParameter( "name");

		StudentDao d = new StudentDao();
		boolean isUpdated = d.updateInfo(id,name);
		res.setContentType( "text/html" );
		PrintWriter pw = res.getWriter();
		if(isUpdated) {
				req.setAttribute("msg", "Name Updated successfull");
				RequestDispatcher rd = req.getRequestDispatcher("success.jsp");
				rd.forward(req, res);
				}
				else
					req.setAttribute("errorMsg", "Name Updation failed");
				RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
				rd.forward(req, res);

		pw.close();

	}
}
