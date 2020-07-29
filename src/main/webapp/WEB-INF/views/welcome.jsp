<%@page import="java.util.ArrayList"%>
<%@page import="com.example.virus.entity.Cities"%>
<%@page import="java.util.List"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DailyDataUpdate</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous">
	var d = new Date();
	document.getElementById("dt").innerHTML = d.toDateString();
</script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
</head>
<body>
	<form action="/saveCity" method="post" style="margin: 5%;">
		<%
			String st = (String) request.getAttribute("st");
		%><h2><%=st%></h2>
		<%
			List<String> c = new ArrayList<String>();
		List<Cities> ls = (List<Cities>) request.getAttribute("cities");
		for (Cities obj : ls) {
			String city = obj.getCcode();
			c.add(city);
		%>
		<label style="font-size: 25px;"><%=city%></label> <label id="dt"
			style="font-size: 15px;"></label> <input type="text"
			class="form-control-lg" id="exampleInputPassword1"
			placeholder="newcase" style="width: 25%;" name="<%=city%>newcase"
			required="required"><input type="text"
			class="form-control-lg" id="exampleInputPassword1"
			placeholder="recover" style="width: 25%;" name="<%=city%>recover"
			required="required"> <input type="text"
			class="form-control-lg" id="exampleInputPassword1"
			placeholder="decease" style="width: 25%;" name="<%=city%>decease"
			required="required"> <br> <br>

		<%
			}
		session.setAttribute("c", c);
		%>
		<input type="submit" style="width: 25%;"
			class="btn btn-primary btn-lg" value="Submit">
	</form>
</body>

</html>