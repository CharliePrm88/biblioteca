<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="proxy.Movimenti" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../../style.css">
<title>Ricerca del Movimento</title>
</head>
<body>
<h3> Lista dei Movimenti </h3>
	<table border="1px">
<% Movimenti c = (Movimenti)request.getAttribute("M");%>
<% java.text.DateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
%>
        <tr>
        <td> <%=c.getId() %></td>
        <td> <%=c.getId_tipo_movimento() %></td>
        <td><%=c.getIban()%></td>
        <td><%=c.getImporto() %></td>
        <td><%=formatter.format(c.getData_movimento().getTime()) %></td>
        </tr> 
</table><br>
	<a href=/Biblioteca-0.0.1-SNAPSHOT>Torna alla homepage</a>
</body>
</html>