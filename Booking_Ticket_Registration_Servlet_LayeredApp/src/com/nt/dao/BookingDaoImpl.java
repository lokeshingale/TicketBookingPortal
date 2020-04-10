package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.BookingBO;

public class BookingDaoImpl implements BookingDAO {
	private static final String BOOKING_DATA="INSERT INTO BOOKING VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,BOOK.NEXTVAL)";
	private Connection getPooledJdbcConnection() throws Exception {
		InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		ic=new InitialContext();
		ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
		con=ds.getConnection();
		return con;
	}
	
@Override
public int getBooking(BookingBO bo) throws Exception {
	Connection con=null;
	PreparedStatement ps=null;
	int count=0;
	con=getPooledJdbcConnection();
	ps=con.prepareStatement(BOOKING_DATA);
	ps.setString(1, bo.getSalutation());
	ps.setString(2, bo.getFname());
	ps.setString(3, bo.getLname());
	ps.setString(4, bo.getGender());
	ps.setDate(5, bo.getDob());
	ps.setString(6, bo.getAddr());
	ps.setString(7, bo.getState());
	ps.setString(8, bo.getCity());
	ps.setInt(9, bo.getPassenger());
	ps.setString(10, bo.getEmail());
	ps.setLong(11, bo.getMobno());
	ps.setDouble(12, bo.getAmount());
	ps.setDouble(13, bo.getCback());
	count=ps.executeUpdate();
	return count;
}
}
