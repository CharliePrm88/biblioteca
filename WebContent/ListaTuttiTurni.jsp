<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page import="model.Turni" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Lista di Tutti i Turni</title>
</head>
<body>
<h3> Lista dei turni </h3>
<table>
<c:forEach var="c" items="${ListaTurni}">
<tr>
	<td><form action="TurniCtr">
	<input type="text" name="id" value=${c.getId()} readonly/>
	<input type="text" name="matricola" value=${c.getMatricola()} readonly/>
	<input type="text" name="data_inizio_turno" value=${c.getData_inizio_turno()} readonly/>
	<input type="text" name="data_fine_turno"value=${c.getData_fine_turno()} readonly/>
	<input type="hidden" name="tipoOperazione" value="cancellaClienti">
	<button type="submit" class="rimuovi">Cancella</button>
	</form>
	</td><td>
	<form action="aggiornaTurni.html">
	<input type="hidden" name="id" value=${c.getId()}/>
	<input type="hidden" name="matricola" value=${c.getMatricola()} readonly/>
	<input type="hidden" name="data_inizio_turno"value=${c.getData_inizio_turno()} readonly/>
	<input type="hidden" name="data_fine_turno"value=${c.getData_fine_turno()} readonly/>
	<button type="submit" class="inserisci">Modifica</button>
	</form>
	</td>
</tr>
</c:forEach>
</table>
</body>
</html>