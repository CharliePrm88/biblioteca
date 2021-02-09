package ctrCorsi;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.IstruttoreEjbRemote;
import dto.IstruttoreDto;
/**
 * Servlet implementation class IstruttoreCtr
 */
@WebServlet("/IstruttoreCtr")
public class IstruttoreCtr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Resource(mappedName = "java:jboss/exported/Corsi/IstruttoreEjb!ejb.IstruttoreEjbRemote")
	private IstruttoreEjbRemote ier;
	
    public IstruttoreCtr() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s = request.getParameter("tipoOperazione");
		switch(s) {
		case "inserisciIstruttore":
			IstruttoreDto i= new IstruttoreDto(Integer.parseInt(request.getParameter("matricola")),request.getParameter("nome"),request.getParameter("cognome"),request.getParameter("codiceFiscale"));
			ier.inserisciIstruttore(i);
			request.getRequestDispatcher("/Inserimento.html").forward(request, response);			break;
		case "ritornaListaIstruttore":
			List<IstruttoreDto> l1 = ier.ritornaListaIstruttore();
			request.setAttribute("ListaIstruttore", l1);
			request.getRequestDispatcher("/ListaTuttiIstruttore.jsp").forward(request, response);
			break;
		case "ritornaIstruttore":
			int id= Integer.parseInt(request.getParameter("matricola"));
			IstruttoreDto c1= ier.ritornaIstruttore(id);
			request.setAttribute("Istruttore", c1);
			request.getRequestDispatcher("/ritornaIstruttore.jsp").forward(request, response);
			break;
		case "aggiornaIstruttore":
			IstruttoreDto i1= new IstruttoreDto(Integer.parseInt(request.getParameter("matricola")),request.getParameter("nome"),request.getParameter("cognome"),request.getParameter("codiceFiscale"));
			ier.aggiornaIstruttore(i1);
			List<IstruttoreDto> l2 = ier.ritornaListaIstruttore();
			request.setAttribute("ListaIstruttore", l2);
			request.getRequestDispatcher("/ListaTuttiIstruttore.jsp").forward(request, response);
			break;
		case "cancellaIstruttore":
			IstruttoreDto j= new IstruttoreDto(Integer.parseInt(request.getParameter("matricola")),null,null,null);
			ier.cancellaIstruttore(j);
			List<IstruttoreDto> l3 = ier.ritornaListaIstruttore();
			request.setAttribute("ListaIstruttore", l3);
			request.getRequestDispatcher("/ListaTuttiIstruttore.jsp").forward(request, response);
			
			break;
		case "":
			break;
		default:
			response.getWriter().append("Comando Non Trovato!");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
