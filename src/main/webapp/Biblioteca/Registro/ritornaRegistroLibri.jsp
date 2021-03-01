<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entity.Registrolibri" %>
<%@page import="entity.Libri" %>
<%@page import="entity.Dipendenti" %>
<%@page import="entity.Clienti" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../../style.css">
<title>Ricerca del Prestito</title>
</head>
<body>
<h3> Prestito </h3>
	<table border="1px">
<% Registrolibri r = (Registrolibri)request.getAttribute("RegistroLibri");%>
<% Dipendenti d = r.getDipendenti();%>
<% Libri l = r.getLibri();%>
<% Clienti c = r.getClienti();%>

        <tr>
        <td> <%=r.getId()%></td>
        <td><%=c.getCognome() %> </td>
         <td><%=l.getTitolo() %> </td>
         <td><%=d.getMatricola() %></td>
        <td><%=r.getDataPrestito() %></td>
        <td><%=r.getDataScadenza() %></td>
         <td><%=r.getDataRientro()%> </td>
        </tr>
</table><br>
	<a href=/Biblioteca-0.0.1-SNAPSHOT>Torna alla homepage</a>
</body>
</html>