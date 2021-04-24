package it.prova.raccoltafilm.web.servlet.regista;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.raccoltafilm.model.Regista;
import it.prova.raccoltafilm.model.Sesso;
import it.prova.raccoltafilm.service.MyServiceFactory;
import it.prova.raccoltafilm.utility.UtilityForm;

@WebServlet("/ExecuteEditRegistaServlet")
public class ExecuteEditRegistaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public ExecuteEditRegistaServlet() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idParam = request.getParameter("idEditInput");
		String nomeParam = request.getParameter("nome");
		String cognomeParam = request.getParameter("cognome");
		String nickNameParam = request.getParameter("nickName");
		String dataDiNascitaParam = request.getParameter("dataParsed");
		String sessoParam = request.getParameter("sesso");
		
		Regista registaInstance = UtilityForm.createRegistaFromParams(nomeParam, cognomeParam, nickNameParam,
				dataDiNascitaParam, sessoParam); 
		registaInstance.setId(Long.parseLong(idParam));
		
		if(!UtilityForm.validateRegistaBean(registaInstance)) {
			
			request.setAttribute("edit_regista_attribute", registaInstance);
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/regista/edit.jsp").forward(request, response);
			return;
			
		}
		
		try {
			MyServiceFactory.getRegistaServiceInstance().aggiorna(registaInstance);
			request.setAttribute("registi_list_attribute", MyServiceFactory.getRegistaServiceInstance().listAllElements());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/regista/edit.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("/regista/list.jsp").forward(request, response);
		
	}

}
