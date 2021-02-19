package ctr;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Libri;
import java.util.ArrayList;
import java.util.List;
import dao.LibriDao;
/**
 * Servlet implementation class LibriCtr
 */
@WebServlet("/LibriCtr")
public class LibriCtr extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LibriDao cli = new LibriDao();
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibriCtr() {
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
		case "inserisciLibro":
			String s1 = request.getParameter("annoDiStampa");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date1 = null;
			try {
				date1 = sdf.parse(s1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Date d1 = new Date(date1.getTime());
			Libri c= new Libri(d1,Integer.parseInt(request.getParameter("numeroPagine")),request.getParameter("titolo"),request.getParameter("genere"),request.getParameter("autore"),request.getParameter("ISBN"),request.getParameter("casaEditrice"),request.getParameter("posizione"));
			inserisciLibri(c);
			request.getRequestDispatcher("/Inserimento.html").forward(request, response);
			break;
		case "ritornaListaLibri":
			List<Libri>l1=ritornaListaLibri();
			request.setAttribute("ListaLibri", l1);
			request.getRequestDispatcher("/ListaTuttiLibri.jsp").forward(request, response);
			break;
		case "ritornaLibro":
			int id= Integer.parseInt(request.getParameter("idLibro"));
			Libri l2=ritornaLibro(id);
			request.setAttribute("Libri", l2);
			request.getRequestDispatcher("/ritornaLibro.jsp").forward(request, response);
			break;
		case "aggiornaLibri":
			String s2 = request.getParameter("annoDiStampa");
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date2 = null;
			try {
				date2 = sdf1.parse(s2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Date d2 = new Date(date2.getTime());
			Libri c1= new Libri(Integer.parseInt(request.getParameter("idLibro")),d2,Integer.parseInt(request.getParameter("numeroPagine")),request.getParameter("titolo"),request.getParameter("genere"),request.getParameter("autore"),request.getParameter("ISBN"),request.getParameter("casaEditrice"),request.getParameter("posizione"));
			aggiornaLibri(c1);
			List<Libri>l21=ritornaListaLibri();
			request.setAttribute("ListaLibri", l21);
			request.getRequestDispatcher("/ListaTuttiLibri.jsp").forward(request, response);break;
		case "cancellaLibri":
			Libri c2= new Libri(Integer.parseInt(request.getParameter("idlibro")),null,0,null,null,null,null,null,null);
			cancellaLibri(c2);
			List<Libri>l3=ritornaListaLibri();
			request.setAttribute("ListaLibri", l3);
			request.getRequestDispatcher("/ListaTuttiLibri.jsp").forward(request, response);break;
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
	private void inserisciLibri(Libri lib) {
		cli.inserisciLibri(lib);
	}
	private List<Libri> ritornaListaLibri(){
		List<Libri> l1 = new ArrayList<>();
		l1=cli.ritornaListaLibri();
		return l1;
	}	
	private Libri ritornaLibro(int id) {
		Libri l1=cli.ritornaLibro(id);
		return l1;
	}
	private void aggiornaLibri(Libri lib) {
		cli.aggiornaLibri(lib);
	}
	private void cancellaLibri(Libri lib) {
		cli.cancellaLibri(lib);
	}
}
