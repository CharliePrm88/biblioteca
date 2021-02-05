package ctrBancaREST;

import java.io.IOException;
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
import proxy.ResponseTipoMovimento;
import proxy.TipoMovimento;
/**
 * Servlet implementation class TipoMovimentiCtr
 */
@WebServlet("/TipoMovimentiCtr")
public class TipoMovimentiCtr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TipoMovimentiCtr() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void lista(HttpServletRequest request, HttpServletResponse response) {
    	try {
			Client client = Client.create();
			WebResource webResource = client
			   .resource("http://localhost:8080/ewalletREST/ctr/TipoMovimenti/listaTM");
			ClientResponse responseRest = webResource.accept("application/json")
	                   .get(ClientResponse.class);
			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}
			String output = responseRest.getEntity(String.class);;
			//mappare l oggetto da JSON in object
			ObjectMapper mapper = new ObjectMapper();
			ResponseTipoMovimento result = mapper.readValue(output, ResponseTipoMovimento.class);
			TipoMovimento[] cc2 = result.getL1();
			request.setAttribute("listaTM", cc2);
			request.getRequestDispatcher("/ListaTuttiTMrest.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		  }
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TipoMovimento M = null;
		String s = request.getParameter("tipoOperazione");
		switch(s) {
		case "inserisciTM":
			try {
				Client client = Client.create();
				WebResource webResource = client
						   .resource("http://localhost:8080/ewalletREST/ctr/TipoMovimenti/inserisci");
				ObjectMapper objectMapper = new ObjectMapper();
				M = new TipoMovimento(request.getParameter("descrizione"),Integer.parseInt(request.getParameter("idTipoMovimento")));
				String carAsString = objectMapper.writeValueAsString(M);
				System.out.println("car:"+carAsString);
				ClientResponse responseRest = webResource.type("application/json")
				   .post(ClientResponse.class, carAsString);
				if (response.getStatus() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
					     + response.getStatus());
				}
				System.out.println("Output from Server .... \n");
				String output = responseRest.getEntity(String.class);
				System.out.println(output);
			  } catch (Exception e) {
				e.printStackTrace();
			  }
			request.getRequestDispatcher("/Inserimento.html").forward(request, response);
			break;
		case "cancellaTM":
			try {
				Client client = Client.create();
				WebResource webResource = client
						   .resource("http://localhost:8080/ewalletREST/ctr/TipoMovimenti/cancella");
				ObjectMapper objectMapper = new ObjectMapper();
				M = new TipoMovimento(request.getParameter("descrizione"),Integer.parseInt(request.getParameter("idTipoMovimento")));
				String carAsString = objectMapper.writeValueAsString(M);
				System.out.println("car:"+carAsString);
				ClientResponse responseRest = webResource.type("application/json")
				   .delete(ClientResponse.class, carAsString);
				if (response.getStatus() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
					     + response.getStatus());
				}
				System.out.println("Output from Server .... \n");
				String output = responseRest.getEntity(String.class);
				System.out.println(output);
				lista(request,response);
			  } catch (Exception e) {
				e.printStackTrace();
			  }
			break;
		case "aggiornaTM":
			try {
				Client client = Client.create();
				WebResource webResource = client
						   .resource("http://localhost:8080/ewalletREST/ctr/TipoMovimenti/aggiorna");
				ObjectMapper objectMapper = new ObjectMapper();
				M = new TipoMovimento(request.getParameter("descrizione"),Integer.parseInt(request.getParameter("idTipoMovimento")));
				String carAsString = objectMapper.writeValueAsString(M);
				System.out.println("car:"+carAsString);
				ClientResponse responseRest = webResource.type("application/json")
				   .put(ClientResponse.class, carAsString);
				if (response.getStatus() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
					     + response.getStatus());
				}
				System.out.println("Output from Server .... \n");
				String output = responseRest.getEntity(String.class);
				System.out.println(output);
				lista(request,response);
			  } catch (Exception e) {
				e.printStackTrace();
			  }
			break;
		case "ritornaTM":
			try {
				Client client = Client.create();
				WebResource webResource = client
				   .resource("http://localhost:8080/ewalletREST/ctr/TipoMovimenti/ritornaTM");
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
				ResponseTipoMovimento result = mapper.readValue(output, ResponseTipoMovimento.class);
				TipoMovimento cc2 = result.getTm();
				request.setAttribute("TM", cc2);
				request.getRequestDispatcher("/ritornaTMrest.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			  }
			break;
		case "ritornaListaTM":
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
