package com.nt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//public url - /date
public class DateServelt extends HttpServlet {


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  resp.setContentType("text/html");
	  Date d = new Date();
	  PrintWriter pw = resp.getWriter();
	  pw.write("Current date and time "+ d);
	  pw.close();

	}

}
