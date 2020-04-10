package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.BookingDTO;
import com.nt.service.BookingService;
import com.nt.service.BookingServiceImpl;
import com.nt.vo.BookingVO;
@WebServlet("/bookController")
public class BookingMainController extends HttpServlet {
	private BookingService service;
	@Override
	public void init() throws ServletException {
		service=new BookingServiceImpl();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    PrintWriter pw=null;
    BookingVO vo=null;
    BookingDTO dto=null;
    pw=res.getWriter();
    res.setContentType("text/html");
    vo=new BookingVO();
    vo.setSalutation(req.getParameter("salutation"));
    vo.setFname(req.getParameter("fname"));
    vo.setLname(req.getParameter("lname"));
    vo.setGender(req.getParameter("gender"));
    vo.setDob(req.getParameter("dob"));
    vo.setAddr(req.getParameter("addr"));
    vo.setState(req.getParameter("state"));
    vo.setCity(req.getParameter("city"));
    vo.setPassenger(req.getParameter("passenger"));
    vo.setEmail(req.getParameter("email"));
    vo.setMobno(req.getParameter("mobno"));
    vo.setAmt(req.getParameter("amt"));
    dto=new BookingDTO();
    dto.setSalutation(vo.getSalutation());
    dto.setFname(vo.getFname());
    dto.setLname(vo.getLname());
    dto.setGender(vo.getGender());
    dto.setDob(java.sql.Date.valueOf(vo.getDob()));
    dto.setAddr(vo.getAddr());
    dto.setState(vo.getState());
    dto.setCity(vo.getCity());
    dto.setPassenger(Integer.parseInt(vo.getPassenger()));
    dto.setEmail(vo.getEmail());
    dto.setMobno(Long.parseLong(vo.getMobno()));
    dto.setAmt(Double.parseDouble(vo.getAmt()));
    
    try {
		 String result = service.registerBooking(dto);
		 pw.println("<h1 style='color:red;text-align:center'>Result :: "+result+"</h1>");
	 }//try
	 catch(Exception e) {
		 pw.println("<h1>Internal Problem ---- Try Again</h1>");
		 e.printStackTrace();
	 }
	//add hyperlink
	 pw.println("<br><br> <a href='Booking.html'>home</a>");
	 //close stream
	 pw.close();
	
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
