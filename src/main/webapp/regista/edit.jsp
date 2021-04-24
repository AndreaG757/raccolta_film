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
	
						<form method="post" action="ExecuteEditRegistaServlet" novalidate="novalidate">
						
							<div class="form-row">
								<div class="form-group col-md-6">
								
									<label>Nome<span class="text-danger">*</span></label>
									<input type="text" name="nome" id="nome" class="form-control" 
									value="${edit_regista_attribute.nome}" placeholder="Inserire il nome da modificare" required>
								
								</div>
								
								<div class="form-group col-md-6">
								
									<label>Cognome<span class="text-danger">*</span></label>
									<input type="text" name="cognome" id="cognome" class="form-control" 
									value="${edit_regista_attribute.cognome}" placeholder="Inserire il cognome da modificare" required>
								
								</div>
							</div>
							
							<div class="form-row">	
								<div class="form-group col-md-6">
									<label>Nickname <span class="text-danger">*</span></label>
									<input type="text" class="form-control" name="nickName" id="nickName" placeholder="Inserire il nickname" value="${edit_regista_attribute.nickName }" required>
							</div>
								
								<div class="form-group col-md-3">
									<label for="sesso">Sesso <span class="text-danger">*</span></label>
								    <select class="form-control" id="sesso" name="sesso" required>
								    	<option value="" selected> - Selezionare - </option>
								      	<option value="MASCHIO" ${edit_regista_attribute.sesso == 'MASCHIO'?'selected':''} >M</option>
								      	<option value="FEMMINA" ${edit_regista_attribute.sesso == 'FEMMINA'?'selected':''} >F</option>
								    </select>
								</div>
								
								<div class="form-group col-md-3">
									<label>Data di Nascita<span class="text-danger">*</span></label>
									
									<fmt:formatDate value="${edit_regista_attribute.dataDiNascita}" type="date" pattern="yyyy-MM-dd" var="dataParsed"/>
		                     		<input class="form-control" id="dataNascita" type="date" placeholder="dd/MM/yy" name="dataParsed"
		                         	       title="formato : gg/mm/aaaa" value="${dataParsed}" required>
		                         	
								</div>
								
							</div>
								
							<a href="ExecuteListRegistaServlet" class='btn btn-outline-secondary' style='width:7em;'>
			           			<i class='fa fa-chevron-left'></i> Indietro
			      			</a>
							<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary" style='width:7em;'>Modifica</button>
			      			<input type="hidden" name="idEditInput" value="${edit_regista_attribute.id}">
						
						</form>
			    
				<!-- end card-body -->			   
			    </div>
			</div>	
	
	
	<!-- end container -->	
	</main>
				
	<jsp:include page="../footer.jsp" />

</body>

</html>