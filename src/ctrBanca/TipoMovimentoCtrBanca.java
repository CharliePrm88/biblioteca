package ctrBanca;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proxy.TipoMovimento;
import proxy.TipoMovimentoCtrProxy;
import proxy.ResponseTipoMovimento;

/**
 * Servlet implementation class TipoTipoMovimentoCtrBanca
 */
@WebServlet("/TipoMovimentoCtrBanca")
public class TipoMovimentoCtrBanca extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TipoMovimentoCtrProxy Mcp = new TipoMovimentoCtrProxy();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TipoMovimentoCtrBanca() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TipoMovimento M = null;
		String s = request.getParameter("tipoOperazione");
		switch(s) {
		case "inserisciTM":
			M = new TipoMovimento(request.getParameter("descrizione"),Integer.parseInt(request.getParameter("idTipoMovimento")));
			Mcp.inserisciTM(M);
			request.getRequestDispatcher("/Inserimento.html").forward(request, response);
			break;
		case "cancellaTM":
			M = new TipoMovimento(request.getParameter("descrizione"),Integer.parseInt(request.getParameter("idTipoMovimento")));
			Mcp.cancellaTM(M);
			ResponseTipoMovimento l4 = Mcp.ritornaListaTM();
			TipoMovimento[] M4 = l4.getL1();
			request.setAttribute("listaTM", M4);
			request.getRequestDispatcher("ListaTuttiTm.jsp").forward(request, response);
			break;
		case "aggiornaTM":
			M = new TipoMovimento(request.getParameter("descrizione"),Integer.parseInt(request.getParameter("idTipoMovimento")));
			Mcp.modificaTM(M);
			ResponseTipoMovimento l3 = Mcp.ritornaListaTM();
			TipoMovimento[] M3 = l3.getL1();
			request.setAttribute("listaTM", M3);
			request.getRequestDispatcher("ListaTuttiTm.jsp").forward(request, response);
			break;
		case "ritornaTM":
			ResponseTipoMovimento M1=Mcp.ritornaTM(Integer.parseInt(request.getParameter("id")));
			TipoMovimento l2= M1.getTm();
			request.setAttribute("TM", l2);
			request.getRequestDispatcher("/ritornaTM.jsp").forward(request, response);
			break;
		case "ritornaListaTM":
			ResponseTipoMovimento l1 = Mcp.ritornaListaTM();
			TipoMovimento[] M2 = l1.getL1();
			request.setAttribute("listaTM", M2);
			request.getRequestDispatcher("/ListaTuttiTm.jsp").forward(request, response);
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
