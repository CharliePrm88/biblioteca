<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@page import="dto.CorsiDto" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="../../style.css">
<meta charset="ISO-8859-1">
<title>Lista di Tutti i Corsi</title>
</head>
<body>
<h3> Lista dei Corsi</h3>
<table>

<c:forEach var="c" items="${ListaCorsi}">

<tr>
	<td><form action="Cancella">
	<input type="text" name="id" value="${c.getId()}" readonly/>
	<input type="text" name="nome" value="${c.getNome()}" readonly/>
	<input type="text" name="data_inizio" value="<fmt:formatDate value="${c.getData_inizio()}" pattern="yyyy-MM-dd"/>
	" readonly/>
	<input type="text" name="data_fine" value="<fmt:formatDate value="${c.getData_fine()}" pattern="yyyy-MM-dd"/>
	" readonly/>
	<button type="submit" class="rimuovi">Cancella</button>
	</form>
	</td><td>
	<form action="aggiornaCorso.html">
	<input type="hidden" name="data_inizio" value="<fmt:formatDate value="${c.getData_inizio()}" pattern="yyyy-MM-dd"/>" readonly/>
	<input type="hidden" name="data_fine" value="<fmt:formatDate value="${c.getData_fine()}" pattern="yyyy-MM-dd"/>" readonly/>
	<input type="hidden" name="id" value="${c.getId()}" readonly/>
	<input type="hidden" name="nome" value="${c.getNome()}" readonly/>
	<button type="submit" class="inserisci">Modifica</button>
	</form>
	</td>
</tr>
</c:forEach>
</table><br>
	<a href=/Biblioteca-0.0.1-SNAPSHOT>Torna alla homepage</a>
</body>
</html>