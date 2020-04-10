package com.nt.service;

import com.nt.bo.BookingBO;
import com.nt.dao.BookingDAO;
import com.nt.dao.BookingDaoImpl;
import com.nt.dto.BookingDTO;

public class BookingServiceImpl implements BookingService {
private BookingDAO dao;

public BookingServiceImpl() {
	dao=new BookingDaoImpl();
}

@Override
	public String registerBooking(BookingDTO dto) throws Exception {
	double cback=0.0f;
	double amt=0.0f;
	amt=dto.getAmt();
	cback=amt-40/100;
	BookingBO bo=new BookingBO();
	bo.setSalutation(dto.getSalutation());
	bo.setFname(dto.getFname());
	bo.setLname(dto.getLname());
	bo.setGender(dto.getGender());
	bo.setDob(dto.getDob());
	bo.setAddr(dto.getAddr());
	bo.setState(dto.getState());
	bo.setCity(dto.getCity());
	bo.setPassenger(dto.getPassenger());
	bo.setEmail(dto.getEmail());
	bo.setMobno(dto.getMobno());
	bo.setAmount(amt);
	bo.setCback(cback);
	int count=dao.getBooking(bo);
	if(count==0)
		return " Seat Successfully Book......... ";
	else
		return " Seat not Booked......... ";
	}
}
