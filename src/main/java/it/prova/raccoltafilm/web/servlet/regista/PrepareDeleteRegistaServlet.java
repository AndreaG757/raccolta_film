package it.prova.raccoltafilm.web.servlet.regista;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.raccoltafilm.model.Regista;
import it.prova.raccoltafilm.service.MyServiceFactory;

@WebServlet("/PrepareDeleteRegistaServlet")
public class PrepareDeleteRegistaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public PrepareDeleteRegistaServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idParameter = request.getParameter("idRegista");
		
		try {
			
			Regista regista = MyServiceFactory.getRegistaServiceInstance().caricaSingoloElemento(Long.parseLong(idParameter));
			request.setAttribute("regista_delete_attribute", regista);
			request.getRequestDispatcher("/regista/delete.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/regista/delete.jsp").forward(request, response);
			return;
		}
		
	}

}
