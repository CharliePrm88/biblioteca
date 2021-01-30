<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page import="proxy.TipoMovimento" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Lista di Tutti i Tipo Movimenti</title>
</head>
<body>
<h3> Lista dei Tipo Movimenti </h3>
<table>

<c:forEach var="c" items="${listaTM}">

<tr>
	<td><form action="TipoMovimentoCtrBanca">
	<input type="text" name="idTipoMovimento" value="${c.getId_tipo_movimento()}" readonly/>
	<input type="text" name="descrizione" value="${c.getDescrizione()}" readonly/>
	<input type="hidden" name="tipoOperazione" value="cancellaTM">
	<button type="submit" class="rimuovi">Cancella</button>
	</form>
	</td><td>
	<form action="aggiornaTM.html">
	<input type="hidden" name="descrizione" value="${c.getDescrizione()}" readonly/>	
	<input type="hidden" name="idTipoMovimento" value="${c.getId_tipo_movimento()}" readonly/>
	<button type="submit" class="inserisci">Modifica</button>
	</form>
	</td>
</tr>
</c:forEach>
</table><br>
	<a href=/biblioteca>Torna alla homepage</a>
</body>
</html>