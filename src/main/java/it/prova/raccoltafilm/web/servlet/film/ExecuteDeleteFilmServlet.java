package it.prova.raccoltafilm.web.servlet.film;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.raccoltafilm.model.Film;
import it.prova.raccoltafilm.service.MyServiceFactory;

@WebServlet("/ExecuteDeleteFilmServlet")
public class ExecuteDeleteFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExecuteDeleteFilmServlet() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idLibroParam = request.getParameter("idDeleteInput");
		
		if (!NumberUtils.isCreatable(idLibroParam)) {
			request.setAttribute("errorMessage", "Attenzione, si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		try {
			
			Film film = MyServiceFactory.getFilmServiceInstance().caricaSingoloElemento(Long.parseLong(idLibroParam));
			MyServiceFactory.getFilmServiceInstance().rimuovi(film);
			request.setAttribute("film_list_attribute", MyServiceFactory.getFilmServiceInstance().listAllElements());
			request.setAttribute("successMessage", "Operazione eseguita con successo!");
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Non puoi eliminare un regista se ha ancora i suoi film!");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("/film/list.jsp").forward(request, response);
		
	}

}
