package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Supplier;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/search")
public class BusSearch extends HttpServlet 
{
private static final String GET_BUS_SQL="SELECT FSTATION, TSTATION, ARRIVALDATE, ARRIVALTIME,DISPATUREDATE,DISPATURETIME FROM BUS WHERE FSTATION=? AND TSTATION=?";

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		PrintWriter pw=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String fstation=null;
		String tstation=null;
		try {
			pw=res.getWriter();
			res.setContentType("text/html");
		    fstation=req.getParameter("from");
			tstation=req.getParameter("to");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","7875");
			ps=con.prepareStatement(GET_BUS_SQL);
			ps.setString(1, fstation);
			ps.setString(2, tstation);
			//System.out.println("BusSearch.doPost()");
			rs=ps.executeQuery();
			
			Supplier<String> otps=()->{
				String otp="";
				for(int i=0; i<4; i++)
				{
					  otp = otp+(int)(Math.random()*10);
				}
				return otp;
			};
			RequestDispatcher rd=req.getRequestDispatcher("/headerurl");
			rd.include(req, res);
			if(rs.next())
			{
				pw.println("<b> From:</b>"+rs.getString(1)+"<br>");
				pw.println("<b>   To:</b>"+rs.getString(2)+"<br>");
				pw.println("<b>ArrivalDate:</b>"+rs.getDate(3)+"<br>");
				pw.println("<b>ArrivalTime:</b>"+rs.getString(4)+"<br>");
				pw.println("<b>DispatureDate:</b>"+rs.getDate(5)+"<br>");
				pw.println("<b>DispatureDate:</b>"+rs.getString(6)+"<br>");
				pw.println("<b>Captcha</b>"+otps.get()+"<br>");
			}
			else
			{
				pw.println("<b>Invalid Selection from and to </b>");
			}
			RequestDispatcher rd1=req.getRequestDispatcher("/footer.html");
			rd1.include(req, res);
		}//try closed
		
		
	    catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException ec) {
			ec.printStackTrace();
		}catch(IOException es) {
			es.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null)
				{
					rs.close();
				}
			}
			catch (SQLException es)
			{
				es.printStackTrace();
			}
			try
			{
				if(ps!=null)
				{
					ps.close();
				}
			}
			catch (SQLException eqe)
			{
				eqe.printStackTrace();
			}
			try
			{
				if(con!=null)
				{
					con.close();
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			try
			{
				if(pw!=null)
				{
					pw.close();
				}
			}
			catch (Exception io)
			{
				io.printStackTrace();
			}
		}
		
	}
	@Override
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
			doPost(req, res);
	}
}
