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

import proxy.Movimenti;
import proxy.MovimentiCtrProxy;
import proxy.ResponseMovimenti;

/**
 * Servlet implementation class MovimentiCtrBanca
 */
@WebServlet("/MovimentiCtrBanca")
public class MovimentiCtrBanca extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MovimentiCtrProxy Mcp = new MovimentiCtrProxy();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovimentiCtrBanca() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Movimenti M = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date cal = null;
		String s = request.getParameter("tipoOperazione");
		switch(s) {
		case "inserisciM":
			String data_movimento = request.getParameter("data_movimento");
			try {
				cal = sdf.parse(data_movimento);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			M = new Movimenti(cal,Integer.parseInt(request.getParameter("iban")),Integer.parseInt(request.getParameter("id")),Integer.parseInt(request.getParameter("idTipoMovimento")),Float.parseFloat(request.getParameter("importo")));
			Mcp.inserisciM(M);
			request.getRequestDispatcher("/Inserimento.html").forward(request, response);
			break;
		case "cancellaM":
			String data_movimento1 = request.getParameter("data_movimento");
			try {
				cal=sdf.parse(data_movimento1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			M = new Movimenti(cal,Integer.parseInt(request.getParameter("iban")),Integer.parseInt(request.getParameter("id")),Integer.parseInt(request.getParameter("idTipoMovimento")),Float.parseFloat(request.getParameter("importo")));
			Mcp.cancellaM(M);
			ResponseMovimenti l4 = Mcp.ritornaListaM();
			Movimenti[] M4 = l4.getL1();
			request.setAttribute("listaM", M4);
			request.getRequestDispatcher("ListaTuttiM.jsp").forward(request, response);
			break;
		case "aggiornaM":
			String data_movimento2 = request.getParameter("data_movimento");
			try {
				cal=sdf.parse(data_movimento2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			M = new Movimenti(cal,Integer.parseInt(request.getParameter("iban")),Integer.parseInt(request.getParameter("id")),Integer.parseInt(request.getParameter("idTipoMovimento")),Float.parseFloat(request.getParameter("importo")));
			Mcp.modificaM(M);
			ResponseMovimenti l3 = Mcp.ritornaListaM();
			Movimenti[] M3 = l3.getL1();
			request.setAttribute("listaM", M3);
			request.getRequestDispatcher("ListaTuttiM.jsp").forward(request, response);
			break;
		case "ritornaM":
			ResponseMovimenti M1=Mcp.ritornaM(Integer.parseInt(request.getParameter("id")));
			Movimenti l2= M1.getM();
			request.setAttribute("M", l2);
			request.getRequestDispatcher("/ritornaM.jsp").forward(request, response);
			break;
		case "ritornaListaM":
			ResponseMovimenti l1 = Mcp.ritornaListaM();
			Movimenti[] M2 = l1.getL1();
			System.out.println(l1.getL1());
			request.setAttribute("listaM", M2);
			request.getRequestDispatcher("/ListaTuttiM.jsp").forward(request, response);
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
