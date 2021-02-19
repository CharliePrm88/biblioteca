<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page import="java.util.ArrayList" %>
<%@page import="model.Libri" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="../../style.css">
<meta charset="ISO-8859-1">
<title>Lista di Tutti i Libri</title>
</head>
<body>
<h3> Lista dei libri </h3>
<table>
<c:forEach var="c" items="${ListaLibri}">
<tr>
	<td><form action="LibriCtr">
	<input type="text" name="idlibro" value="${c.getIdlibro()}" readonly/>
	<input type="text" name="numeroPagine" value="${c.getNumeroPagine()}" readonly/>
	<input type="text" name="titolo" value="${c.getTitolo()}" readonly/>
	<input type="text" name="annoDiStampa" value="${c.getAnnoDiStampa()}" readonly/>
	<input type="text" name="genere"value="${c.getGenere()}" readonly/>
	<input type="text" name="autore" value="${c.getAutore()}" readonly/>
	<input type="text" name="ISBN" value="${c.getISBN()}" readonly/>
	<input type="text" name="casaEditrice" value="${c.getCasaEditrice()}" readonly/>
	<input type="text" name="posizione"value="${c.getPosizione()}" readonly/>
	<input type="hidden" name="tipoOperazione" value="cancellaLibri">
	<button type="submit" class="rimuovi">Cancella</button>
	</form>
	</td><td>
	<form action="aggiornaLibro.html">
	<input type="hidden" name="idlibro" value="${c.getIdlibro()}" readonly/>
	<input type="hidden" name="numeroPagine" value="${c.getNumeroPagine()}" readonly/>
	<input type="hidden" name="titolo" value="${c.getTitolo()}" readonly/>
	<input type="hidden" name="annoDiStampa" value="${c.getAnnoDiStampa()}" readonly/>
	<input type="hidden" name="genere"value="${c.getGenere()}" readonly/>
	<input type="hidden" name="autore" value="${c.getAutore()}" readonly/>
	<input type="hidden" name="ISBN" value="${c.getISBN()}" readonly/>
	<input type="hidden"  name="casaEditrice" value="${c.getCasaEditrice()}" readonly/>
	<input type="hidden" name="posizione"value="${c.getPosizione()}" readonly/>
	<button type="submit" class="inserisci">Modifica</button>
	</form>
	</td>
</tr>
</c:forEach>
</table><br>
	<a href=/biblioteca>Torna alla homepage</a>
</body>
</html>