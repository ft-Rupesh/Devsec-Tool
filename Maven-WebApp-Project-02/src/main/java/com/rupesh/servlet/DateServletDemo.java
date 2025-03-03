package com.rupesh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/dateurl")
public class DateServletDemo extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get PrintWriter
		PrintWriter pw=resp.getWriter();
		//set response content type
		resp.setContentType("text/html");
		
		pw.println("<h1>date and time is ::"+new Date()+"</h1>");
		//add home hyperlink
		pw.println("<br><a href='index.html'>home</a>");
		//close the stream
		pw.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}
}
