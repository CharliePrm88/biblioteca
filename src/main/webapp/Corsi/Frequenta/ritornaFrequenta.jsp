<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="dto.FrequentaDto" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../../style.css">
<title>Ricerca dell'iscrizione</title>
</head>
<body>
<h3> Lista Iscrizioni</h3>
	<table border="1px">
<% FrequentaDto c = (FrequentaDto)request.getAttribute("Frequenta");%>
<% java.text.DateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
%>
        <tr>
        <td> <%=c.getId() %></td>
        <td> <%=c.getIdCorso()%></td>
        <td><%=c.getIdDipendente()%></td>
        <td><%=c.getIdIstruttore() %></td>
        </tr> 
</table><br>
	<a href=/biblioteca>Torna alla homepage</a>
</body>
</html>