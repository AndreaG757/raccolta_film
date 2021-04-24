<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	
	<jsp:include page="../header.jsp" />
	<link href="./assets/css/global.css" rel="stylesheet">
		
	<title>Elimina Regista</title>
	
</head>

<body>

	<jsp:include page="../navbar.jsp" />

	
	<main role="main" class="container">

		<div class='card'>
		    <div class='card-header'>
		        Visualizza dettaglio
		    </div>
		
		    <div class='card-body'>
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Id:</dt>
				  <dd class="col-sm-9">${film_delete_attribute.id}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Nome:</dt>
				  <dd class="col-sm-9">${film_delete_attribute.titolo}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Cognome:</dt>
				  <dd class="col-sm-9">${film_delete_attribute.genere}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Durata Minuti:</dt>
				  <dd class="col-sm-9">${film_delete_attribute.minutiDurata}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Data di Nascita:</dt>
				  <dd class="col-sm-9"><fmt:formatDate type = "date" value = "${film_delete_attribute.dataPubblicazione}" /></dd>
		    	</dl>
		    	
		    </div>
		    
		    <div class='card-footer'>
		        <form action="ExecuteDeleteFilmServlet" method="post">
			        <a href="ExecuteListFilmServlet" class='btn btn-outline-secondary' style='width:7em;'>
			            <i class='fa fa-chevron-left'></i> Indietro
			        </a>
			        <input type="hidden" name="idDeleteInput" value="${film_delete_attribute.id}">
		        	<button type="submit" name="submit" value="submit" id="submit" class="btn btn-danger" style='width:7em;'>Elimina</button>
		        </form> 
		    </div>
		</div>	
		
	</main>
	
	<jsp:include page="../footer.jsp" />

</body>

</html>