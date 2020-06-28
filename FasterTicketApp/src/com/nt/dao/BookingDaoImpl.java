package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.BookingBO;
import com.nt.bo.RetriveBusBo;

public class BookingDaoImpl implements BookingDAO {
	private static final String BOOKING_DATA="INSERT INTO REGISTER VALUES(BOOK.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?)";

	/*private static final String LOGIN_CHECK="SELECT USERNAME, PWD FROM REGISTER WHERE USERNAME=? AND PWD=?";
	*/
	/*private static final String GET_BUS_SQL="SELECT FSTATION, TSTATION, ARRIVALDATE, ARRIVALTIME,DISPATUREDATE,DISPATURETIME FROM BUS WHERE FSTATION='+fstation+' AND TSTATION=+tstation+'";*/
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

@Override
public List<RetriveBusBo> getBus(String fstation, String tstation) throws Exception {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	List<RetriveBusBo> list=null;
	RetriveBusBo bo=null;
	try {
	con=getPooledJdbcConnection();
	ps=con.prepareStatement("SELECT * FROM BUS WHERE fstation=? and tstation=?");
	ps.setString(1, fstation);
	ps.setString(2, tstation);
	rs=ps.executeQuery();
	list=new ArrayList();
	while(rs.next()) {
		bo=new RetriveBusBo();
		bo.setFstation(rs.getString(1));
		bo.setTstation(rs.getString(2));
		bo.setAdate(rs.getString(3));
		bo.setAtime(rs.getString(4));
		bo.setDdate(rs.getString(5));
		bo.setDtime(rs.getString(6));
		list.add(bo);
		
	}
}
catch(SQLException e) {
	e.printStackTrace();
	throw e;
	}
	catch(Exception se) {
		se.printStackTrace();
		throw se;
	}
	finally {
			try {
				if(con!=null) {
				con.close();
			}
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
	try {
		if(ps!=null) {
				ps.close();
				}
			}
	catch(SQLException s) {
		s.printStackTrace();
	}
	try {
		if(rs!=null) {
			rs.close();
		}
	}
	catch(SQLException d) {
		d.printStackTrace();
	}
	
	return list;
	}
	
}

