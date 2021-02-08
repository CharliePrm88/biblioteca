<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page import="java.util.ArrayList" %>
<%@page import="model.Istruttore" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Lista di Tutti gli Istruttori</title>
</head>
<body>
<h3> Lista degli Istruttori</h3>
<table>
<c:forEach var="c" items="${ListaIstruttore}">
<tr>
	<td><form action="IstruttoreCtr">
	<input type="text" name="matricola" value="${c.getMatricola()}" readonly/>
	<input type="text" name="nome" value="${c.getNome()}" readonly/>
	<input type="text" name="cognome" value="${c.getCognome()}" readonly/>
	<input type="text" name="codiceFiscale" value="${c.getCodiceFiscale()}" readonly/>
	<input type="hidden" name="tipoOperazione" value="cancellaIstruttore">
	<button type="submit" class="rimuovi">Cancella</button>
	</form>
	</td><td>
	<form action="aggiornaIstruttore.html">
	<input type="hidden" name="matricola" value="${c.getMatricola()}"/>
	<input type="hidden" name="nome" value="${c.getNome()}" readonly/>
	<input type="hidden" name="cognome" value="${c.getCognome()}" readonly/>
	<input type="hidden" name="codiceFiscale" value="${c.getCodiceFiscale()}" readonly/>
	<button type="submit" class="inserisci">Modifica</button>
	</form>
	</td>
</tr>
</c:forEach>
</table><br>
	<a href=/biblioteca>Torna alla homepage</a>
</body>
</html>