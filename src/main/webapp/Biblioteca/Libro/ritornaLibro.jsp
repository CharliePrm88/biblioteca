<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entity.Libri" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../../style.css">
<title>Ricerca del cliente</title>
</head>
<body>
<h3> Lista dei Libri </h3>
	<table border="1px">
<% Libri c = (Libri)request.getAttribute("Libri");%>
        <tr>
        <td> <%=c.getIdLibro()%></td>
        <td><%=c.getNumeroPagine()%> </td>
        <td> <%=c.getTitolo()%></td>
        <td> <%=c.getGenere()%></td>
        <td> <%=c.getAutore()%></td>
        <td> <%=c.getIsbn()%></td>
        <td> <%=c.getCasaeditrice()%></td>
        <td> <%=c.getPosizione()%></td>
        </tr>
</table><br>
	<a href=/Biblioteca-0.0.1-SNAPSHOT>Torna alla homepage</a>
</body>
</html>