<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page import="proxy.ContoCorrente" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Lista di Tutti i Conto Correnti</title>
</head>
<body>
<h3> Lista dei ContoCorrenti </h3>
<table>
<c:forEach var="c" items="${listaCC}">
<tr>
	<td><form action="ContoCorrenteCtrBanca">
	<input type="text" name="dataCreazione" value=${c.getData_creazione()} readonly/>
	<input type="text" name="iban" value=${c.getIban()} readonly/>
	<input type="text" name="saldo" value=${c.getSaldo()} readonly/>
	<input type="text" name="idCliente" value=${c.getIdCliente()} readonly/>
	<input type="hidden" name="tipoOperazione" value="cancellaCC">
	<button type="submit" class="rimuovi">Cancella</button>
	</form>
	</td><td>
	<form action="aggiornaContoCorrente.html">
	<input type="hidden" name="dataCreazione" value=${c.getData_creazione()} readonly/>
	<input type="hidden" name="iban" value=${c.getIban()} readonly/>
	<input type="hidden" name="saldo" value=${c.getSaldo()} readonly/>
	<input type="hidden" name="idCliente" value=${c.getIdCliente()} readonly/>
	<button type="submit" class="inserisci">Modifica</button>
	</form>
	</td>
</tr>
</c:forEach>
</table><br>
	<a href=/biblioteca>Torna alla homepage</a>
</body>
</html>