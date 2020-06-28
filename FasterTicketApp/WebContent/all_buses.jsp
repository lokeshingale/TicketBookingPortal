<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, com.nt.dto.RetriveBusDto"%>

    <% 
    List<RetriveBusDto> listdto=(List<RetriveBusDto>)request.getAttribute("listdto");%>
   
	  <%if(request.getAttribute("listdto")!=null)
	  {
		Iterator<RetriveBusDto> iterator=listdto.iterator();%>
		<h3 style="color:red; text-align:center;">Bus Details</h3>
	<table border="0" align="center">
	  <tr bgcolor="#9999ff">
	  <th>From &nbsp;&nbsp;&nbsp;</th><th>To &nbsp;&nbsp;&nbsp;</th><th>Arrival Date &nbsp;&nbsp;&nbsp;</th>
	  <th>Arrival Time &nbsp;&nbsp;&nbsp;</th><th>Deperature Date &nbsp;&nbsp;&nbsp;</th><th>Deperature Time &nbsp;&nbsp;&nbsp;</th></tr>
		<% while(iterator.hasNext()){
			RetriveBusDto dto=iterator.next();
		%>
	  <tr>
	  <td><%=dto.getFstation()%>&nbsp;&nbsp;&nbsp;</td>
	  <td><%=dto.getTstation()%>&nbsp;&nbsp;&nbsp;</td>
	  <td><%=dto.getAdate()%>&nbsp;&nbsp;&nbsp;</td>
	  <td><%=dto.getAtime()%>&nbsp;&nbsp;&nbsp;</td>
	  <td><%=dto.getDdate()%>&nbsp;&nbsp;&nbsp;</td>
	  <td><%=dto.getDtime()%>&nbsp;&nbsp;&nbsp;</td> 
	  </tr>
 
  <%}%>
		  </table>
	 <% }  
  else {%>
  <h1 style="color:red;text-align:center;">No Buses Found</h1>
  <%}%>