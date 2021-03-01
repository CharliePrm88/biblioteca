<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page import="entity.Turni" %>
<%@page import="entity.Dipendenti" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="../../style.css">
<meta charset="ISO-8859-1">
<title>Lista di Tutti i Turni</title>
</head>
<body>
<h3> Lista dei turni </h3>
<table>
<c:forEach var="c" items="${ListaTurni}">
<tr>
	<td><form action="Cancella">
	<input type="text" name="idturno" value="${c.getId()}" readonly/>
	<input type="text" name="matricola" value="${c.getDipendenti().getMatricola()}" readonly/>
	<input type="text" name="data_inizio_turno" value="${c.getDataInizioTurno()}" readonly/>
	<input type="text" name="data_fine_turno"value="${c.getDataFineTurno()}" readonly/>
	<button type="submit" class="rimuovi">Cancella</button>
	</form>
	</td><td>
	<form action="aggiornaTurni.html">
	<input type="hidden" name="idturno" value="${c.getId()}"/>
	<input type="hidden" name="matricola" value="${c.getDipendenti().getMatricola()}" readonly/>
	<input type="hidden" name="data_inizio"value="${c.getDataInizioTurno()}" readonly/>
	<input type="hidden" name="data_fine"value="${c.getDataFineTurno()}" readonly/>
	<button type="submit" class="inserisci">Modifica</button>
	</form>
	</td>
</tr>
</c:forEach>
</table><br>
	<a href=/Biblioteca-0.0.1-SNAPSHOT>Torna alla homepage</a>
</body>
</html>