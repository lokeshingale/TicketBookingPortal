package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.BookingDTO;
import com.nt.service.BookingService;
import com.nt.service.BookingServiceImpl;
import com.nt.vo.BookingVO;
@WebServlet("/register_controller")
public class RegisterController extends HttpServlet {
	private BookingService service;
	@Override
	public void init() throws ServletException {
		service=new BookingServiceImpl();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    System.out.println("RegisterController.doGet()");
	PrintWriter pw=null;
    BookingVO vo=null;
    BookingDTO dto=null;
    String result=null;
    pw=res.getWriter();
    res.setContentType("text/html");
    vo=new BookingVO();
    vo.setFullname(req.getParameter("name"));
    vo.setMothername(req.getParameter("mname"));
    vo.setGender(req.getParameter("gender"));
    vo.setDob(req.getParameter("dob"));
    vo.setAddr(req.getParameter("addr"));
    vo.setCity(req.getParameter("city"));
    vo.setState(req.getParameter("state"));
    vo.setAadhar(req.getParameter("num"));
    vo.setEmail(req.getParameter("email"));
    vo.setMobno(req.getParameter("mob"));
    vo.setIdentity(req.getParameter("identity"));
    dto=new BookingDTO();
    dto.setFullname(vo.getFullname());
    dto.setMothername(vo.getMothername());
    dto.setGender(vo.getGender());
    dto.setDob(java.sql.Date.valueOf(vo.getDob()));
    dto.setAddr(vo.getAddr());
    dto.setCity(vo.getCity());
    dto.setState(vo.getState());
    dto.setAadhar(Long.parseLong(vo.getAadhar()));
    dto.setEmail(vo.getEmail());
    dto.setMobno(Long.parseLong(vo.getMobno()));
    dto.setIdentity(vo.getIdentity());
  // RequestDispatcher rd=req.getRequestDispatcher("/headerurl");
   //rd.include(req, res);
    try {
    	result= service.registerBooking(dto);
    	 pw.println("<h1 style='color:red;text-align:center'>Result :: "+result+"</h1>");
	 }//try
	 catch(Exception e) {
		 pw.println("<h1>Internal Problem ---- Try Again</h1>");		
		 e.printStackTrace();
	 }
	//add hyperlink
	 pw.println("<br><br> <a href='Booking.html'>home</a>");
	 //close stream
	 //RequestDispatcher rd1=req.getRequestDispatcher("footer.html");
	  // rd1.include(req, res);
	 pw.close();
	
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
	
}
