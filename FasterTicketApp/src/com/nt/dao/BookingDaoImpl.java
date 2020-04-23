package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.BookingBO;

public class BookingDaoImpl implements BookingDAO {
	private static final String BOOKING_DATA="INSERT INTO REGISTER VALUES(BOOK.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?)";
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
	ps.setString(1, bo.getFullname());
	ps.setString(2, bo.getMothername());
	ps.setString(3, bo.getGender());
	ps.setDate(4, bo.getDob());
	ps.setString(5, bo.getAddr());
	ps.setString(6, bo.getCity());
	ps.setString(7, bo.getState());
	ps.setLong(8, bo.getAadhar());
	ps.setString(9, bo.getEmail());
	ps.setLong(10, bo.getMobno());
	ps.setString(11, bo.getIdentity());
	count=ps.executeUpdate();
	return count;
}
}
