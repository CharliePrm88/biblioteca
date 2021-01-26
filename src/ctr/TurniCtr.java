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
import java.util.ArrayList;
import java.util.List;
import dao.TurniDao;
import model.Turni;
/**
 * Servlet implementation class TurniCtr
 */
@WebServlet("/TurniCtr")
public class TurniCtr extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TurniDao tur = new TurniDao();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TurniCtr() {
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
		case "inserisciTurni":
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date data_inizio = null;
			java.util.Date data_fine= null;
			try {
				data_inizio = sdf.parse(request.getParameter("data_inizio"));
				data_fine= sdf.parse(request.getParameter("data_fine"));

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date d1 = new Date(data_inizio.getTime());
			java.sql.Date d2 = new Date(data_fine.getTime());
			Turni c= new Turni(Integer.parseInt(request.getParameter("matricola")),d1,d2);
			inserisciTurni(c);
			request.getRequestDispatcher("/Inserimento.html").forward(request, response);
			break;
		case "ritornaListaTurni":
			List<Turni>l1=ritornaListaTurni();
			request.setAttribute("ListaTurni", l1);
			request.getRequestDispatcher("/ListaTuttiTurni.jsp").forward(request, response);
			break;
		case "ritornaTurni":
			int id= Integer.parseInt(request.getParameter("idTurno"));
			Turni t=ritornaTurni(id);
			request.setAttribute("Turni", t);
			request.getRequestDispatcher("/ritornaTurno.jsp").forward(request, response);
			break;
		case "aggiornaTurni":
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date data_inizio1 = null;
			java.util.Date data_fine1 = null;
			try {
				 data_inizio1= sdf1.parse(request.getParameter("data_inizio"));
				 data_fine1= sdf1.parse(request.getParameter("data_fine"));

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date d11 = new Date(data_inizio1.getTime());
			java.sql.Date d22 = new Date(data_fine1.getTime());
			Turni c1= new Turni(Integer.parseInt(request.getParameter("idturno")),Integer.parseInt(request.getParameter("matricola")),d11,d22);
			aggiornaTurni(c1);
			List<Turni>l2=ritornaListaTurni();
			request.setAttribute("ListaTurni", l2);
			request.getRequestDispatcher("/ListaTuttiTurni.jsp").forward(request, response);
			break;
		case "cancellaTurni":
			Turni j= new Turni(Integer.parseInt(request.getParameter("idturno")),0,null,null);
			cancellaTurni(j);
			List<Turni>l3=ritornaListaTurni();
			request.setAttribute("ListaTurni", l3);
			request.getRequestDispatcher("/ListaTuttiTurni.jsp").forward(request, response);
			break;
		case "":
			break;
		default:
			response.getWriter().append("Comando Non Trovato!");
		}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void inserisciTurni(Turni tr) {
		tur.inserisciTurni(tr);
	}
	private List<Turni> ritornaListaTurni(){
		List<Turni> l1 = new ArrayList<>();
		l1=tur.ritornaListaTurni();
		return l1;
	}
	private Turni ritornaTurni(int id) {
		Turni t1 = tur.ritornaTurni(id);
		return t1;
	}
	
	private void aggiornaTurni(Turni t) {
		tur.aggiornaTurni(t);
	}
	
	private void cancellaTurni(Turni t) {
		tur.cancellaTurni(t);
	}
}
