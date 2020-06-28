package com.nt.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.RetriveBusDto;
import com.nt.service.BookingService;
import com.nt.service.BookingServiceImpl;
@WebServlet("/search")
public class BusSearch extends HttpServlet 
{
	/*private static final String GET_BUS_SQL="SELECT FSTATION, TSTATION, ARRIVALDATE, ARRIVALTIME,DISPATUREDATE,DISPATURETIME FROM BUS WHERE FSTATION=? AND TSTATION=?";
	*/
	private BookingService service;
	@Override
	public void init() throws ServletException {
		service=new BookingServiceImpl();
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		    String fstation=null;
		    String tstation=null;
		    RequestDispatcher rd=null;
		    List<RetriveBusDto> listdto=null;
		    fstation=req.getParameter("from");
			tstation=req.getParameter("to");
			
		    	try {
					listdto=service.displayBus(fstation, tstation);
					req.setAttribute("listdto", listdto);
					rd=req.getRequestDispatcher("/all_buses.jsp");
					rd.forward(req, res);
		    	}
		    	catch(SQLException e) {
		    		e.printStackTrace();
		    	}
		    	catch(Exception se) {
		    		se.printStackTrace();
		    	}
			
				
	}
	@Override
		public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
			doGet(req, res);
	}
}
