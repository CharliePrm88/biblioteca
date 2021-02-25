package ctrBancaRESTSpring;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import proxy.Movimenti;
import proxy.ResponseMovimenti;

@Controller
public class MovimentiCtrRest {
	private Movimenti M = null;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private Date cal = null;
	
	@RequestMapping(value = "/BancaREST/Movimento/Lista", method = RequestMethod.GET)
	public String ListaMovimenti(ModelMap model) {
		Client client = Client.create();
		WebResource webResource = client
		   .resource("http://localhost:8080/ewalletRESTMaven-0.0.1-SNAPSHOT/ctr/Movimenti/listaM");
		ClientResponse responseRest = webResource.accept("application/json")
                   .get(ClientResponse.class);
		String output = responseRest.getEntity(String.class);;
		ObjectMapper mapper = new ObjectMapper();
		ResponseMovimenti result;
		try {
			result = mapper.readValue(output, ResponseMovimenti.class);
			Movimenti[] cc2 = result.getL1();
			model.addAttribute("listaM", cc2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return "BancaREST/Movimenti/ListaTuttiMrest";
	}
	
	@RequestMapping(value = "/BancaREST/Movimento/Ritorna", method = RequestMethod.GET)
	public ModelAndView ritornaMovimento(@RequestParam(value="idCliente",required = true,defaultValue ="0") String id) {
		ModelAndView model = new ModelAndView();
		Client client = Client.create();
		WebResource webResource = client
		   .resource("http://localhost:8080/ewalletRESTMaven-0.0.1-SNAPSHOT/ctr/Movimenti/ritornaM");
		MultivaluedMap<String, String> parametri = new MultivaluedMapImpl();
		parametri.add("id", id);
		ClientResponse responseRest = webResource.queryParams(parametri).accept("application/json").get(ClientResponse.class);
		String output = responseRest.getEntity(String.class);
		System.out.println(output);
		//mappare l oggetto da JSON in object
		ObjectMapper mapper = new ObjectMapper();
		ResponseMovimenti result;
		try {
			result = mapper.readValue(output, ResponseMovimenti.class);
			Movimenti cc2 = result.getM();
			model.addObject("M", cc2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.setViewName("BancaREST/Movimento/ritornaMrest");
		return model;
	}
	@RequestMapping(value = "/BancaREST/Movimento/Inserisci", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView inserisciMovimento(String data_movimento,int iban,int id,int idTipoMovimento,float importo) {
		ModelAndView model = new ModelAndView();
		try {
			cal = sdf.parse(data_movimento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Client client = Client.create();
		WebResource webResource = client
				   .resource("http://localhost:8080/ewalletRESTMaven-0.0.1-SNAPSHOT/ctr/Movimenti/inserisci");
		ObjectMapper objectMapper = new ObjectMapper();
		M = new Movimenti(cal,iban,id,idTipoMovimento,importo);
		String carAsString;
		try {
			carAsString = objectMapper.writeValueAsString(M);
			ClientResponse responseRest = webResource.type("application/json").post(ClientResponse.class, carAsString);
			String output = responseRest.getEntity(String.class);
			System.out.println(output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.setViewName("Inserimento");
		return model;
	}
	@RequestMapping(value = "/BancaREST/Movimento/Cancella", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView cancellaMovimento(String data_movimento,int iban,int id,int idTipoMovimento,float importo) {
		ModelAndView model = new ModelAndView();
		try {
			cal = sdf.parse(data_movimento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Client client = Client.create();
		WebResource webResource = client
				   .resource("http://localhost:8080/ewalletRESTMaven-0.0.1-SNAPSHOT/ctr/Movimenti/cancella");
		ObjectMapper objectMapper = new ObjectMapper();
		M = new Movimenti(cal,iban,id,idTipoMovimento,importo);
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
				   .resource("http://localhost:8080/ewalletRESTMaven-0.0.1-SNAPSHOT/ctr/Movimenti/listaM");
				ClientResponse responseRest = webResource.accept("application/json")
		                   .get(ClientResponse.class);
				String output = responseRest.getEntity(String.class);;
				ObjectMapper mapper = new ObjectMapper();
				ResponseMovimenti result;
				try {
					result = mapper.readValue(output, ResponseMovimenti.class);
					Movimenti[] cc2 = result.getL1();
					model.addObject("listaM", cc2);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		model.setViewName("/BancaREST/Movimento/ListaTuttiMrest");
		return model;
	}
	
	@RequestMapping(value = "/BancaREST/Movimento/Modifica", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView modificaMovimento(String data_movimento,int iban,int id,int idTipoMovimento,float importo) {
		ModelAndView model = new ModelAndView();
		try {
			cal = sdf.parse(data_movimento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Client client = Client.create();
		WebResource webResource = client
				   .resource("http://localhost:8080/ewalletRESTMaven-0.0.1-SNAPSHOT/ctr/Movimenti/aggiorna");
		ObjectMapper objectMapper = new ObjectMapper();
		M = new Movimenti(cal,iban,id,idTipoMovimento,importo);
		String carAsString;
		try {
			carAsString = objectMapper.writeValueAsString(M);
			System.out.println("car:"+carAsString);
			ClientResponse responseRest = webResource.type("application/json")
			   .put(ClientResponse.class, carAsString);
			System.out.println("Output from Server .... \n");
			String output = responseRest.getEntity(String.class);
			System.out.println(output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		webResource = client
				   .resource("http://localhost:8080/ewalletRESTMaven-0.0.1-SNAPSHOT/ctr/Movimenti/listaM");
				ClientResponse responseRest = webResource.accept("application/json")
		                   .get(ClientResponse.class);
				String output = responseRest.getEntity(String.class);;
				ObjectMapper mapper = new ObjectMapper();
				ResponseMovimenti result;
				try {
					result = mapper.readValue(output, ResponseMovimenti.class);
					Movimenti[] cc2 = result.getL1();
					model.addObject("listaM", cc2);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		model.setViewName("/BancaREST/Movimento/ListaTuttiMrest");
		return model;
	}
	
}
