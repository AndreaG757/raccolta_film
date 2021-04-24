<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
    
<!DOCTYPE html>
<html>

<head>

	<jsp:include page="../header.jsp" />
	<link href="./assets/css/global.css" rel="stylesheet">

	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	
</head>

<body>

	<jsp:include page="../navbar.jsp" />
	
	
	<main role="main" class="container">
	
			<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
			  ${errorMessage}
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
			
			<div class='card'>
			    <div class='card-header'>
			        <h5>Inserisci elemento da modificare</h5> 
			    </div>
			    <div class='card-body'>
	
					<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>
	
						<form method="post" action="ExecuteEditFilmServlet" novalidate="novalidate">
						
							<div class="form-row">
								<div class="form-group col-md-6">
								
									<label>Titolo<span class="text-danger">*</span></label>
									<input type="text" name="titolo" id="titolo" class="form-control" 
									value="${edit_film_attribute.titolo}" placeholder="Inserire il titolo da modificare" required>
								
								</div>
								
								<div class="form-group col-md-6">
								
									<label>Genere<span class="text-danger">*</span></label>
									<input type="text" name="genere" id="genere" class="form-control" 
									value="${edit_film_attribute.genere}" placeholder="Inserire il genere da modificare" required>
								
								</div>
							</div>
							
							<div class="form-row">	
								<div class="form-group col-md-6">
									<label>Durata (minuti) <span class="text-danger">*</span></label>
									<input type="number" class="form-control" name="minutiDurata" id="minutiDurata" placeholder="Inserire la durata" value="${edit_film_attribute.minutiDurata }" required>
							</div>
								
							<div class="form-group col-md-3">
								<label>Data di Pubblicazione<span class="text-danger">*</span></label>
								
								<fmt:formatDate value="${edit_film_attribute.dataPubblicazione}" type="date" pattern="yyyy-MM-dd" var="dataParsed"/>
	                     		<input class="form-control" id="dataPubblicazione" type="date" placeholder="dd/MM/yy" name="dataParsed"
	                         	       title="formato : gg/mm/aaaa" value="${dataParsed}" required>
	                         	
							</div>
							
							<div class="form-row">	
							<div class="form-group col-md-6">
								<label for="regista.id">Regista</label>
							    <select class="form-control" id="regista.id" name="regista.id">
							    	<option value="" selected> -- Selezionare una voce -- </option>
							      	<c:forEach items="${registi_list_attribute }" var="registaItem">
							      		<option value="${registaItem.id}" ${edit_film_attribute.regista.id == registaItem.id?'selected':''} >${registaItem.nome } ${registaItem.cognome }</option>
							      	</c:forEach>
							    </select>
							</div>
						</div>
								
							</div>
								
							<a href="ExecuteListFilmServlet" class='btn btn-outline-secondary' style='width:7em;'>
			           			<i class='fa fa-chevron-left'></i> Indietro
			      			</a>
							<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary" style='width:7em;'>Modifica</button>
			      			<input type="hidden" name="idEditInput" value="${edit_film_attribute.id}">
						
						</form>
			    
				<!-- end card-body -->			   
			    </div>
			</div>	
	
	
	<!-- end container -->	
	</main>
				
	<jsp:include page="../footer.jsp" />

</body>

</html>