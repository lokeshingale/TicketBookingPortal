package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nt.bo.BookingBO;
import com.nt.bo.RetriveBusBo;
import com.nt.dao.BookingDAO;
import com.nt.dao.BookingDaoImpl;
import com.nt.dto.BookingDTO;
import com.nt.dto.RetriveBusDto;

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
		return(count==0)?" Registration is not Completed......... ":" Registration Successfully Completed......... ";
	}

@Override
public List<RetriveBusDto> displayBus(String fstation, String tstation ) throws Exception {
	List<RetriveBusBo> listbo=null;
	List<RetriveBusDto> listdto=new ArrayList();
	
	listbo=dao.getBus(fstation, tstation);
	listbo.forEach(bo->{
		RetriveBusDto dt=new RetriveBusDto();
		dt.setFstation(bo.getFstation());
		dt.setTstation(bo.getTstation());
		dt.setAdate(bo.getAdate());
		dt.setAtime(bo.getAtime());
		dt.setDdate(bo.getDdate());
		dt.setDtime(bo.getDtime());
	    listdto.add(dt);
	});
	return listdto;
}

}
