package ctr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Clienti;
import dao.ClientiDao;

/**
 * Servlet implementation class ClientiCtr
 */
@WebServlet("/ClientiCtr")
public class ClientiCtr extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClientiDao cli = new ClientiDao();
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public ClientiCtr() {
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
		case "inserisciCliente":
			Clienti c= new Clienti(Integer.parseInt(request.getParameter("idCliente")),request.getParameter("nome"),request.getParameter("cognome"),request.getParameter("codiceFiscale"));
			inserisciCliente(c);
			request.getRequestDispatcher("/Inserimento.html").forward(request, response);			break;
		case "ritornaListaClienti":
			List<Clienti> l1 = ritornaListaClienti();
			request.setAttribute("ListaClienti", l1);
			request.getRequestDispatcher("/ListaTuttiClienti.jsp").forward(request, response);
			break;
		case "ritornaClienti":
			int id= Integer.parseInt(request.getParameter("idCliente"));
			Clienti c1=ritornaClienti(id);
			request.setAttribute("Clienti", c1);
			request.getRequestDispatcher("/ritornaCliente.jsp").forward(request, response);
			break;
		case "aggiornaClienti":
			Clienti i= new Clienti(Integer.parseInt(request.getParameter("idCliente")),request.getParameter("nome"),request.getParameter("cognome"),request.getParameter("codiceFiscale"));
			aggiornaClienti(i);
			List<Clienti> l2 = ritornaListaClienti();
			request.setAttribute("ListaClienti", l2);
			request.getRequestDispatcher("/ListaTuttiClienti.jsp").forward(request, response);
			break;
		case "cancellaClienti":
			Clienti j= new Clienti(Integer.parseInt(request.getParameter("idCliente")),null,null,null);
			cancellaClienti(j);
			List<Clienti> l3 = ritornaListaClienti();
			request.setAttribute("ListaClienti", l3);
			request.getRequestDispatcher("/ListaTuttiClienti.jsp").forward(request, response);
			
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
	private void inserisciCliente(Clienti c) {
		cli.inserisciCliente(c);
	}
	private List<Clienti> ritornaListaClienti() {
		List<Clienti> l1 = new ArrayList<>();
		l1=cli.ritornaListaClienti();
		return l1;
	}
	private Clienti ritornaClienti(int id) {
		Clienti c1 = cli.ritornaClienti(id);
		return c1;
	}
	private void aggiornaClienti(Clienti c) {
		cli.aggiornaClienti(c);
	}
	private void cancellaClienti(Clienti c) {
		cli.cancellaClienti(c);
	}
}
