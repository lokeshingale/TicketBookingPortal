<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" href="bus.jpg">
<title>Faster Ticket</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="Js/Validation.js"></script>
<style>
.bg-img {
  /* The image used */
  background-image: url("bus1.jpg");

  min-height: 380px;
  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
 background-size: cover; 
  position: relative; 
}

</style>
</head>
<body class="body">


	<!--<h1 style="color:#660033"align="left">Red Bus</h1>-->
	
	<div class="nav">
		<a href="empregister.html">Home</a>

		<div class="dropdown">
			<button class="dropbtn">
				Ticket <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="#">Ticket Booking</a> <a href="#">Ticket Cancel</a> <a
					href="#">Money Refund</a>
			</div>
			
		</div>
		
		<a href="Booking.html"
			style="float: right; color: white; background-color: red; align: center; margin-right: 10px;"><img
			src="register.jpg" style="width: 30px; height: 30px;" align="center" />Register</a>
		<a href=""
			style="float: right; color: white; background-color: red; align: center; margin-right: 10px;">
			<img src="login.jpg" style="width: 30px; height: 30px;"
			align="center" />Login
		</a> 
	</div>
	<!-- <img src="bus1.jpg" width="1350" height="430" alt="Natural"> -->
	<br>
<div class="bg-img">
	<!-- <div class="search"> -->
		<form action="search" method="post" onsubmit="return validateForm()" id="form">
			<table align="center" style="margin-top: 50px;">
				<tr>
					<td><label>From:</label></td>
				</tr>
				<tr>
					<td><input type="text" name="from" id="f1"
						style="width: 300px; height: 30px; border-radius: 8px;"
						placeholder="Enter the Station"></td>
						<tr><td><p id="err"></p></td></tr>
				</tr>
				<tr>
					<td><label>TO:</label></td>
				</tr>
				<tr>
					<td><input type="text" name="to" id="t1"
						style="width: 300px; height: 30px;"
						placeholder="Enter the Station" ></td>
						<tr><td><p id="trr"></p></td></tr>
				</tr>
				<tr>
					<td><label>Date:</label></td>
				</tr>
				<tr>
					<td><input type="date" name="date"
						style="width: 200px; height: 30px;"><br> <br></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="sb1"
						value="Search"
						style="width: 200px; height: 40px; background-color: red; color: white;" onsubmit="check"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
