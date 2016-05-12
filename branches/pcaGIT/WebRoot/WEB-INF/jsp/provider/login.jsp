<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html dir="ltr" xmlns="http://www.w3.org/1999/xhtml" lang="en"><head>

<%
String alert = (String) request.getAttribute("alert");
 %>

	<title>Healthcare Management System - Log In</title>
	<head>
	<link rel="stylesheet" id="login" href="css/login.css" type="text/css" media="all" />
<link rel="stylesheet" id="colors-fresh" href="css/colors-fresh.css" type="text/css" media="all" />
<link rel="stylesheet" href="css/wpcom.css" type="text/css" />
</head>
<body class="login">

<div id="login">

<br />
<br />
<center><h2>
<%if (alert != null && !alert.trim().equals("")) {%>
	<div id="warning" align="center">
		<c:out value="${alert}"></c:out>
	</div>
	<%}%>
</h2></center>
<br />
<br />
<br />
<form name="loginform" id="loginform" action="user" method="post">
	<input type="hidden" name="navigation" value="authorize" />
	<p>
		<label>Username<br />
		<input name="username" id="user_login" class="input" value="" size="20" tabindex="10" type="text"></label>
	</p>
	<p>
		<label>Password<br />
		<input name="pwd" id="user_pass" class="input" value="" size="20" tabindex="20" type="password"></label>
	</p>
	<p class="forgetmenot"></p>
	<p class="submit">
		<input name="login" id="loginButton" value="Log In" tabindex="100" type="submit" />
		
		
	</p>
</form>


</div>




</body></html>