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
	BookingBO bo=new BookingBO();
	bo.setFullname(dto.getFullname());
	bo.setMothername(dto.getMothername());
	bo.setGender(dto.getGender());
	bo.setDob(dto.getDob());
	bo.setAddr(dto.getAddr());
	bo.setCity(dto.getCity());
	bo.setState(dto.getState());
	bo.setAadhar(dto.getAadhar());
	bo.setEmail(dto.getEmail());
	bo.setMobno(dto.getMobno());
	bo.setIdentity(dto.getIdentity());
	int count=dao.getBooking(bo);
	System.out.println(count);
	if(count==0)
		return " Registration Successfully Completed......... ";
	else
		return " Registration is not Completed......... ";
	}
}
