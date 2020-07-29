<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>State Login</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous">
	</script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
</head>
<body style="margin-left: 40%; margin-top: 8%" onload="">

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<%
		if (request.getAttribute("cities") != null) {
		PrintWriter pw = response.getWriter();
		pw.print(request.getAttribute("cities"));
	}
	if (request.getAttribute("sucess") != null) {
		PrintWriter pw = response.getWriter();
		pw.print(request.getAttribute("sucess"));
	}
	
	%>
	<form action="/loginchk" method="post">
		<h4>
			State/Ut's <span class="badge badge-secondary"></span>
		</h4>
		<select name="state" class="form-control-lg"
			id="exampleFormControlSelect1" style="width: 35%;">
			<option value="Andman and Nicobar Island">Andman and Nicobar
				Island</option>
			<option value="Andhra Pradesh">Andhra Pradesh</option>
			<option value="Arunachal Pradesh">Arunachal Pradesh</option>
			<option value="Assam">Assam</option>
			<option value="Bihar">Bihar</option>
			<option value="Chandigarh">Chandigarh</option>
			<option value="Chattisgarh">Chattisgarh</option>
			<option value="Dadra & Nagar Haveli and Daman & Diu">Dadra &
				Nagar Haveli and Daman & Diu</option>
			<option value="Delhi">Delhi</option>
			<option value="Goa">Goa</option>
			<option value="Gujrat">Gujrat</option>
			<option value="Haryana">Haryana</option>
			<option value="Himachal Pardesh">Himachal Pardesh</option>
			<option value="Jammu and Kashmir">Jammu and Kashmir</option>
			<option value="Jharkhand">Jharkhand</option>
			<option value="Karnataka">Karnataka</option>
			<option value="Kerala">Kerala</option>
			<option value="Ladhak">Ladhak</option>
			<option value="Lakshdweep">Lakshdweep</option>
			<option value="Madhya Pardesh">Madhya Pardesh</option>
			<option value="Maharastra">Maharastra</option>
			<option value="Manipur">Manipur</option>
			<option value="Meghalya">Meghalya</option>
			<option value="Mizoram">Mizoram</option>
			<option value="Nagaland">Nagaland</option>
			<option value="Odisha">Odisha</option>
			<option value="Puducherry">Puducherry</option>
			<option value="Punjab">Punjab</option>
			<option value="Rajasthan">Rajasthan</option>
			<option value="Sikkim">Sikkim</option>
			<option value="Tamilnadu">Tamilnadu</option>
			<option value="Telangana">Telangana</option>
			<option value="Tripura">Tripura</option>
			<option value="Uttar Pardesh">Uttar Pardesh</option>
			<option value="Uttarakhand">Uttarakhand</option>
			<option value="West Bengal">West Bengal</option>
		</select>
		<h4>
			Password <span class="badge badge-secondary"></span>
		</h4>
		<input type="password" class="form-control-lg"
			id="exampleInputPassword1" placeholder="Password" style="width: 35%;"
			name="password"> <br> <br> <input type="submit"
			style="width: 35%;" class="btn btn-primary btn-lg" value="Submit">
	</form>
	</center>
</body>
</html>