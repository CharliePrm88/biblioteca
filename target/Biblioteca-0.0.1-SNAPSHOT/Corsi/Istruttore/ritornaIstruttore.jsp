<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="dto.IstruttoreDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../../style.css">
<title>Ricerca dell'Istruttore</title>
</head>
<body>
<h3> Lista dei Istruttore </h3>
	<table border="1px">
<% IstruttoreDto c = (IstruttoreDto)request.getAttribute("Istruttore");%>
        <tr>
        <td> <%=c.getMatricola()%></td>
        <td><%=c.getNome()%> </td>
        <td> <%=c.getCognome()%></td>
        <td> <%=c.getCodiceFiscale() %></td>
        </tr> 
</table><br>
	<a href=/Biblioteca-0.0.1-SNAPSHOT>Torna alla homepage</a>
</body>
</html>