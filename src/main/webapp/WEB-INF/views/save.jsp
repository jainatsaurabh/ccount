<%@page import="java.util.ArrayList"%>
<%@page import="com.example.virus.serve.ServeAll"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		ServletContext ctx = request.getServletContext();
	List<String> c = (List<String>) session.getAttribute("c");
	List<Integer> ls = new ArrayList<Integer>();
	for (int i = 0; i < c.size(); i++) {
		String city = c.get(i);
		System.out.println(city);
		ls.add(Integer.parseInt(request.getParameter(city + "newcase")));
		ls.add(Integer.parseInt(request.getParameter(city + "recover")));
		ls.add(Integer.parseInt(request.getParameter(city + "decease")));
	}
	session.setAttribute("dls", ls);
	response.sendRedirect("/process");
	%>
	<h1>asdfghjkl</h1>
</body>
</html>