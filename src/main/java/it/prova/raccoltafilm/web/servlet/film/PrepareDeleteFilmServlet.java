package it.prova.raccoltafilm.web.servlet.film;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.raccoltafilm.model.Film;
import it.prova.raccoltafilm.service.MyServiceFactory;

@WebServlet("/PrepareDeleteFilmServlet")
public class PrepareDeleteFilmServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public PrepareDeleteFilmServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idParameter = request.getParameter("idFilm");
		
		try {
			
			Film film = MyServiceFactory.getFilmServiceInstance().caricaSingoloElemento(Long.parseLong(idParameter));
			request.setAttribute("film_delete_attribute", film);
			request.getRequestDispatcher("/film/delete.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/film/delete.jsp").forward(request, response);
			return;
		}
		
	}

}
