<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.Turni" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../../style.css">
<title>Ricerca del Turno</title>
</head>
<body>
<h3> Lista dei Turni </h3>
	<table border="1px">
<% Turni c = (Turni)request.getAttribute("Turni");%>
        <tr>
        <td> <%=c.getId()%></td>
        <td><%=c.getMatricola()%> </td>
        <td><%=c.getData_inizio_turno() %></td>
        <td><%=c.getData_fine_turno() %></td>
        </tr>
</table><br>
	<a href=/Biblioteca-0.0.1-SNAPSHOT>Torna alla homepage</a>
</body>
</html>