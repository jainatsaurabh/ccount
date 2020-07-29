<%@page import="com.example.virus.entity.CityUpdate"%>
<%@page import="com.example.virus.entity.States"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.example.virus.entity.Cities"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%
NumberFormat nf = NumberFormat.getNumberInstance();
List<Cities> ls = (List<Cities>) request.getAttribute("city");
List<CityUpdate> lstat = (List<CityUpdate>) request.getAttribute("dailyCity");
%>
<title>Corona/India</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
<img src="android-chrome-192x192.png">&nbsp
<label style="font-size: 50px; font-family: sans-serif; color: navy;">Corona
	Case Count - India</label>
<br>
<label
	style="font-size: 30px; font-family: sans-serif; color: navy; float: right; margin-right: 28%;"><%=(String) request.getAttribute("sname")%></label>
</head>


<body style="font-weight: bold;">
	<br>
	<br>
	<br><font
		style="font-size: 15px; float: left; margin-left: 20px; font-style: bold;">Data
		of: <%=lstat.get(0).getDate()%></font><br>
	<table class="table table-striped table-borderless"
		style="width: 250px; margin-left: 30px; float: left;">
		<thead class="thead-dark">
			<tr class="table-active">
				<th scope="col">Cities</th>
				<th scope="col">Confirmed</th>
				<th scope="col">Active</th>
				<th scope="col">Recovered</th>
				<th scope="col">Decease</th>
			</tr>
		</thead>
		<tbody>

			<%
				Iterator itr = ls.iterator();
			while (itr.hasNext()) {
				String total = " ";
				String recover = " ";
				String decease = " ";
				Cities st = (Cities) itr.next();
				Iterator itr1 = lstat.iterator();
				if (lstat.size() > 0) {
					while (itr1.hasNext()) {
				CityUpdate stat = (CityUpdate) itr1.next();
				if (stat.getName().equals(st.getCcode())) {
					total = "+" + nf.format(stat.getTotal());
					recover = "+" + nf.format(stat.getRecover());
					decease = "+" + nf.format(stat.getDecease());
				}
					}
				}
		
			%>
			<tr>
				<td ><%=st.getCcode()%></td>
				<td><font style="color: red;"><%=total%></font><br><%=nf.format(st.getTotal())%><font style="color: blue;"></font></td>
				<td><br><%=nf.format(st.getActive())%><font style="color: red;"></font></td>
				<td><font style="color: #77AB59;"><%=recover%></font><br><%=nf.format(st.getRecover())%><font style="color: green;"></font></td>
				<td><font style="color: grey;"><%=decease%></font><br><%=nf.format(st.getDecease())%><font style="color: grey;"></font></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<%
		States stt = (States) request.getAttribute("stat");
	List<Integer> lst = (List<Integer>) request.getAttribute("getdail");
	long total=stt.getTotal();
	long active=stt.getActive();
	long recover=stt.getRecover();
	long decease=stt.getDecease();
	%>
	<table class="table table-borderless"
		style="text-align: center; margin-right: 30px; float: right; width: 200px; font-size: 20px;">
		<thead>
			<tr>
				<th scope="col" style="color: red;">Confirmed</th>
				<th scope="col" style="color: blue;">Active</th>
				<th scope="col" style="color: green;">Recovered</th>
				<th scope="col" style="color: grey;">Decease</th>
			</tr>
		</thead>
		<tr style="font-size: 20px; width: 20px;">
			<td style="color: red;">+<%=nf.format(lst.get(0))%></td>
			<td style="color: blue;"></td>
			<td style="color: green;">+<%=nf.format(lst.get(3))%></td>
			<td style="color: grey;">+<%=nf.format(lst.get(2))%></td>
		</tr>
		<tr style="font-size: 35px;">
			<td style="color: red;"><%=nf.format(stt.getTotal())%></td>
			<td style="color: blue;"><%=nf.format(stt.getActive())%></td>
			<td style="color: green;"><%=nf.format(stt.getRecover())%></td>
			<td style="color: grey;"><%=nf.format(stt.getDecease())%></td>
		</tr>
	</table>
	
	<table class="table table-borderless"
		style="float: right; margin-right: 2%; width: 500px; height: 400px; text-align: left; font-size: 20px; border: 5px solid white;">
		<tbody>
			<tr>
				<td style="background-color: #ffe6e6; color: #F62217;">Infected&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspTotal
					Population: <%=stt.getPopulation() %><br> <font style="font-size: 30px;">
						<%=total * 100 / 1380004385%>%
				</font> of total population infected
				</td>
			</tr>
			<tr height="30px;"></tr>
			<tr>
				<td style="background-color: #E6E6FA; color: #2243B6;">Active:
					<font style="font-size: 30px;"><%=active * 100 / total%>%</font>
					are currently infected with virus<br>For every 100 confirmed
					cases, <%=Math.round(active * 100 / total)%> are currently
					infected.
				</td>
			</tr>
			<tr height="30px;"></tr>
			<tr>
				<td style="background-color: #cbe5be; color: #41A317;">Recovery:
					<font style="font-size: 30px;"><%=recover *100/ total%>%</font>
					patient recovered from virus<br>For every 100 confirmed cases,
					<%=Math.round(recover * 100 / total)%> have recovered from
					the virus.
				</td>
			</tr>
			<tr height="30px;"></tr>
			<tr>
				<td style="background-color: #D3D3D3; color: gray;">Fatality: <font
					style="font-size: 30px;"><%=decease * 100 / total%>%</font>
					deceased by virus<br>For every 100 confirmed cases, <%=Math.round(decease*100/total) %> have
					unfortunately passed away from the virus.
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>