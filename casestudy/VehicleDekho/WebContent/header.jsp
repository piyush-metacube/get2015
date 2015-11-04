<%@page import="misc.LoginStatus"%>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<div class="row" style="background-color: #EE6825;">
	<div class="col-md-2 col-sm-2 col-xs-2  text-left">
		<img alt="Cardekho.com Logo" src="pictures/logo.png" height="100">
	</div>

	<div class="col-md-10 col-sm-10 col-xs-10 text-right">
		<a href='Home'><input type="button" value="Home" /></a> <a href='Search'><input
			type="button" value="Search" /></a>
		<%
		    if (!LoginStatus.isLogged()) {
				out.write("<a href='Login'><input type='Button' value='Login'></Button></a>");
		    } else {
			out.write("<a href='Admin'><input type='Button' value='Admin Panel'></Button></a>");
			out.write("<a href='Logout'><input type='Button' value='Logout'></Button></a>");
		    }
		%>
	</div>
</div>