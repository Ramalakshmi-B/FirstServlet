package com.nt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dao.StudentDao;
import com.nt.entity.Student;

public class SelectServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.service(req, resp);

		int id = Integer.parseInt(req.getParameter("t1"));
		StudentDao S  = new StudentDao();
		Student std = S.getById(id);
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		if(std==null)
		{
					req.setAttribute("msg", "No record found");
					RequestDispatcher rd = req.getRequestDispatcher("success.jsp");
					rd.forward(req, res);
		}
		else
		{
			RequestDispatcher rd = req.getRequestDispatcher("display.jsp");
			rd.forward(req,res);
		}
		
}
}
