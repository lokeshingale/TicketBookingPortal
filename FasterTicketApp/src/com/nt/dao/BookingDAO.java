package com.nt.dao;

import java.util.List;

import com.nt.bo.BookingBO;
import com.nt.bo.Login;
import com.nt.bo.RetriveBusBo;

public interface BookingDAO {
public int getBooking(BookingBO bo) throws Exception;

	/*public int login(Login lo) throws Exception;
	*/
public List<RetriveBusBo> getBus(String fstation, String tstation)throws Exception;
}
