package it.prova.raccoltafilm.web.servlet.regista;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.raccoltafilm.model.Regista;
import it.prova.raccoltafilm.service.MyServiceFactory;

@WebServlet("/ExecuteDeleteRegistaServlet")
public class ExecuteDeleteRegistaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public ExecuteDeleteRegistaServlet() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idLibroParam = request.getParameter("idDeleteInput");
		
		if (!NumberUtils.isCreatable(idLibroParam)) {
			request.setAttribute("errorMessage", "Attenzione, si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		try {
			
			Regista regista = MyServiceFactory.getRegistaServiceInstance().caricaSingoloElemento(Long.parseLong(idLibroParam));
			MyServiceFactory.getRegistaServiceInstance().rimuovi(regista);
			request.setAttribute("registi_list_attribute", MyServiceFactory.getRegistaServiceInstance().listAllElements());
			request.setAttribute("successMessage", "Operazione eseguita con successo!");
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Non puoi eliminare un regista se ha ancora i suoi film!");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("/regista/list.jsp").forward(request, response);
		
	}

}
