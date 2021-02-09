<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="dto.CorsiDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>Ricerca del Corso</title>
</head>
<body>
<h3> Lista dei corsi </h3>
	<table border="1px">
<% CorsiDto c = (CorsiDto)request.getAttribute("Corsi");%>
        <tr>
        <td> <%=c.getId()%></td>
        <td><%=c.getNome()%> </td>
        <td> <%=c.getData_inizio()%></td>
        <td> <%=c.getData_fine() %></td>
        </tr> 
</table><br>
	<a href=/biblioteca>Torna alla homepage</a>
</body>
</html>