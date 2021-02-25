<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@page import="proxy.Movimenti" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="../../style.css">
<meta charset="ISO-8859-1">
<title>Lista di Tutti i Movimenti</title>
</head>
<body>
<h3> Lista dei Movimenti </h3>
<table>

<c:forEach var="c" items="${listaM}">

<tr>
	<td><form action="Cancella">
	<input type="text" name="data_movimento" value="<fmt:formatDate value="${c.getData_movimento()}" pattern="yyyy-MM-dd"/>
	" readonly/>
	<input type="text" name="id" value="${c.getId()}" readonly/>
	<input type="text" name="idTipoMovimento" value="${c.getId_tipo_movimento()}" readonly/>
	<input type="text" name="iban" value="${c.getIban()}" readonly/>
		<input type="text" name="importo" value="${c.getImporto()}" readonly/>
	<button type="submit" class="rimuovi">Cancella</button>
	</form>
	</td><td>
	<form action="aggiornaM.html">
	<input type="hidden" name="data_movimento" value="<fmt:formatDate value="${c.getData_movimento()}" pattern="yyyy-MM-dd"/>" readonly/>
	<input type="hidden" name="iban" value="${c.getIban()}" readonly/>
	<input type="hidden" name="id" value="${c.getId()}" readonly/>
	<input type="hidden" name="importo" value="${c.getImporto()}" readonly/>	
	<input type="hidden" name="idTipoMovimento" value="${c.getId_tipo_movimento()}" readonly/>
	<button type="submit" class="inserisci">Modifica</button>
	</form>
	</td>
</tr>
</c:forEach>
</table><br>
	<a href=/Biblioteca-0.0.1-SNAPSHOT>Torna alla homepage</a>
</body>
</html>