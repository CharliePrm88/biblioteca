<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page import="dto.FrequentaDto" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="../../style.css">
<meta charset="ISO-8859-1">
<title>Lista di Tutte le iscrizione</title>
</head>
<body>
<h3> Lista delle iscrizioni </h3>
<table>
<c:forEach var="c" items="${ListaFrequenta}">
<tr>
	<td><form action="FrequentaCtr">
	<input type="text" name="id" value="${c.getId()}" readonly/>
	<input type="text" name="idCorso" value="${c.getIdCorso()}" readonly/>
	<input type="text" name="idDipendente" value="${c.getIdDipendente()}" readonly/>
	<input type="text" name="idIstruttore" value="${c.getIdIstruttore()}" readonly/>
	<input type="hidden" name="tipoOperazione" value="cancellaFrequenta">
	<button type="submit" class="rimuovi">Cancella</button>
	</form>
	</td><td>
	<form action="aggiornaFrequenta.html">
	<input type="hidden" name="id" value="${c.getId()}"/>
	<input type="hidden" name="idCorso" value="${c.getIdCorso()}"/>
	<input type="hidden" name="idDipendente" value="${c.getIdDipendente()}"/>
	<input type="hidden" name="idIstruttore" value="${c.getIdIstruttore()}"/>
	<button type="submit" class="inserisci">Modifica</button>
	</form>
	</td>
</tr>
</c:forEach>
</table><br>
	<a href=/biblioteca>Torna alla homepage</a>
</body>
</html>