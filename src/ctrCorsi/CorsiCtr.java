package ctrCorsi;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.CorsiEjbRemote;
import dto.CorsiDto;

/**
 * Servlet implementation class ListaCorsiCtr
 */
@WebServlet("/CorsiCtr")
public class CorsiCtr extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(mappedName = "java:jboss/exported/Corsi/CorsiEjb!ejb.CorsiEjbRemote")
	private CorsiEjbRemote fer;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CorsiCtr() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s = request.getParameter("tipoOperazione");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		switch(s) {
		case "inserisciCorsi":
			String s1 = request.getParameter("data_inizio");
			String s2 = request.getParameter("data_fine");
			java.util.Date date1 = null;
			java.util.Date date2 = null;
			try {
				date1 = sdf.parse(s1);
				date2 = sdf.parse(s2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date d1 = new Date(date1.getTime());
			java.sql.Date d2 = new Date(date2.getTime());
			CorsiDto i= new CorsiDto(Integer.parseInt(request.getParameter("id")), request.getParameter("nome"), d1,d2);
			fer.inserisciCorsi(i);
			request.getRequestDispatcher("/Inserimento.html").forward(request, response);			break;
		case "ritornaListaCorsi":
			List<CorsiDto> l1 = fer.ritornaListaCorsi();
			request.setAttribute("ListaCorsi", l1);
			request.getRequestDispatcher("/ListaTuttiCorsi.jsp").forward(request, response);
			break;
		case "ritornaCorsi":
			int id= Integer.parseInt(request.getParameter("id"));
			CorsiDto c1= fer.ritornaCorsi(id);
			request.setAttribute("Corsi", c1);
			request.getRequestDispatcher("/ritornaCorsi.jsp").forward(request, response);
			break;
		case "aggiornaCorsi":
			String s3 = request.getParameter("data_inizio");
			String s4 = request.getParameter("data_fine");
			java.util.Date date3 = null;
			java.util.Date date4 = null;
			try {
				date3 = sdf.parse(s3);
				date4 = sdf.parse(s4);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date d3 = new Date(date3.getTime());
			java.sql.Date d4 = new Date(date4.getTime());
			CorsiDto i1= new CorsiDto(Integer.parseInt(request.getParameter("id")), request.getParameter("nome"), d3,d4);
			fer.aggiornaCorsi(i1);
			List<CorsiDto> l2 = fer.ritornaListaCorsi();
			request.setAttribute("ListaCorsi", l2);
			request.getRequestDispatcher("/ListaTuttiCorsi.jsp").forward(request, response);
			break;
		case "cancellaCorsi":
			String s5 = request.getParameter("data_inizio");
			String s6 = request.getParameter("data_fine");
			java.util.Date date5 = null;
			java.util.Date date6 = null;
			try {
				date5 = sdf.parse(s5);
				date6 = sdf.parse(s6);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date d5 = new Date(date5.getTime());
			java.sql.Date d6 = new Date(date6.getTime());
			CorsiDto j= new CorsiDto(Integer.parseInt(request.getParameter("id")), request.getParameter("nome"), d5,d6);
			fer.cancellaCorsi(j);
			List<CorsiDto> l3 = fer.ritornaListaCorsi();
			request.setAttribute("ListaCorsi", l3);
			request.getRequestDispatcher("/ListaTuttiCorsi.jsp").forward(request, response);
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
