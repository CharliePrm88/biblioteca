<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page import="java.util.ArrayList" %>
<%@page import="model.Dipendenti" %>
<%@page import="java.util.List" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<spring:url value="/Biblioteca/src/main/webapp/style.css" var="coreCss" />
	<link rel="stylesheet" href="${coreCss}">
	<link rel="stylesheet" href="../../style.css">
<meta charset="ISO-8859-1">
<title>Lista di Tutti i Dipendenti</title>
</head>
<body>
<h3> Lista dei dipendenti </h3>
<table>
<c:forEach var="c" items="${ListaDipendenti}">
<tr>
	<td><form action="Cancella" method="delete">
	<input type="text" name="matricola" value="${c.getMatricola()}" readonly/>
	<input type="text" name="nome" value="${c.getNome()}" readonly/>
	<input type="text" name="cognome" value="${c.getCognome()}" readonly/>
	<input type="text" name="codiceFiscale"value="${c.getCodiceFiscale()}" readonly/>
	<button type="submit" class="rimuovi">Cancella</button>
	</form>
	</td><td>
	<form action="aggiornaDipendente.html">
	<input type="hidden" name="matricola" value="${c.getMatricola()}"/>
	<input type="hidden" name="nome" value="${c.getNome()}" readonly/>
	<input type="hidden" name="cognome" value="${c.getCognome()}" readonly/>
	<input type="hidden" name="codiceFiscale"value="${c.getCodiceFiscale()}" readonly/>
	<button type="submit" class="inserisci">Modifica</button>
	</form>
	</td>
</tr>
</c:forEach>
</table><br>
	<a href=/Biblioteca-0.0.1-SNAPSHOT>Torna alla homepage</a>
</body>
</html>