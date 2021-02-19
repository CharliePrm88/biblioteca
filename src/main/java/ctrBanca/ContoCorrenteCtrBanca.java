package ctrBanca;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proxy.ContoCorrente;
import proxy.ContoCorrenteCtrProxy;
import proxy.ResponseContoCorrente;

/**
 * Servlet implementation class ContoCorrenteCtrBanca
 */
@WebServlet("/ContoCorrenteCtrBanca")
public class ContoCorrenteCtrBanca extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ContoCorrenteCtrProxy cccp = new ContoCorrenteCtrProxy();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContoCorrenteCtrBanca() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ContoCorrente cc = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date cal = null;
		String s = request.getParameter("tipoOperazione");
		switch(s) {
		case "inserisciCC":
			String data_creazione = request.getParameter("data_creazione");
			try {
				cal = sdf.parse(data_creazione);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cc = new ContoCorrente(cal,Integer.parseInt(request.getParameter("iban")),Integer.parseInt(request.getParameter("idCliente")),Float.parseFloat(request.getParameter("saldo")));
			cccp.inserisciCC(cc);
			request.getRequestDispatcher("/Inserimento.html").forward(request, response);
			break;
		case "cancellaCC":
			String data_creazione1 = request.getParameter("data_creazione");
			try {
				cal=sdf.parse(data_creazione1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cc = new ContoCorrente(cal,Integer.parseInt(request.getParameter("iban")),Integer.parseInt(request.getParameter("idCliente")),Float.parseFloat(request.getParameter("saldo")));
			cccp.cancellaCC(cc);
			ResponseContoCorrente l4 = cccp.ritornaListaCC();
			ContoCorrente[] cc4 = l4.getL1();
			request.setAttribute("listaCC", cc4);
			request.getRequestDispatcher("ListaTuttiCC.jsp").forward(request, response);
			break;
		case "aggiornaCC":
			String data_creazione2 = request.getParameter("data_creazione");
			try {
				cal=sdf.parse(data_creazione2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cc = new ContoCorrente(cal,Integer.parseInt(request.getParameter("iban")),Integer.parseInt(request.getParameter("idCliente")),Float.parseFloat(request.getParameter("saldo")));
			cccp.modificaCC(cc);
			ResponseContoCorrente l3 = cccp.ritornaListaCC();
			ContoCorrente[] cc3 = l3.getL1();
			request.setAttribute("listaCC", cc3);
			request.getRequestDispatcher("ListaTuttiCC.jsp").forward(request, response);
			break;
		case "ritornaCC":
			ResponseContoCorrente cc1=cccp.ritornaCC(Integer.parseInt(request.getParameter("idCliente")));
			ContoCorrente l2= cc1.getCc();
			request.setAttribute("CC", l2);
			request.getRequestDispatcher("/ritornaCC.jsp").forward(request, response);
			break;
		case "ritornaListaCC":
			ResponseContoCorrente l1 = cccp.ritornaListaCC();
			ContoCorrente[] cc2 = l1.getL1();
			request.setAttribute("listaCC", cc2);
			request.getRequestDispatcher("/ListaTuttiCC.jsp").forward(request, response);
			break;
		default:
			response.getWriter().append("Served at: ").append("Comando non trovato!");
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
