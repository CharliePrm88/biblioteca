<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entity.RegistroLibri" %>
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
<% RegistroLibri c = (RegistroLibri)request.getAttribute("RegistroLibri");%>
        <tr>
        <td> <%=c.getId()%></td>
        <td><%=c.getMatricola()%> </td>
         <td><%=c.getIdlibro()%> </td>
        <td><%=c.getData_prestito() %></td>
        <td><%=c.getData_scadenza() %></td>
         <td><%=c.getData_rientro()%> </td>
        </tr>
</table><br>
	<a href=/Biblioteca-0.0.1-SNAPSHOT>Torna alla homepage</a>
</body>
</html>