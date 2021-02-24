package ctrBancaRESTSpring;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.core.MultivaluedMap;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
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

import proxy.ContoCorrente;
import proxy.ResponseContoCorrente;

@Controller
public class ContoCorrenteCtrRest {
	
	private ContoCorrente cc = null;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private Date cal = null;
	
	@RequestMapping(value = "/BancaREST/ContoCorrente/Lista", method = RequestMethod.GET)
	public String ListaContoCorrente(ModelMap model) {
			try {
				Client client = Client.create();
				WebResource webResource = client
				   .resource("http://localhost:8080/ewalletRESTMaven-0.0.1-SNAPSHOT/ctr/ContoCorrente/listaCC");
				ClientResponse responseRest = webResource.accept("application/json")
		                   .get(ClientResponse.class);
				String output = responseRest.getEntity(String.class);;
				ObjectMapper mapper = new ObjectMapper();
				ResponseContoCorrente result;
				result = mapper.readValue(output, ResponseContoCorrente.class);
				ContoCorrente[] cc2 = result.getL1();
				model.addAttribute("listaCC", cc2);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "BancaREST/ContoCorrente/ListaTuttiCC";
	}
	
	@RequestMapping(value = "/BancaREST/ContoCorrente/Ritorna", method = RequestMethod.GET)
	public ModelAndView ritornaCC(@RequestParam(value="idCliente",required = true,defaultValue ="0") String id) {
		ModelAndView model = new ModelAndView();
		try {
			Client client = Client.create();
			WebResource webResource = client
			   .resource("http://localhost:8080/ewalletRESTMaven-0.0.1-SNAPSHOT/ctr/ContoCorrente/ritornaCC");
			MultivaluedMap<String, String> parametri = new MultivaluedMapImpl();
			parametri.add("idCliente", id);
			ClientResponse responseRest = webResource.queryParams(parametri).accept("application/json").get(ClientResponse.class);
			String output = responseRest.getEntity(String.class);
			System.out.println(output);
			//mappare l oggetto da JSON in object
			ObjectMapper mapper = new ObjectMapper();
			ResponseContoCorrente result = mapper.readValue(output, ResponseContoCorrente.class);
			ContoCorrente cc2 = result.getCc();
			model.addObject("CC", cc2);
			model.setViewName("BancaREST/ContoCorrente/ritornaCC");
		} catch (Exception e) {
			e.printStackTrace();
		  }
		return model;
	}
	@RequestMapping(value = "/BancaREST/ContoCorrente/Inserisci", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView inserisciContoCorrente(String data_creazione,int iban,int idCliente,float saldo) {
		ModelAndView model = new ModelAndView();
		try {
			cal = sdf.parse(data_creazione);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Client client = Client.create();
		WebResource webResource = client
				   .resource("http://localhost:8080/ewalletRESTMaven-0.0.1-SNAPSHOT/ctr/ContoCorrente/inserisci");
		ObjectMapper objectMapper = new ObjectMapper();
		cc = new ContoCorrente(cal,iban,idCliente,saldo);
		String carAsString;
		try {
			carAsString = objectMapper.writeValueAsString(cc);
			ClientResponse responseRest = webResource.type("application/json")
					   .post(ClientResponse.class, carAsString);
			System.out.println(responseRest);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.setViewName("Inserimento");
		return model;
	}
	
	@RequestMapping(value = "/BancaREST/ContoCorrente/Cancella", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView cancellaCliente(String data_creazione,int iban,int idCliente,float saldo) {
		ModelAndView model = new ModelAndView();
			try {
				cal = sdf.parse(data_creazione);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Client client = Client.create();
			WebResource webResource = client
					   .resource("http://localhost:8080/ewalletRESTMaven-0.0.1-SNAPSHOT/ctr/ContoCorrente/cancella");
			ObjectMapper objectMapper = new ObjectMapper();
			cc = new ContoCorrente(cal,iban,idCliente,saldo);
			String carAsString;
			try {
				carAsString = objectMapper.writeValueAsString(cc);
				ClientResponse responseRest = webResource.type("application/json")
						   .delete(ClientResponse.class, carAsString);
				String output = responseRest.getEntity(String.class);
				System.out.println(output);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			webResource = client
					   .resource("http://localhost:8080/ewalletRESTMaven-0.0.1-SNAPSHOT/ctr/ContoCorrente/listaCC");
					ClientResponse responseRest = webResource.accept("application/json")
			                   .get(ClientResponse.class);
					String output = responseRest.getEntity(String.class);;
					ObjectMapper mapper = new ObjectMapper();
					ResponseContoCorrente result;
					try {
						result = mapper.readValue(output, ResponseContoCorrente.class);
						ContoCorrente[] cc2 = result.getL1();
						model.addObject("listaCC", cc2);	
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		model.setViewName("/BancaREST/ContoCorrente/ListaTuttiCC");
		return model;
	}
	@RequestMapping(value = "/BancaREST/ContoCorrente/Modifica", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView modificaCliente(String data_creazione,int iban,int idCliente,float saldo) {
		ModelAndView model = new ModelAndView();
		try {
			cal = sdf.parse(data_creazione);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Client client = Client.create();
		WebResource webResource = client
				   .resource("http://localhost:8080/ewalletRESTMaven-0.0.1-SNAPSHOT/ctr/ContoCorrente/aggiorna");
		ObjectMapper objectMapper = new ObjectMapper();
		cc = new ContoCorrente(cal,iban,idCliente,saldo);
		String carAsString;
		try {
			carAsString = objectMapper.writeValueAsString(cc);
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
				   .resource("http://localhost:8080/ewalletRESTMaven-0.0.1-SNAPSHOT/ctr/ContoCorrente/listaCC");
				ClientResponse responseRest = webResource.accept("application/json")
		                   .get(ClientResponse.class);
				String output = responseRest.getEntity(String.class);;
				ObjectMapper mapper = new ObjectMapper();
				ResponseContoCorrente result;
				try {
					result = mapper.readValue(output, ResponseContoCorrente.class);
					ContoCorrente[] cc2 = result.getL1();
					model.addObject("listaCC", cc2);	
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	model.setViewName("/BancaREST/ContoCorrente/ListaTuttiCC");
	return model;
	}
}
