package ctr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import dao.DipendenteDao;
import model.Dipendenti;
/**
 * Servlet implementation class DipendenteCtr
 */
@WebServlet("/DipendenteCtr")
public class DipendenteCtr extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DipendenteDao dipe = new DipendenteDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DipendenteCtr() {
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
		case "inserisciDipendente":
			Dipendenti c= new Dipendenti(request.getParameter("nome"),request.getParameter("cognome"),request.getParameter("codiceFiscale"));
			inserisciDipendente(c);
			request.getRequestDispatcher("/Inserimento.html").forward(request, response);
			break;
		case "ritornaListaDipendenti":
			List<Dipendenti> l1 = ritornaListaDipendenti();
			request.setAttribute("ListaDipendenti", l1);
			request.getRequestDispatcher("/ListaTuttiDipendenti.jsp").forward(request, response);
			break;
		case "ritornaDipendenti":
			int id= Integer.parseInt(request.getParameter("matricola"));
			Dipendenti c1=ritornaDipendenti(id);
			request.setAttribute("Dipendenti", c1);
			request.getRequestDispatcher("/ritornaDipendente.jsp").forward(request, response);
			break;
		case "aggiornaDipendenti":
			Dipendenti i= new Dipendenti(Integer.parseInt(request.getParameter("matricola")),request.getParameter("nome"),request.getParameter("cognome"),request.getParameter("codiceFiscale"));
			aggiornaDipendenti(i);
			List<Dipendenti> l2 = ritornaListaDipendenti();
			request.setAttribute("ListaDipendenti", l2);
			request.getRequestDispatcher("/ListaTuttiDipendenti.jsp").forward(request, response);
			break;
		case "cancellaDipendenti":
			Dipendenti j= new Dipendenti(Integer.parseInt(request.getParameter("matricola")),null,null,null);
			cancellaDipendenti(j);
			List<Dipendenti> l3 = ritornaListaDipendenti();
			request.setAttribute("ListaDipendenti", l3);
			request.getRequestDispatcher("/ListaTuttiDipendenti.jsp").forward(request, response);
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

	private void inserisciDipendente(Dipendenti dip) {
		dipe.inserisciDipendente(dip);
	}
	
	private List<Dipendenti> ritornaListaDipendenti(){
		List<Dipendenti> l1 = new ArrayList<>();
		l1=dipe.ritornaListaDipendenti();
		return l1;
	}
	private Dipendenti ritornaDipendenti(int id) {
		Dipendenti d1 = dipe.ritornaDipendenti(id);
		return d1;
	}
	private void aggiornaDipendenti(Dipendenti dip) {
		dipe.aggiornaDipendenti(dip);
	}
	private void cancellaDipendenti(Dipendenti dip) {
		dipe.cancellaDipendenti(dip);
	}
}
