package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/headerurl")
public class HeaderServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	PrintWriter pw=null;
	pw=res.getWriter();
	res.setContentType("text/html");
	pw.println("<p style=\"background-color:red; color:white; height:50px; font-size:25px;\" align=\"left\">&nbsp;&nbsp;&nbsp;&nbsp;\r\n" + 
			"	<img src=\"bus.jpg\" width=\"90px\" height=\"30px\" align=\"center\">&nbsp;&nbsp;&nbsp;&nbsp;Home&nbsp;&nbsp;&nbsp;&nbsp;\r\n" + 
			"	<a href=\"Frontpage.html\">Bus Ticket</a>&nbsp;&nbsp;&nbsp;&nbsp;Ticket Cancel\r\n" + 
			"	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"Booking.html\" align=\"right\">Login</a>&nbsp;&nbsp;&nbsp;&nbsp;</p>\r\n" + 
			"    \r\n" + 
			"	<img src=\"lal.png\" width=\"1500\" height=\"500\" alt=\"Natural\" /><br><hr>");
	
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
}
