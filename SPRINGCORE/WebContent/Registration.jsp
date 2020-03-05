<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function validation(){
	var username=document.getElementById("name");
	var address=document.getElementById("add");
	var password=document.getElementById("pass1");
	var password2=document.getElementById("pass2");
	if(username==null||username==""){
		alert("please enter the username");
		return false;
	}
	if(address==null||address==""){
		alert("address should not be empty");
		return false;
	}
	if(password==null||password==""){
		alert("password should not be empty");
		return false;
	}
	if(password2==null||password2==""){
		alert("password should not be empty");
		return false;
	}
	return true;
	
}


</script>
</head>
<body>
<form method="get" action="regserv" >
<h1>New User</h1>
<label>Name</label>&nbsp<input type="text" name="name"><br><br>
<label>Address</label><input type="text" name="add"><br><br>
<label>Password</label><input type="password" name="pass1"><br><br>
<label>Confirm Password</label>&nbsp;&nbsp;<input type="password" name="pass2"><br><br>
<input type="submit" value="Confirm" >
</form>
</body>
</html>