package it.prova.raccoltafilm.web.servlet.film;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.raccoltafilm.model.Film;
import it.prova.raccoltafilm.service.MyServiceFactory;
import it.prova.raccoltafilm.utility.UtilityForm;

@WebServlet("/ExecuteEditFilmServlet")
public class ExecuteEditFilmServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public ExecuteEditFilmServlet() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idParam = request.getParameter("idEditInput");
		String titoloParam = request.getParameter("titolo");
		String genereParam = request.getParameter("genere");
		String durataParam = request.getParameter("minutiDurata");
		String dataDiNascitaParam = request.getParameter("dataParsed");
		String registaParam = request.getParameter("regista.id");
		
		Film filmInstance = UtilityForm.createFilmFromParams(titoloParam, genereParam, durataParam,
				dataDiNascitaParam, registaParam); 
		filmInstance.setId(Long.parseLong(idParam));
		
		if(!UtilityForm.validateFilmBean(filmInstance)) {
			request.setAttribute("edit_film_attribute", filmInstance);
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/film/edit.jsp").forward(request, response);
			return;
		}
		
		try {
			MyServiceFactory.getFilmServiceInstance().aggiorna(filmInstance);
			request.setAttribute("film_list_attribute", MyServiceFactory.getFilmServiceInstance().listAllElements());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/film/edit.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("/film/list.jsp").forward(request, response);
		
	}

}
