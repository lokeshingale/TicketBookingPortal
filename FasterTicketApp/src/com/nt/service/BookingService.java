package com.nt.service;

import java.util.List;

import com.nt.dto.BookingDTO;
import com.nt.dto.RetriveBusDto;

public interface BookingService {
public String registerBooking(BookingDTO dto) throws Exception;
public List<RetriveBusDto> displayBus(String fstation, String tstation)throws Exception;
}
