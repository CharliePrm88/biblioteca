package ctrCorsi;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.FrequentaEjbRemote;
import model.Frequenta;


/**
 * Servlet implementation class FrequentaCtr
 */
@WebServlet("/FrequentaCtr")
public class FrequentaCtr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrequentaCtr() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Resource(mappedName = "java:jboss/exported/Corsi/FrequentaEjb!ejb.FrequentaEjbRemote")
	private FrequentaEjbRemote fer;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s = request.getParameter("tipoOperazione");
		switch(s) {
		case "inserisciFrequenta":
			Frequenta i= new Frequenta(Integer.parseInt(request.getParameter("id")),Integer.parseInt(request.getParameter("idCorso")),Integer.parseInt(request.getParameter("idDipendente")),Integer.parseInt(request.getParameter("idIstruttore")));
			fer.inserisciFrequenta(i);
			request.getRequestDispatcher("/Inserimento.html").forward(request, response);			break;
		case "ritornaListaFrequenta":
			List<Frequenta> l1 = fer.ritornaListaFrequenta();
			request.setAttribute("ListaFrequenta", l1);
			request.getRequestDispatcher("/ListaTuttiFrequenta.jsp").forward(request, response);
			break;
		case "ritornaFrequenta":
			int id= Integer.parseInt(request.getParameter("id"));
			Frequenta c1= fer.ritornaFrequenta(id);
			request.setAttribute("Frequenta", c1);
			request.getRequestDispatcher("/ritornaFrequenta.jsp").forward(request, response);
			break;
		case "aggiornaFrequenta":
			Frequenta i1= new Frequenta(Integer.parseInt(request.getParameter("id")),Integer.parseInt(request.getParameter("idCorso")),Integer.parseInt(request.getParameter("idDipendente")),Integer.parseInt(request.getParameter("idIstruttore")));
			fer.aggiornaFrequenta(i1);
			List<Frequenta> l2 = fer.ritornaListaFrequenta();
			request.setAttribute("ListaFrequenta", l2);
			request.getRequestDispatcher("/ListaTuttiFrequenta.jsp").forward(request, response);
			break;
		case "cancellaFrequenta":
			Frequenta j= new Frequenta(Integer.parseInt(request.getParameter("id")),Integer.parseInt(request.getParameter("idCorso")),Integer.parseInt(request.getParameter("idDipendente")),Integer.parseInt(request.getParameter("idIstruttore")));
			fer.cancellaFrequenta(j);
			List<Frequenta> l3 = fer.ritornaListaFrequenta();
			request.setAttribute("ListaFrequenta", l3);
			request.getRequestDispatcher("/ListaTuttiFrequenta.jsp").forward(request, response);
			
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
