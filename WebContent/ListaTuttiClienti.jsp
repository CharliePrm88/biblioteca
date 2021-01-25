<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.ArrayList" %>
<%@page import="model.Clienti" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Lista di Tutti i Clienti</title>
</head>
<body>
<h3> Lista dei clienti </h3>
<table>
<c:forEach var="c" items="${ListaClienti}">
<tr>
	<td><form action="ClientiCtr">
	<input type="text" name="idCliente" value=${c.getIdCliente()} readonly/>
	<input type="text" name="nome" value=${c.getNome()} readonly/>
	<input type="text" name="cognome" value=${c.getCognome()} readonly/>
	<input type="text" name="codiceFiscale"value=${c.getCodiceFiscale()} readonly/>
	<input type="hidden" name="tipoOperazione" value="cancellaClienti">
	<button type="submit" class="rimuovi">Cancella</button>
	</form>
	</td><td>
	<form action="aggiornaCliente.html">
	<input type="hidden" name="idCliente" value=${c.getIdCliente()}/>
	<input type="hidden" name="nome" value=${c.getNome()} readonly/>
	<input type="hidden" name="cognome" value=${c.getCognome()} readonly/>
	<input type="hidden" name="codiceFiscale"value=${c.getCodiceFiscale()} readonly/>
	<button type="submit" class="inserisci">Modifica</button>
	</form>
	</td>
</tr>
</c:forEach>
</table>
<br>
	<a href=/biblioteca>Torna alla homepage</a>
</body>
</html>