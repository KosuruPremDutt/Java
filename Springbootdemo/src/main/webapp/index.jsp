<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
	
	
<%@ include file="First.html" %>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index Page</title>
</head>
<body>
	<h2>Hello World!</h2>
	<%
		response.sendRedirect(request.getContextPath() + "/myregisterpage");
	
	%>
	
	
	<%-- 
	<%! int x= 10; %>
	
	<%
		int y=12;
		out.println("Hello All" + x);
	%>
	
	<%
		out.println("y = " + y);
	%>
	 <c:forEach var = "i" begin = "1" end = "5">
         Item <c:out value = "${i}"/><p>
      </c:forEach>
	
	<%=  new Date()	
	%>
	
	--%>
</body>
</html>