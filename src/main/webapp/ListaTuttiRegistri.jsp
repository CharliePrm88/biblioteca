<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page import="model.RegistroLibri" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Lista di Tutti i Prestiti</title>
</head>
<body>
<h3> Lista dei prestiti </h3>
<table>
<c:forEach var="c" items="${ListaRegistroLibri}">
<tr>
	<td><form action="RegistroLibriCtr">
	<input type="text" name="id" value="${c.getId()}" readonly/>
	<input type="text" name="idLibro" value="${c.getIdlibro()}" readonly/>
	<input type="text" name="idCliente" value="${c.getIdcliente()}" readonly/>
	<input type="text" name="matricola" value="${c.getMatricola()}" readonly/>
	<input type="text" name="data_prestito" value="${c.getData_prestito()}" readonly/>
	<input type="text" name="data_scadenza" value="${c.getData_scadenza()}" readonly/>
	<input type="text" name="data_rientro" value="${c.getData_rientro()}" readonly/>
	<input type="hidden" name="tipoOperazione" value="cancellaRegistroLibri">
	<button type="submit" class="rimuovi">Cancella</button>
	</form>
	</td><td>
	<form action="aggiornaRegistro.html">
	<input type="hidden" name="id" value="${c.getId()}"/>
	<input type="hidden" name="idLibro" value="${c.getIdlibro()}" readonly/>
	<input type="hidden" name="idcliente" value="${c.getIdcliente()}" readonly/>
	<input type="hidden" name="matricola" value="${c.getMatricola()}" readonly/>
	<input type="hidden" name="data_prestito"value="${c.getData_prestito()}" readonly/>
	<input type="hidden" name="data_scadenza"value="${c.getData_scadenza()}" readonly/>
	<input type="hidden" name="data_rientro"value="${c.getData_rientro()}" readonly/>
	<button type="submit" class="inserisci">Modifica</button>
	</form>
	</td>
</tr>
</c:forEach>
</table><br>
	<a href=/biblioteca>Torna alla homepage</a>
</body>
</html>