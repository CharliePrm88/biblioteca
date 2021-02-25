<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="proxy.TipoMovimento" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../../style.css">
<title>Ricerca del Tipo Movimento</title>
</head>
<body>
<h3> Lista dei Tipi Movimenti </h3>
	<table border="1px">
<% TipoMovimento c = (TipoMovimento)request.getAttribute("TM");%>
        <tr>
        <td> <%=c.getId_tipo_movimento() %></td>
        <td><%=c.getDescrizione() %></td>
        </tr> 
</table><br>
	<a href=/Biblioteca-0.0.1-SNAPSHOT>Torna alla homepage</a>
</body>
</html>