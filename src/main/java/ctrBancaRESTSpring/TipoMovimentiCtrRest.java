package ctrBancaRESTSpring;

import java.io.IOException;
import javax.ws.rs.core.MultivaluedMap;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import proxy.ResponseTipoMovimento;
import proxy.TipoMovimento;

@Controller
public class TipoMovimentiCtrRest {
	TipoMovimento M = null;
	@RequestMapping(value = "/BancaREST/TipoMovimento/Lista", method = RequestMethod.GET)
	public String ListaTipoMovimento(ModelMap model) {
		Client client = Client.create();
		WebResource webResource = client
		   .resource("http://localhost:8080/ewalletRESTMaven-0.0.1-SNAPSHOT/ctr/TipoMovimenti/listaTM");
		ClientResponse responseRest = webResource.accept("application/json")
                   .get(ClientResponse.class);
		String output = responseRest.getEntity(String.class);;
		ObjectMapper mapper = new ObjectMapper();
		ResponseTipoMovimento result;
		try {
			result = mapper.readValue(output, ResponseTipoMovimento.class);
			TipoMovimento[] cc2 = result.getL1();
			model.addAttribute("listaTM", cc2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "BancaREST/ContoCorrente/ListaTuttiTMrest";
	}
	
	@RequestMapping(value = "/BancaREST/TipoMovimento/Ritorna", method = RequestMethod.GET)
	public ModelAndView ritornaCC(@RequestParam(value="id",required = true,defaultValue ="0") String id) {
		ModelAndView model = new ModelAndView();
		Client client = Client.create();
		WebResource webResource = client
		   .resource("http://localhost:8080/ewalletRESTMaven-0.0.1-SNAPSHOT/ctr/TipoMovimenti/ritornaTM");
		MultivaluedMap<String, String> parametri = new MultivaluedMapImpl();
		parametri.add("id", id);
		ClientResponse responseRest = webResource.queryParams(parametri).accept("application/json").get(ClientResponse.class);
		String output = responseRest.getEntity(String.class);
		System.out.println(output);
		//mappare l oggetto da JSON in object
		ObjectMapper mapper = new ObjectMapper();
		ResponseTipoMovimento result;
		try {
			result = mapper.readValue(output, ResponseTipoMovimento.class);
			TipoMovimento cc2 = result.getTm();
			model.addObject("TM", cc2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.setViewName("BancaREST/TipoMovimento/ritornaTMrest");
		return model;
	}
	
	@RequestMapping(value ="/BancaREST/TipoMovimento/Inserisci", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView inserisciTipoMovimento(String descrizione,int idTipoMovimento) {
		ModelAndView model = new ModelAndView();
		Client client = Client.create();
		WebResource webResource = client
				   .resource("http://localhost:8080/ewalletRESTMaven-0.0.1-SNAPSHOT/ctr/TipoMovimenti/inserisci");
		ObjectMapper objectMapper = new ObjectMapper();
		M = new TipoMovimento(descrizione,idTipoMovimento);
		String carAsString;
		try {
			carAsString = objectMapper.writeValueAsString(M);
			ClientResponse responseRest = webResource.type("application/json")
			   .post(ClientResponse.class, carAsString);
			String output = responseRest.getEntity(String.class);
			System.out.println(output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.setViewName("Inserimento");
		return model;
	}
	
	@RequestMapping(value = "/BancaREST/TipoMovimento/Cancella", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView cancellaTipoMovimento(String descrizione,int idTipoMovimento) {
		ModelAndView model = new ModelAndView();
		Client client = Client.create();
		WebResource webResource = client
				   .resource("http://localhost:8080/ewalletRESTMaven-0.0.1-SNAPSHOT/ctr/TipoMovimenti/cancella");
		ObjectMapper objectMapper = new ObjectMapper();
		M = new TipoMovimento(descrizione,idTipoMovimento);
		String carAsString;
		try {
			carAsString = objectMapper.writeValueAsString(M);
			ClientResponse responseRest = webResource.type("application/json")
			   .delete(ClientResponse.class, carAsString);
			String output = responseRest.getEntity(String.class);
			System.out.println(output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		webResource = client
				   .resource("http://localhost:8080/ewalletRESTMaven-0.0.1-SNAPSHOT/ctr/TipoMovimenti/listaTM");
				ClientResponse responseRest = webResource.accept("application/json")
		                   .get(ClientResponse.class);
				String output = responseRest.getEntity(String.class);;
				ObjectMapper mapper = new ObjectMapper();
				ResponseTipoMovimento result;
				try {
					result = mapper.readValue(output, ResponseTipoMovimento.class);
					TipoMovimento[] cc2 = result.getL1();
					model.addObject("listaTM", cc2);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		model.setViewName("/BancaREST/TipoMovimento/ListaTuttiTM");
		return model;
	}
	
	@RequestMapping(value = "/BancaREST/TipoMovimento/Modifica", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView modificaTipoMovimento(String descrizione,int idTipoMovimento) {
		ModelAndView model = new ModelAndView();
		Client client = Client.create();
		WebResource webResource = client
				   .resource("http://localhost:8080/ewalletRESTMaven-0.0.1-SNAPSHOT/ctr/TipoMovimenti/aggiorna");
		ObjectMapper objectMapper = new ObjectMapper();
		M = new TipoMovimento(descrizione,idTipoMovimento);
		String carAsString;
		try {
			carAsString = objectMapper.writeValueAsString(M);
			ClientResponse responseRest = webResource.type("application/json")
			   .put(ClientResponse.class, carAsString);
			String output = responseRest.getEntity(String.class);
			System.out.println(output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		webResource = client
				   .resource("http://localhost:8080/ewalletRESTMaven-0.0.1-SNAPSHOT/ctr/TipoMovimenti/listaTM");
				ClientResponse responseRest = webResource.accept("application/json")
		                   .get(ClientResponse.class);
				String output = responseRest.getEntity(String.class);;
				ObjectMapper mapper = new ObjectMapper();
				ResponseTipoMovimento result;
				try {
					result = mapper.readValue(output, ResponseTipoMovimento.class);
					TipoMovimento[] cc2 = result.getL1();
					model.addObject("listaTM", cc2);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		model.setViewName("/BancaREST/TipoMovimento/ListaTuttiTMrest");
		return model;
	}
}
