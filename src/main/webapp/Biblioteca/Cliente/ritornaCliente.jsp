<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entity.Clienti" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../../style.css">
<title>Ricerca del cliente</title>
</head>
<body>
<h3> Lista dei clienti </h3>
	<table border="1px">
<% Clienti c = (Clienti)request.getAttribute("Clienti");%>
        <tr>
        <td> <%=c.getIdCliente()%></td>
        <td><%=c.getNome()%> </td>
        <td> <%=c.getCognome()%></td>
        <td> <%=c.getCodiceFiscale() %></td>
        </tr> 
</table><br>
	<a href=/Biblioteca-0.0.1-SNAPSHOT>Torna alla homepage</a>
</body>
</html>