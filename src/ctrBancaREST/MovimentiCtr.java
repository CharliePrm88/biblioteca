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

import proxy.Movimenti;
import proxy.ResponseMovimenti;
/**
 * Servlet implementation class MovimentiCtr
 */
@WebServlet("/MovimentiCtr")
public class MovimentiCtr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovimentiCtr() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void ritornalista(HttpServletRequest request, HttpServletResponse response) {
    	try {
			Client client = Client.create();
			WebResource webResource = client
			   .resource("http://localhost:8080/ewalletREST/ctr/Movimenti/listaM");
			ClientResponse responseRest = webResource.accept("application/json")
	                   .get(ClientResponse.class);
			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}
			String output = responseRest.getEntity(String.class);;
			//mappare l oggetto da JSON in object
			ObjectMapper mapper = new ObjectMapper();
			ResponseMovimenti result = mapper.readValue(output, ResponseMovimenti.class);
			Movimenti[] cc2 = result.getL1();
			request.setAttribute("listaM", cc2);
			request.getRequestDispatcher("/ListaTuttiMrest.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		  }
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				Movimenti M = null;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date cal = null;
				String s = request.getParameter("tipoOperazione");
				switch(s) {
				case "inserisciM":
					try {
						String data_creazione = request.getParameter("data_movimento");
						try {
							cal = sdf.parse(data_creazione);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Client client = Client.create();
						WebResource webResource = client
								   .resource("http://localhost:8080/ewalletREST/ctr/Movimenti/inserisci");
						ObjectMapper objectMapper = new ObjectMapper();
						M = new Movimenti(cal,Integer.parseInt(request.getParameter("iban")),Integer.parseInt(request.getParameter("id")),Integer.parseInt(request.getParameter("idTipoMovimento")),Float.parseFloat(request.getParameter("importo")));
						String carAsString = objectMapper.writeValueAsString(M);
						System.out.println("car:"+carAsString);
						ClientResponse responseRest = webResource.type("application/json").post(ClientResponse.class, carAsString);
						System.out.println("Output from Server .... \n");
						String output = responseRest.getEntity(String.class);
						System.out.println(output);
					  } catch (Exception e) {
						e.printStackTrace();
					  }
					request.getRequestDispatcher("/Inserimento.html").forward(request, response);
					break;
				case "cancellaM":
					try {
						String data_creazione = request.getParameter("data_movimento");
						try {
							cal = sdf.parse(data_creazione);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Client client = Client.create();
						WebResource webResource = client
								   .resource("http://localhost:8080/ewalletREST/ctr/Movimenti/cancella");
						ObjectMapper objectMapper = new ObjectMapper();
						M = new Movimenti(cal,Integer.parseInt(request.getParameter("iban")),Integer.parseInt(request.getParameter("id")),Integer.parseInt(request.getParameter("idTipoMovimento")),Float.parseFloat(request.getParameter("importo")));
						String carAsString = objectMapper.writeValueAsString(M);
						System.out.println("car:"+carAsString);
						ClientResponse responseRest = webResource.type("application/json")
						   .delete(ClientResponse.class, carAsString);
						System.out.println("Output from Server .... \n");
						String output = responseRest.getEntity(String.class);
						System.out.println(output);
						ritornalista(request,response);
					  } catch (Exception e) {
						e.printStackTrace();
					  }
					break;
				case "aggiornaM":
					try {
						String data_creazione = request.getParameter("data_movimento");
						try {
							cal = sdf.parse(data_creazione);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Client client = Client.create();
						WebResource webResource = client
								   .resource("http://localhost:8080/ewalletREST/ctr/Movimenti/aggiorna");
						ObjectMapper objectMapper = new ObjectMapper();
						M = new Movimenti(cal,Integer.parseInt(request.getParameter("iban")),Integer.parseInt(request.getParameter("id")),Integer.parseInt(request.getParameter("idTipoMovimento")),Float.parseFloat(request.getParameter("importo")));
						String carAsString = objectMapper.writeValueAsString(M);
						System.out.println("car:"+carAsString);
						ClientResponse responseRest = webResource.type("application/json")
						   .put(ClientResponse.class, carAsString);
						System.out.println("Output from Server .... \n");
						String output = responseRest.getEntity(String.class);
						System.out.println(output);
						ritornalista(request,response);
					  } catch (Exception e) {
						e.printStackTrace();
					  }
					break;
				case "ritornaM":
					try {
						Client client = Client.create();
						WebResource webResource = client
						   .resource("http://localhost:8080/ewalletREST/ctr/Movimenti/ritornaM");
						MultivaluedMap<String, String> parametri = new MultivaluedMapImpl();
						parametri.add("id", request.getParameter("id"));
						ClientResponse responseRest = webResource.queryParams(parametri).accept("application/json").get(ClientResponse.class);
						if (response.getStatus() != 200) {
						   throw new RuntimeException("Failed : HTTP error code : "
							+ response.getStatus());
						}
						String output = responseRest.getEntity(String.class);
						System.out.println(output);
						//mappare l oggetto da JSON in object
						ObjectMapper mapper = new ObjectMapper();
						ResponseMovimenti result = mapper.readValue(output, ResponseMovimenti.class);
						Movimenti cc2 = result.getM();
						request.setAttribute("CC", cc2);
						request.getRequestDispatcher("/ritornaMrest.jsp").forward(request, response);
					} catch (Exception e) {
						e.printStackTrace();
					  }
					break;
				case "ritornaListaM":
					ritornalista(request,response);
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
