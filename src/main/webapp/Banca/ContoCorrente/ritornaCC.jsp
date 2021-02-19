<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="proxy.ContoCorrente" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../../style.css">
<title>Ricerca del Conto Corrente</title>
</head>
<body>
<h3> Lista dei Conto Correnti </h3>
	<table border="1px">
<% ContoCorrente c = (ContoCorrente)request.getAttribute("CC");%>
<% java.text.DateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
%>
        <tr>
        <td> <%=c.getIdCliente()%></td>
        <td><%=c.getIban()%></td>
        <td><%=c.getSaldo() %></td>
        <td><%=formatter.format(c.getData_creazione().getTime()) %></td>
        </tr> 
</table><br>
	<a href=/biblioteca>Torna alla homepage</a>
</body>
</html>