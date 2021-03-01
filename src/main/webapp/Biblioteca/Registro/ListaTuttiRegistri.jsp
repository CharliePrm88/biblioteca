<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page import="entity.Registrolibri" %>
<%@page import="entity.Libri" %>
<%@page import="entity.Dipendenti" %>
<%@page import="entity.Clienti" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="../../style.css">
<meta charset="ISO-8859-1">
<title>Lista di Tutti i Prestiti</title>
</head>
<body>
<h3> Lista dei prestiti </h3>
<table>
<c:forEach var="c" items="${ListaRegistroLibri}">
<tr>
	<td><form action="Cancella">
	<input type="text" name="id" value="${c.getId()}" readonly/>
	<input type="text" name="idLibro" value="${c.getLibri().getIdLibro()}" readonly/>
	<input type="text" name="idCliente" value="${c.getClienti().getIdCliente()}" readonly/>
	<input type="text" name="matricola" value="${c.getDipendenti().getMatricola()}" readonly/>
	<input type="text" name="data_prestito" value="${c.getDataPrestito()}" readonly/>
	<input type="text" name="data_scadenza" value="${c.getDataScadenza()}" readonly/>
	<input type="text" name="data_rientro" value="${c.getDataRientro()}" readonly/>
	<button type="submit" class="rimuovi">Cancella</button>
	</form>
	</td><td>
	<form action="aggiornaRegistro.html">
	<input type="hidden" name="id" value="${c.getId()}"/>
	<input type="hidden" name="idLibro" value="${c.getLibri().getIdLibro()}" readonly/>
	<input type="hidden" name="idcliente" value="${c.getClienti().getIdCliente()}" readonly/>
	<input type="hidden" name="matricola" value="${c.getDipendenti().getMatricola()}" readonly/>
	<input type="hidden" name="data_prestito"value="${c.getDataPrestito()}" readonly/>
	<input type="hidden" name="data_scadenza"value="${c.getDataScadenza()}" readonly/>
	<input type="hidden" name="data_rientro"value="${c.getDataRientro()}" readonly/>
	<button type="submit" class="inserisci">Modifica</button>
	</form>
	</td>
</tr>
</c:forEach>
</table><br>
	<a href=/Biblioteca-0.0.1-SNAPSHOT>Torna alla homepage</a>
</body>
</html>