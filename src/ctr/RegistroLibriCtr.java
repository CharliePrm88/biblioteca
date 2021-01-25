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
import dao.RegistroLibriDao;
import model.RegistroLibri;
/**
 * Servlet implementation class RegistroLibriCtr
 */
@WebServlet("/RegistroLibriCtr")
public class RegistroLibriCtr extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RegistroLibriDao reg = new RegistroLibriDao();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroLibriCtr() {
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
		case "inserisciRegistro":
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date data_prestito = null;
			java.util.Date data_scadenza= null;
			java.util.Date data_rientro= null;
			try {
				data_prestito = sdf.parse(request.getParameter("data_prestito"));
				data_scadenza= sdf.parse(request.getParameter("data_scadenza"));
				data_rientro= sdf.parse(request.getParameter("data_rientro"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date d1 = new Date(data_prestito.getTime());
			java.sql.Date d2 = new Date(data_scadenza.getTime());
			java.sql.Date d3 = new Date(data_rientro.getTime());
			RegistroLibri c= new RegistroLibri(Integer.parseInt(request.getParameter("id")),Integer.parseInt(request.getParameter("idLibro")),Integer.parseInt(request.getParameter("idCliente")),Integer.parseInt(request.getParameter("matricola")),d1,d2,d3);
			inserisciregendente(c);
			request.getRequestDispatcher("/Inserimento.html").forward(request, response);
			break;
		case "ritornaListaRegistroLibri":
			List<RegistroLibri>l1=ritornaListaRegistroLibri();
			request.setAttribute("ListaRegistroLibri", l1);
			request.getRequestDispatcher("/ListaTuttiRegistri.jsp").forward(request, response);
			break;
		case "ritornaRegistroLibri":
			int id= Integer.parseInt(request.getParameter("idRegistro"));
			RegistroLibri rl=ritornaRegistroLibri(id);
			request.setAttribute("RegistroLibri", rl);
			request.getRequestDispatcher("/ritornaRegistroLibri.jsp").forward(request, response);
			break;
		case "aggiornaRegistroLibri":
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date data_prestito1 = null;
			java.util.Date data_scadenza1= null;
			java.util.Date data_rientro1= null;
			try {
				data_prestito1 = sdf1.parse(request.getParameter("data_prestito"));
				data_scadenza1= sdf1.parse(request.getParameter("data_scadenza"));
				data_rientro1= sdf1.parse(request.getParameter("data_rientro"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date d11 = new Date(data_prestito1.getTime());
			java.sql.Date d22 = new Date(data_scadenza1.getTime());
			java.sql.Date d33 = new Date(data_rientro1.getTime());
			RegistroLibri i= new RegistroLibri(Integer.parseInt(request.getParameter("id")),Integer.parseInt(request.getParameter("idLibro")),Integer.parseInt(request.getParameter("idcliente")),Integer.parseInt(request.getParameter("matricola")),d11,d22,d33);
			aggiornaRegistroLibri(i);
			List<RegistroLibri>l2=ritornaListaRegistroLibri();
			request.setAttribute("ListaRegistroLibri", l2);
			request.getRequestDispatcher("/ListaTuttiRegistri.jsp").forward(request, response);
			break;
		case "cancellaRegistroLibri":
			RegistroLibri j= new RegistroLibri(Integer.parseInt(request.getParameter("id")),0,0,0,null,null,null);
			cancellaRegistroLibri(j);
			List<RegistroLibri>l3=ritornaListaRegistroLibri();
			request.setAttribute("ListaRegistroLibri", l3);
			request.getRequestDispatcher("/ListaTuttiRegistri.jsp").forward(request, response);
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
	private void inserisciregendente(RegistroLibri r) {
		reg.inserisciregendente(r);
	}
	
	private List<RegistroLibri> ritornaListaRegistroLibri(){
		List<RegistroLibri> r1 = new ArrayList<>();
		r1=reg.ritornaListaRegistroLibri();
		return r1;
	}
	
	private RegistroLibri ritornaRegistroLibri(int id) {
		RegistroLibri r1 = reg.ritornaRegistroLibri(id);
		return r1;
	}
	private void aggiornaRegistroLibri(RegistroLibri r) {
		reg.aggiornaRegistroLibri(r);
	}
	private void cancellaRegistroLibri(RegistroLibri r) {
		reg.cancellaRegistroLibri(r);
	}
}
