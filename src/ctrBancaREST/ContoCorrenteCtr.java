package ctrBancaREST;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MultivaluedMap;

import org.codehaus.jackson.map.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import proxy.ContoCorrente;
import proxy.ResponseContoCorrente;
/**
 * Servlet implementation class ContoCorrenteCtr
 */
@WebServlet("/ContoCorrenteCtr")
public class ContoCorrenteCtr extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContoCorrenteCtr() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void lista(HttpServletRequest request, HttpServletResponse response) {
    	try {
			Client client = Client.create();
			WebResource webResource = client
			   .resource("http://localhost:8080/ewalletREST/ctr/ContoCorrente/listaCC");
			ClientResponse responseRest = webResource.accept("application/json")
	                   .get(ClientResponse.class);
			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}
			String output = responseRest.getEntity(String.class);;
			//mappare l oggetto da JSON in object
			ObjectMapper mapper = new ObjectMapper();
			ResponseContoCorrente result = mapper.readValue(output, ResponseContoCorrente.class);
			ContoCorrente[] cc2 = result.getL1();
			request.setAttribute("listaCC", cc2);
			request.getRequestDispatcher("/ListaTuttiCCrest.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		  }
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContoCorrente cc = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date cal = null;
		String s = request.getParameter("tipoOperazione");
		switch(s) {
		case "inserisciCC":
			try {
				String data_creazione = request.getParameter("data_creazione");
				try {
					cal = sdf.parse(data_creazione);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Client client = Client.create();
				WebResource webResource = client
						   .resource("http://localhost:8080/ewalletREST/ctr/ContoCorrente/inserisci");
				ObjectMapper objectMapper = new ObjectMapper();
				cc = new ContoCorrente(cal,Integer.parseInt(request.getParameter("iban")),Integer.parseInt(request.getParameter("idCliente")),Float.parseFloat(request.getParameter("saldo")));
				String carAsString = objectMapper.writeValueAsString(cc);
				System.out.println("car:"+carAsString);
				ClientResponse responseRest = webResource.type("application/json")
				   .post(ClientResponse.class, carAsString);
				
				System.out.println("Output from Server .... \n");
				String output = responseRest.getEntity(String.class);
				System.out.println(output);
			  } catch (Exception e) {
				e.printStackTrace();
			  }
			request.getRequestDispatcher("/Inserimento.html").forward(request, response);
			break;
		case "cancellaCC":
			try {
				String data_creazione = request.getParameter("data_creazione");
				try {
					cal = sdf.parse(data_creazione);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Client client = Client.create();
				WebResource webResource = client
						   .resource("http://localhost:8080/ewalletREST/ctr/ContoCorrente/cancella");
				ObjectMapper objectMapper = new ObjectMapper();
				cc = new ContoCorrente(cal,Integer.parseInt(request.getParameter("iban")),Integer.parseInt(request.getParameter("idCliente")),Float.parseFloat(request.getParameter("saldo")));
				String carAsString = objectMapper.writeValueAsString(cc);
				System.out.println("car:"+carAsString);
				ClientResponse responseRest = webResource.type("application/json")
				   .delete(ClientResponse.class, carAsString);
				if (response.getStatus() != 201) {
					throw new RuntimeException("Failed : HTTP error code : "
					     + response.getStatus());
				}
				System.out.println("Output from Server .... \n");
				String output = responseRest.getEntity(String.class);
				System.out.println(output);
			  } catch (Exception e) {
				e.printStackTrace();
			  }
			lista(request,response);
			break;
		case "aggiornaCC":
			try {
				String data_creazione = request.getParameter("data_creazione");
				try {
					cal = sdf.parse(data_creazione);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Client client = Client.create();
				WebResource webResource = client
						   .resource("http://localhost:8080/ewalletREST/ctr/ContoCorrente/aggiorna");
				ObjectMapper objectMapper = new ObjectMapper();
				cc = new ContoCorrente(cal,Integer.parseInt(request.getParameter("iban")),Integer.parseInt(request.getParameter("idCliente")),Float.parseFloat(request.getParameter("saldo")));
				String carAsString = objectMapper.writeValueAsString(cc);
				System.out.println("car:"+carAsString);
				ClientResponse responseRest = webResource.type("application/json")
				   .put(ClientResponse.class, carAsString);
				if (response.getStatus() != 201) {
					throw new RuntimeException("Failed : HTTP error code : "
					     + response.getStatus());
				}
				System.out.println("Output from Server .... \n");
				String output = responseRest.getEntity(String.class);
				System.out.println(output);
			  } catch (Exception e) {
				e.printStackTrace();
			  }
			lista(request,response);
			break;
		case "ritornaCC":
			try {
				Client client = Client.create();
				WebResource webResource = client
				   .resource("http://localhost:8080/ewalletREST/ctr/ContoCorrente/ritornaCC");
				MultivaluedMap<String, String> parametri = new MultivaluedMapImpl();
				parametri.add("idCliente", request.getParameter("idCliente"));
				ClientResponse responseRest = webResource.queryParams(parametri).accept("application/json").get(ClientResponse.class);
				if (response.getStatus() != 200) {
				   throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
				}
				String output = responseRest.getEntity(String.class);
				System.out.println(output);
				//mappare l oggetto da JSON in object
				ObjectMapper mapper = new ObjectMapper();
				ResponseContoCorrente result = mapper.readValue(output, ResponseContoCorrente.class);
				ContoCorrente cc2 = result.getCc();
				request.setAttribute("CC", cc2);
				request.getRequestDispatcher("/ritornaCCrest.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			  }
			break;
		case "ritornaListaCC":
			lista(request,response);
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
