<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page import="java.util.ArrayList" %>
<%@page import="dto.CorsiDto" %>
<%@page import="dto.IstruttoreDto" %>
<%@page import="java.util.List" %>
<link rel="stylesheet" href="../../style.css">

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci iscrizione</title>
</head>
<body>
<h1>Inserisci un'iscrizione</h1>
	<form action="FrequentaCtr" method="get">
		
		<label>Id</label><input type="text" name="id" required/><br>		
		
		<label>Id Corso</label><select id="Corsi" name="idCorso">
		
		<c:forEach var="c" items="${ListaCorsi}">
  		<option value="${c.getId()}">${c.getNome()}</option>
  		</c:forEach>
  			
		</select><br>
		
		<label>Id Dipendente</label><input type="text" name="idDipendente" required><br>

		<label>Id Istruttore</label><select name="idIstruttore" id="idIstruttore">
		<c:forEach var="c" items="${ListaIstruttore}">
  		<option value="${c.getMatricola()}">${c.getCognome()}</option>
  		</c:forEach>	
		</select><br>${li[0].getCognome()}
		<input type="hidden" name="tipoOperazione" value="inserisciFrequenta">
		<button type="submit" class="inserisci" value="Inserisci Frequenta!">Inserisci iscrizione!</button>
	</form>
	<br>
	<a href=/biblioteca>Torna alla homepage</a>

</body>
</html>