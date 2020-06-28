package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimecheckFilter extends HttpFilter {
	public void TimecheckFilter() {
		System.out.println("TimecheckFilter: Constructor");
	}
   @Override
public void init(FilterConfig filterConfig) throws ServletException {
	System.out.println("TimecheckFilter.init()");
}
   @Override
public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
		throws IOException, ServletException {
	   PrintWriter pw=null;
	   pw=res.getWriter();
	   res.setContentType("text/html");
	Calendar calendar=null;
	int hour=0;
	calendar=Calendar.getInstance();
	hour=calendar.get(Calendar.HOUR_OF_DAY);
	if(hour<9 || hour>17)
	{
		pw.println("<h1 style='color:red; text-align:center'>this website searching in 09 AM to 05 PM</h1>");
	return;
	}
	else {
		chain.doFilter(req, res);
	}
}
   @Override
public void destroy() {
	System.out.println("Desotry method");
}
}
