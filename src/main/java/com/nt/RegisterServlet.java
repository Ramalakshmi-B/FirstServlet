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

public class RegisterServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.service(req, res);
		int id = Integer.parseInt(req.getParameter("t1"));
		String name = req.getParameter("t2");

		//Db connection
		Student S  = new Student (id, name);
		StudentDao d = new StudentDao();
		boolean isAdded = d.register(S);
		res.setContentType( "text/html" );
		PrintWriter pw = res.getWriter();

		if(isAdded) {
		req.setAttribute("msg", "Registration successfull");
		RequestDispatcher rd = req.getRequestDispatcher("success.jsp");
		rd.forward(req, res);
		}
		else
			req.setAttribute("errorMsg", "Registration failed");
		RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
		rd.forward(req, res);

		pw.close();
	}



}
